package com.pc.redis;

import redis.clients.jedis.Jedis;

/**
 * @author panchi
 * @Type RedisDemo.java
 * @Desc
 * @date 2020/3/22 16:22
 */

//java连接redis
public class RedisDemo {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6379;
        Jedis jedis = new Jedis(host, port);
        System.out.println(jedis.ping());
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/22 panchi create
 */ 
