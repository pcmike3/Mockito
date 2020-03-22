package com.pc.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author panchi
 * @Type RedisDemo.java
 * @Desc
 * @date 2020/3/22 16:33
 */
@Slf4j
public class RedisDemo {

    private Jedis jedis;

    @Before
    public void init(){
        String host ="localhost";
        int port = 6379;
        jedis = new Jedis(host,port);
    }

    @Test
    public void test1(){
        jedis.hset("h1","name","panchi");
        jedis.hset("h1","age","18");
        Map<String, String> h1 = jedis.hgetAll("h1");
        System.out.println(h1);
    }

    /**
     * 模拟需求，去redis中检查某key是否存在，若存在就取出，不存在就去数据库中查询
     */
    @Test
    public void test2(){
        String key="applicationName1";
        if (jedis.exists(key)){
            String result = jedis.get(key);
            System.out.println(result);
        }else {
            searchFromDB();
            log.info("redis中不存在：[{}]",key);
        }
    }

    private void searchFromDB() {
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/3/22 panchi create
 */ 
