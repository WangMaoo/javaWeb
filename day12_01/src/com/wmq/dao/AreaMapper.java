package com.wmq.dao;

import com.wmq.pojo.Area;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月07日 21:56:00
 * @Description: TODO
 */
public interface AreaMapper {

    /**
     * 根据pid查询所有的省份
     * @param pid
     * @return
     */
    @Select("select * from area where pid = #{pid}")
    List<Area> findArea(String pid);

}
