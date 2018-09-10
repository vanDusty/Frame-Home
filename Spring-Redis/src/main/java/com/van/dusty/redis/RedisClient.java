package com.van.dusty.redis;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-09 16:20
 **/
public class RedisClient implements Serializable {
    private JedisPool jedisPool;
    private XStream xstream;

    public RedisClient() {
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public void set(final String key, final Object value, final int seconds) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else if (null == value) {
            throw new IllegalArgumentException("Cached value cannot be null.");
        } else {
            this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    byte[] byteArray = RedisClient.this.serialize(value);
                    jedis.set(key.getBytes(), byteArray);
                    jedis.expire(key.getBytes(), seconds);
                    return null;
                }
            });
        }
    }

    public void set(final String key, final Object value) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else if (null == value) {
            throw new IllegalArgumentException("Cached value cannot be null.");
        } else {
            this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    byte[] byteArray = RedisClient.this.serialize(value);
                    jedis.set(key.getBytes(), byteArray);
                    return null;
                }
            });
        }
    }

    public void expire(final String key, final int seconds) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else {
            this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    jedis.expire(key.getBytes(), seconds);
                    return null;
                }
            });
        }
    }

    public Object get(final String key) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else {
            return this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    byte[] bs = jedis.get(key.getBytes());
                    return null == bs ? null : RedisClient.this.deserialize(bs);
                }
            });
        }
    }

    public boolean exists(final String key) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else {
            return ((Boolean)this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    Boolean exists = jedis.exists(key.getBytes());
                    return exists;
                }
            })).booleanValue();
        }
    }

    public void del(final String key) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else {
            this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    jedis.del(key.getBytes());
                    return null;
                }
            });
        }
    }

    public Long lpush(final String key, final Object value) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else if (null == value) {
            throw new IllegalArgumentException("Cached value cannot be null.");
        } else {
            return (Long)this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    byte[] byteArray = RedisClient.this.serialize(value);
                    Long index = jedis.lpush(key.getBytes(), new byte[][]{byteArray});
                    return index;
                }
            });
        }
    }

    public Long rpush(final String key, final Object value) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else if (null == value) {
            throw new IllegalArgumentException("Cached value cannot be null.");
        } else {
            return (Long)this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    byte[] byteArray = RedisClient.this.serialize(value);
                    Long index = jedis.rpush(key.getBytes(), new byte[][]{byteArray});
                    return index;
                }
            });
        }
    }

    public Object lpop(final String key) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else {
            return this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    byte[] bs = jedis.lpop(key.getBytes());
                    return null == bs ? null : RedisClient.this.deserialize(bs);
                }
            });
        }
    }

    public Object rpop(final String key) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else {
            return this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    byte[] bs = jedis.rpop(key.getBytes());
                    return null == bs ? null : RedisClient.this.deserialize(bs);
                }
            });
        }
    }

    public Object blpop(final String key) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else {
            return this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    List<byte[]> bss = jedis.blpop(0, new byte[][]{key.getBytes()});
                    return null != bss && bss.size() >= 2 ? RedisClient.this.deserialize((byte[])bss.get(1)) : null;
                }
            });
        }
    }

    public Object brpop(final String key) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else {
            return this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    List<byte[]> bss = jedis.brpop(0, new byte[][]{key.getBytes()});
                    return null != bss && bss.size() >= 2 ? RedisClient.this.deserialize((byte[])bss.get(1)) : null;
                }
            });
        }
    }

    public void unblock(String key) {
        this.lpush(key, new RedisClient.NullValue());
    }

    public Long llen(final String key) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else {
            return (Long)this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    Long len = jedis.llen(key.getBytes());
                    return len;
                }
            });
        }
    }

    public Map<String, Object> findByKeyLike(final String key) {
        if (null == key) {
            throw new IllegalArgumentException("Cached key cannot be null.");
        } else {
            return (Map)this.execute(new RedisClient.Execution() {
                public Object process(Jedis jedis) {
                    Set<byte[]> keys = jedis.keys(key.getBytes());
                    Map<String, Object> answer = new LinkedHashMap();
                    Iterator var4 = keys.iterator();

                    while(var4.hasNext()) {
                        byte[] bs = (byte[])var4.next();
                        byte[] vbs = jedis.get(bs);
                        if (null == vbs) {
                            answer.put(new String(bs), (Object)null);
                        } else {
                            answer.put(new String(bs), RedisClient.this.deserialize(vbs));
                        }
                    }

                    return answer;
                }
            });
        }
    }

    public Object execute(RedisClient.Execution execution) {
        Jedis jedis = null;

        Object var4;
        try {
            jedis = this.jedisPool.getResource();
            Object result = execution.process(jedis);
            var4 = result;
        } catch (JedisConnectionException var8) {
            throw var8;
        } finally {
            if (null != jedis) {
                jedis.close();
            }

        }

        return var4;
    }

    private Object deserialize(byte[] data) {
        Object fromXML = null;

        try {
            fromXML = this.xstream.fromXML(new String(data, "utf-8"));
        } catch (UnsupportedEncodingException var4) {
            var4.printStackTrace();
        }

        return fromXML instanceof RedisClient.NullValue ? null : fromXML;
    }

    private byte[] serialize(Object value) {
        this.xstream.processAnnotations(value.getClass());

        try {
            return this.xstream.toXML(value).getBytes("utf-8");
        } catch (UnsupportedEncodingException var3) {
            var3.printStackTrace();
            return this.xstream.toXML(value).getBytes();
        }
    }

    public static void main(String[] args) {
    }

    public void afterPropertiesSet() throws Exception {
        this.xstream = new XStream(new DomDriver("utf8"));
    }

    private static class NullValue {
        private NullValue() {
        }
    }

    private interface Execution {
        Object process(Jedis var1);
    }

}
