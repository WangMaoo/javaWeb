package com.wmq.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @version V1.0
 * @author: wang
 * @date: 2019/11/23 18:01
 * @description: 提供SqlSession的工具类
 */
public class SqlSessionUtils {

    private static SqlSessionFactory sqlSessionFactory;

    /*
    * 1、SqlSessionFactory：
    *       提前构建
    *       整个项目运行过程中，只需要构建一次
    * */
    static {

        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 提供一个方法获取SqlSession
     */
    public static SqlSession getSqlSession() {
       return sqlSessionFactory.openSession(true);
    }


    /**
     * 返回SqlSessionFactory
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
