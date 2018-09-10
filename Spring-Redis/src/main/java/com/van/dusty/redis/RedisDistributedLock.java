package com.van.dusty.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-09 16:22
 **/
public class RedisDistributedLock {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisDistributedLock.class);
    private static final int DEFAULT_SINGLE_EXPIRE_TIME = 3;
    private static final int DEFAULT_BATCH_EXPIRE_TIME = 6;
    private JedisPool jedisPool;

    public RedisDistributedLock() {
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public boolean tryLock(String key) {
        return this.tryLock((String)key, 0L, (TimeUnit)null);
    }

    public boolean tryLock(String key, long timeout, TimeUnit unit) {
        Jedis jedis = null;

        try {
            jedis = this.getResource();
            long nano = System.nanoTime();

            while(true) {
                LOGGER.debug("try lock key: " + key);
                Long i = jedis.setnx(key, key);
                if (i.longValue() == 1L) {
                    jedis.expire(key, 3);
                    LOGGER.debug("get lock, key: " + key + " , expire in " + 3 + " seconds.");
                    boolean var16 = Boolean.TRUE.booleanValue();
                    return var16;
                }

                if (LOGGER.isDebugEnabled()) {
                    String desc = jedis.get(key);
                    LOGGER.debug("key: " + key + " locked by another business：" + desc);
                }

                if (timeout != 0L) {
                    Thread.sleep(300L);
                    if (System.nanoTime() - nano < unit.toNanos(timeout)) {
                        continue;
                    }
                }

                boolean var15 = Boolean.FALSE.booleanValue();
                return var15;
            }
        } catch (Exception var13) {
            LOGGER.error(var13.getMessage(), var13);
        } finally {
            this.returnResource(jedis);
        }

        return Boolean.FALSE.booleanValue();
    }

    public void lock(String key) {
        Jedis jedis = null;

        try {
            jedis = this.getResource();

            while(true) {
                LOGGER.debug("lock key: " + key);
                Long i = jedis.setnx(key, key);
                if (i.longValue() == 1L) {
                    jedis.expire(key, 3);
                    LOGGER.debug("get lock, key: " + key + " , expire in " + 3 + " seconds.");
                    return;
                }

                if (LOGGER.isDebugEnabled()) {
                    String desc = jedis.get(key);
                    LOGGER.debug("key: " + key + " locked by another business：" + desc);
                }

                Thread.sleep(300L);
            }
        } catch (Exception var8) {
            LOGGER.error(var8.getMessage(), var8);
        } finally {
            this.returnResource(jedis);
        }

    }

    public boolean tryLockPermanently(String key, long timeout, TimeUnit unit) {
        Jedis jedis = null;

        try {
            jedis = this.getResource();
            long nano = System.nanoTime();

            do {
                LOGGER.debug("lock key: " + key);
                Long i = jedis.setnx(key, key);
                if (i.longValue() == 1L) {
                    LOGGER.debug("get lock, key: " + key + " , expire in " + 3 + " seconds.");
                    boolean var16 = Boolean.TRUE.booleanValue();
                    return var16;
                }

                if (LOGGER.isDebugEnabled()) {
                    String desc = jedis.get(key);
                    LOGGER.debug("key: " + key + " locked by another business：" + desc);
                }

                Thread.sleep(300L);
            } while(System.nanoTime() - nano < unit.toNanos(timeout));

            boolean var15 = Boolean.FALSE.booleanValue();
            return var15;
        } catch (Exception var13) {
            LOGGER.error(var13.getMessage(), var13);
        } finally {
            this.returnResource(jedis);
        }

        return Boolean.FALSE.booleanValue();
    }

    public void unLock(String key) {
        List<String> list = new ArrayList();
        list.add(key);
        this.unLock((List)list);
    }

    public void unlockPattern(String key) {
        Jedis jedis = null;

        try {
            jedis = this.getResource();
            Set<String> keys = jedis.keys(key.concat("*"));
            if (keys.size() > 0) {
                jedis.del((String[])keys.toArray(new String[keys.size()]));
                LOGGER.debug("release lock, keys :" + keys);
            }
        } catch (Exception var7) {
            LOGGER.error(var7.getMessage(), var7);
        } finally {
            this.returnResource(jedis);
        }

    }

    public boolean tryLock(List<String> keyList) {
        return this.tryLock((List)keyList, 0L, (TimeUnit)null);
    }

    public boolean tryLock(List<String> keyList, long timeout, TimeUnit unit) {
        Jedis jedis = null;

        try {
            List<String> needLocking = new CopyOnWriteArrayList();
            List<String> locked = new CopyOnWriteArrayList();
            jedis = this.getResource();
            long nano = System.nanoTime();

            do {
                Pipeline pipeline = jedis.pipelined();
                Iterator var11 = keyList.iterator();

                while(var11.hasNext()) {
                    String key = (String)var11.next();
                    needLocking.add(key);
                    pipeline.setnx(key, key);
                }

                LOGGER.debug("try lock keys: " + needLocking);
                List<Object> results = pipeline.syncAndReturnAll();

                for(int i = 0; i < results.size(); ++i) {
                    Long result = (Long)results.get(i);
                    String key = (String)needLocking.get(i);
                    if (result.longValue() == 1L) {
                        jedis.expire(key, 6);
                        locked.add(key);
                    }
                }

                needLocking.removeAll(locked);
                if (CollectionUtils.isEmpty(needLocking)) {
                    boolean var23 = true;
                    return var23;
                }

                LOGGER.debug("keys: " + needLocking + " locked by another business：");
                if (timeout == 0L) {
                    break;
                }

                Thread.sleep(500L);
            } while(System.nanoTime() - nano < unit.toNanos(timeout));

            if (!CollectionUtils.isEmpty(locked)) {
                jedis.del((String[])locked.toArray(new String[0]));
            }

            boolean var20 = false;
            return var20;
        } catch (Exception var18) {
            LOGGER.error(var18.getMessage(), var18);
        } finally {
            this.returnResource(jedis);
        }

        return true;
    }

    public void unLock(List<String> keyList) {
        Jedis jedis = null;

        try {
            jedis = this.getResource();
            jedis.del((String[])keyList.toArray(new String[keyList.size()]));
            LOGGER.debug("release lock, keys :" + keyList);
        } catch (Exception var7) {
            LOGGER.error(var7.getMessage(), var7);
        } finally {
            this.returnResource(jedis);
        }

    }

    private Jedis getResource() {
        return this.jedisPool.getResource();
    }

    private void returnResource(Jedis jedis) {
        if (jedis != null) {
            try {
                jedis.close();
            } catch (Exception var3) {
                LOGGER.error(var3.getMessage(), var3);
            }

        }
    }

}
