package com.wmq.dao;

import com.wmq.pojo.Contact;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Lenovo
 */
public interface ContactMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from contact ")
    List<Contact> findContactAll();

    /**
     * 添加用户
      * @param contact
     * @return
     */
    @Insert("insert into contact values(null,#{name},#{sex},#{age},#{address},#{qq},#{email})")
    int addContact(Contact contact);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from contact where id = #{id}")
    Contact findContactById(@Param("id") String id);

    /**
     * 更新用户
     * @param contact
     * @return
     */
    @Update("update contact set sex=#{sex},age=#{age},address=#{address},qq=#{qq},email=#{email} where id=#{id}")
    int updateContact(Contact contact);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @Delete("delete from contact where id = #{id}")
    int deleteContact(@Param("id") String id);

}
