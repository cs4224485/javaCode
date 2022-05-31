package com.harry.redistest.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
    private  static JedisPool jedisPool;

    static{
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPool = new JedisPool(jedisPoolConfig, "ip", 6379, 100000);
    }
    public static Jedis getJedis() throws Exception {
        if (jedisPool != null){
            return jedisPool.getResource();
        }
        throw new Exception("Jedispool is not ok");
    }
}
