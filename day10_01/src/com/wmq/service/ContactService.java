package com.wmq.service;

import com.wmq.dao.ContactMapper;
import com.wmq.pojo.Contact;
import com.wmq.pojo.PageBean;
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

    public PageBean findContactByPage(int pageSize, int pageNumber) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
        //计算总条数
        int allContact = mapper.findAllContact();
        //封装信息，方便前台使用
        PageBean pageBean = new PageBean(pageSize, allContact);
        pageBean.setPageNumber(pageNumber);
        //计算起始索引
        int startIndex = (pageNumber-1)*pageSize;
        List<Contact> data = mapper.findContactByPage(startIndex, pageSize);
        pageBean.setData(data);
        sqlSession.close();
        return pageBean;
    }

    public PageBean<Contact> findContactByPage_1(int pageSize, int pageNumber, Contact contact) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
        int count = mapper.findTotalCountBy_1(contact);
        PageBean pageBean = new PageBean(pageSize, count);
        pageBean.setPageNumber(pageNumber);
        int startIndex = (pageNumber-1)*pageSize;
        List<Contact> contactByPage1 = mapper.findContactByPage_1(startIndex, pageSize, contact);
        pageBean.setData(contactByPage1);
        sqlSession.close();
        return pageBean;
    }
}
