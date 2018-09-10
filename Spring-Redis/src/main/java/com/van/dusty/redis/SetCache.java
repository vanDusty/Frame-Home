package com.van.dusty.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-09 16:19
 **/
public class SetCache {
    private JedisPool jedisPool;

    public SetCache() {
    }

    public JedisPool getJedisPool() {
        return this.jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public boolean put(String key, String value) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.sadd(key, new String[]{value});
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

    public Set<String> getAllSet(String key) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                Set var4 = jedis.smembers(key);
                return var4;
            }
        } catch (Exception var8) {
            flag = false;
            var8.printStackTrace();
        } finally {
            if (flag) {
                jedis.close();
            } else {
                this.jedisPool.close();
            }

        }

        return null;
    }

    public boolean remove(String key, String value) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.srem(key, new String[]{value});
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

    public boolean put(String key, int second) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null && jedis.exists(key).booleanValue()) {
                jedis.expire(key, second);
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

}
