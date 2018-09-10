package com.van.dusty.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-09 16:18
 **/
public class HashCache {
    private JedisPool jedisPool;

    public HashCache() {
    }

    public JedisPool getJedisPool() {
        return this.jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public boolean put(String key, String field, String value) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.hset(key, field, value);
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

    public String get(String key, String field) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        String var5;
        try {
            if (jedis == null) {
                return null;
            }

            var5 = jedis.hget(key, field);
        } catch (Exception var9) {
            flag = false;
            var9.printStackTrace();
            return null;
        } finally {
            if (flag) {
                jedis.close();
            } else {
                this.jedisPool.close();
            }

        }

        return var5;
    }

    public boolean remove(String key, String field) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.hdel(key, new String[]{field});
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
