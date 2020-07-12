package com.wmq.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmq.dao.CategoryMapper;
import com.wmq.pojo.Category;
import com.wmq.utils.JedisPoolUtils;
import com.wmq.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月11日 20:05:00
 * @Description: TODO
 */
public class CategoryService {

    public String findCategory() throws JsonProcessingException {
        /**
         * 判断缓冲中是否有信息
         * 没有执行MySQL
         */
        Jedis jedis = JedisPoolUtils.getJedis();
        String categoryList = jedis.get("category");
        if (categoryList == null) {
            SqlSession sqlSession = SqlSessionUtils.getSqlSession();
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            List<Category> category = mapper.findCategory();
            //将获取的信息转换为json格式
            ObjectMapper objectMapper = new ObjectMapper();
            categoryList = objectMapper.writeValueAsString(category);
            jedis.set("category",categoryList);
            sqlSession.close();
        }
        JedisPoolUtils.close(jedis);
        return categoryList;
    }
}
