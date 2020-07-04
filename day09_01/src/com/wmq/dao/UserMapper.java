package com.wmq.dao;

import com.wmq.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author Lenovo
 */
public interface UserMapper {
    /**
     * 登陆
     * @param user
     * @return
     */
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(User user);
}
