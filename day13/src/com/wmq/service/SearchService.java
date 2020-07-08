package com.wmq.service;

import com.wmq.dao.UserMapper;
import com.wmq.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月08日 18:04:00
 * @Description: TODO
 */
public class SearchService {
    public List<Object> searchWord(String word) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Object> user = mapper.findUser(word);
        sqlSession.close();
        return user;
    }
}
