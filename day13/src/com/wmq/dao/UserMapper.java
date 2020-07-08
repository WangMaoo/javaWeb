package com.wmq.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月08日 18:07:00
 * @Description: TODO
 */
public interface UserMapper {

    /**
     * 查看前4页的信息
     * @param word
     * @return
     */
    @Select("select name from user where name like concat('%',#{word},'%') limit 0,4")
    List<Object> findUser(String word);
}
