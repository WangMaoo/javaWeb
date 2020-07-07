package com.wmq.service;

import com.wmq.dao.AreaMapper;
import com.wmq.pojo.Area;
import com.wmq.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月07日 21:51:00
 * @Description: TODO
 */
public class AreaService {

    public List<Area> findArea(String pid) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        AreaMapper mapper = sqlSession.getMapper(AreaMapper.class);
        List<Area> area = mapper.findArea(pid);
        return area;
    }
}
