package com.wmq.service;

import com.wmq.dao.UserMapper;
import com.wmq.pojo.User;
import com.wmq.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月07日 21:02:00
 * @Description: TODO
 */
public class UserService {
    public User findUserByName(String name) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userByName = mapper.findUserByName(name);
        sqlSession.close();
        return userByName;
    }
}
