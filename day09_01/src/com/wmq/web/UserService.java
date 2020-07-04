package com.wmq.web;

import com.wmq.dao.UserMapper;
import com.wmq.pojo.User;
import com.wmq.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Lenovo
 */
public class UserService {
    public User login(User user) {
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //获取dao接口的实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法执行
        User u = mapper.login(user);
        return u;
    }
}
