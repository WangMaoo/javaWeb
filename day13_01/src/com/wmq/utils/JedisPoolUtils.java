package com.wmq.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月08日 21:38:00
 * @Description: TODO
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jedis");
        int maxTotal = Integer.parseInt(bundle.getString("jedis.maxTotal"));
        int maxIdle = Integer.parseInt(bundle.getString("jedis.maxIdle"));
        int maxWaitMillis = Integer.parseInt(bundle.getString("jedis.maxWaitMillis"));
        String host = bundle.getString("jedis.host");
        int port = Integer.parseInt(bundle.getString("jedis.port"));

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

        jedisPool = new JedisPool(jedisPoolConfig, host, port);
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

}
