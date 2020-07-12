package com.wmq.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @author Lenovo
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool;
    static {
        // ResourceBundle: 专门解析properties配置文件
        // 解析properties配置文件,获取文件中的数据信息
        ResourceBundle bundle = ResourceBundle.getBundle("jedis");
        int maxTotal = Integer.parseInt(bundle.getString("jedis.maxTotal"));
        int maxIdle = Integer.parseInt(bundle.getString("jedis.maxIdle"));
        int maxWaitMillis = Integer.parseInt(bundle.getString("jedis.maxWaitMillis"));
        String host = bundle.getString("jedis.host");
        int port = Integer.parseInt(bundle.getString("jedis.port"));
        // System.out.println(maxTotal);
        // System.out.println(maxIdle);
        // System.out.println(maxWaitMillis);
        // System.out.println(host);
        // System.out.println(port);
        // 初始化连接池配置信息
        // 创建连接池配置信息对象
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数量
        config.setMaxTotal(maxTotal);
        // 设置最大空闲数量
        config.setMaxIdle(maxIdle);
        // 设置最大超时时间
        config.setMaxWaitMillis(maxWaitMillis);
        // 创建连接池对象
        jedisPool = new JedisPool(config, host, port);

    }

    // 提供获取连接的方法
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
    // 提供归还连接的方法
    public static void close(Jedis jedis){
        if(jedis!=null){
            jedis.close();
        }
    }
}
