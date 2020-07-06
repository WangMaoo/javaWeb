package com.wmq.service;

import com.wmq.dao.ContactMapper;
import com.wmq.pojo.Contact;
import com.wmq.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Lenovo
 */
public class ContactService {
    public List<Contact> findContactAll() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
        List<Contact> list = mapper.findContactAll();
        sqlSession.close();
        return list;
    }

    public boolean addContact(Contact contact) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
        int i = mapper.addContact(contact);
        sqlSession.close();
        return i > 0;
    }

    public Contact findContactById(String id) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
        Contact contactById = mapper.findContactById(id);
        sqlSession.close();
        return contactById;
    }

    public boolean updateContact(Contact contact) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
        int i = mapper.updateContact(contact);
        sqlSession.close();
        return i > 0;
    }

    public boolean deleteContact(String id) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
        int flag = mapper.deleteContact(id);
        sqlSession.close();
        return flag > 0;
    }
}
