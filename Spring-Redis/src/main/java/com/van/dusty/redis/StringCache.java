package com.van.dusty.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-03 18:55
 **/

public class StringCache {
    protected JedisPool jedisPool;

    public StringCache() {
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public boolean put(String key, String value) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.set(key, value);
            }
        } catch (Exception var9) {
            flag = false;
            var9.printStackTrace();
        } finally {
            if (flag) {
                jedis.close();
                return true;
            }

            this.jedisPool.close();
        }

        return false;
    }

    public String get(String key) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        String var4;
        try {
            if (jedis == null) {
                return null;
            }

            var4 = jedis.get(key);
        } catch (Exception var8) {
            flag = false;
            var8.printStackTrace();
            return null;
        } finally {
            if (flag) {
                jedis.close();
            } else {
                this.jedisPool.close();
            }

        }

        return var4;
    }

    public boolean remove(String key) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.del(key);
            }
        } catch (Exception var8) {
            flag = false;
            var8.printStackTrace();
        } finally {
            if (flag) {
                jedis.close();
                return true;
            }

            this.jedisPool.close();
        }

        return false;
    }

    public boolean put(String key, String value, int second) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.set(key, value);
                if (jedis.exists(key).booleanValue()) {
                    jedis.expire(key, second);
                }
            }
        } catch (Exception var10) {
            flag = false;
            var10.printStackTrace();
        } finally {
            if (flag) {
                jedis.close();
                return true;
            }

            this.jedisPool.close();
        }

        return false;
    }

    public boolean removeAndPublish(String cacheName, String key, CacheTypeEnum cacheTypeEnum) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.del(key);
                if (cacheTypeEnum.equals(CacheTypeEnum.L2Cache)) {
                    String message = cacheName + " " + key;
                    jedis.publish(ChannelEnum.CacheChannel.name(), message);
                }
            }
        } catch (Exception var10) {
            flag = false;
            var10.printStackTrace();
        } finally {
            if (flag) {
                jedis.close();
                return true;
            }

            this.jedisPool.close();
        }

        return false;
    }

    public boolean removePatternAndPublish(CacheKeyEnum cacheKeyEnum, CacheTypeEnum cacheTypeEnum) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                String name = cacheKeyEnum.name();
                Set<String> keys = jedis.keys(name.concat("*"));
                Iterator var7 = keys.iterator();

                while(var7.hasNext()) {
                    String key = (String)var7.next();
                    jedis.del(key);
                }

                if (cacheTypeEnum.equals(CacheTypeEnum.L2Cache)) {
                    String message = name + " removeAll";
                    jedis.publish(ChannelEnum.CacheChannel.name(), message);
                }
            }
        } catch (Exception var12) {
            flag = false;
            var12.printStackTrace();
        } finally {
            if (flag) {
                jedis.close();
                return true;
            }

            this.jedisPool.close();
        }

        return false;
    }

}
