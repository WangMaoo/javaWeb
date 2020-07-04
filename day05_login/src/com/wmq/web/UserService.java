package com.wmq.web;

import com.wmq.dao.UserMapper;
import com.wmq.pojo.User;
import com.wmq.utils.SqlSessionUtils;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年06月28日 21:22:00
 * @Description: TODO
 */

public class UserService {
    /**
     * 处理业务逻辑
     * @param user
     * @return
     */
    public boolean login(User user) {
        UserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);
        User u = mapper.login(user);
        return u == null ? false : true;
    }
}
