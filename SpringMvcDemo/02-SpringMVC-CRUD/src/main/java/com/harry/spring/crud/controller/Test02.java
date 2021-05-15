package com.harry.spring.crud.controller;
import java.util.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Test01 {
    public static void main(String[] args) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("k18","v183");

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JedisPoolUtil.release(jedisPool, jedis);
        }
    }
}
