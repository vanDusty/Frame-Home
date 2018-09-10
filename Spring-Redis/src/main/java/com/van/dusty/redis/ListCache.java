package com.van.dusty.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-09 16:17
 **/
public class ListCache {
    private JedisPool jedisPool;

    public ListCache() {
    }

    public JedisPool getJedisPool() {
        return this.jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public boolean lput(String key, String value) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.lpush(key, new String[]{value});
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

    public boolean rput(String key, String value) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.rpush(key, new String[]{value});
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

    public boolean put(String key, long index, String value) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                long length = jedis.llen(key).longValue();
                if (jedis.exists(key).booleanValue() && index <= length && index >= 1L) {
                    jedis.lset(key, index, value);
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

    public boolean put(String key, int time) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                if (jedis.exists(key).booleanValue()) {
                    jedis.expire(key, time);
                } else {
                    flag = false;
                }
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

    public String get(String key, long index) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        String var6;
        try {
            if (jedis == null) {
                return null;
            }

            var6 = jedis.lindex(key, index);
        } catch (Exception var10) {
            flag = false;
            var10.printStackTrace();
            return null;
        } finally {
            if (flag) {
                jedis.close();
            } else {
                this.jedisPool.close();
            }

        }

        return var6;
    }

    public List<String> get(String key, long start, long end) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        List var8;
        try {
            if (jedis == null) {
                return null;
            }

            var8 = jedis.lrange(key, start, end);
        } catch (Exception var12) {
            flag = false;
            var12.printStackTrace();
            return null;
        } finally {
            if (flag) {
                jedis.close();
            } else {
                this.jedisPool.close();
            }

        }

        return var8;
    }

    public boolean lremove(String key) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.lpop(key);
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

    public boolean rremove(String key) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.rpop(key);
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

    public boolean remove(String key, long count, String value) {
        boolean flag = true;
        Jedis jedis = this.jedisPool.getResource();

        try {
            if (jedis != null) {
                jedis.lrem(key, count, value);
            }
        } catch (Exception var11) {
            flag = false;
            var11.printStackTrace();
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
