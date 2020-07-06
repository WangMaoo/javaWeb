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

    /**
     * 查询总的条数
     * @return
     */
    @Select("select count(*) from contact")
    int findAllContact();

    /**
     * 分页查询
     * @param startIndex
     * @param pageSize
     * @return
     */
    @Select("select * from contact limit #{startIndex},#{pageSize}")
    List<Contact> findContactByPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    @Select("<script>select count(*) from contact\n" +
            "\t\t<where>\n" +
            "            <if test=\"name!=null and name!=''\">\n" +
            "                and name like concat(\"%\",#{name},\"%\")\n" +
            "            </if>\n" +
            "            <if test=\"qq!=null and qq!=''\">\n" +
            "                and qq like concat(\"%\",#{qq},\"%\")\n" +
            "            </if>\n" +
            "        </where></script>")
    int findTotalCountBy_1(Contact contact);

    @Select("<script>" +
            "select * from contact\n" +
            "        <where>\n" +
            "            <if test=\"contact.name!=null and contact.name!=''\">\n" +
            "                and name like concat(\"%\",#{contact.name},\"%\")\n" +
            "            </if>\n" +
            "            <if test=\"contact.qq!=null and contact.qq!=''\">\n" +
            "                and qq like concat(\"%\",#{contact.qq},\"%\")\n" +
            "            </if>\n" +
            "        </where>\n" +
            "        limit #{startIndex},#{pageSize}" +
            "</script>")
    List<Contact> findContactByPage_1(@Param("startIndex") int startIndex,
                                     @Param("pageSize") int pageSize,
                                     @Param("contact") Contact contact);
}
