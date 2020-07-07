package com.wmq.dao;

import com.wmq.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月07日 21:05:00
 * @Description: TODO
 */
public interface UserMapper {

    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    @Select("select * from user where name=#{name}")
    User findUserByName(String name);
}
