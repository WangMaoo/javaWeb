package com.wmq.dao;

import com.wmq.pojo.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月11日 20:14:00
 * @Description: TODO
 */
public interface CategoryMapper {
    /**
     * 查询所有的分类信息
     * @return
     */
    @Select("select * from category")
    List<Category> findCategory();
}
