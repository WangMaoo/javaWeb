package com.wmq.test;

import com.wmq.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月08日 21:46:00
 * @Description: TODO
 */
public class JedisPoolTest {
    public static void main(String[] args) {
        Jedis jedis = JedisPoolUtils.getJedis();
        String name = jedis.get("name");
        System.out.println("name = " + name);
        JedisPoolUtils.close(jedis);

    }
}
