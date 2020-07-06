package com.wmq.web;

import com.wmq.pojo.Contact;
import com.wmq.service.ContactService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月04日 19:14:00
 * @Description: TODO
 */
@WebServlet("/addContact")
public class AddContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Contact contact = new Contact();
            BeanUtils.populate(contact,parameterMap);
            ContactService contactService = new ContactService();
            boolean flag = contactService.addContact(contact);
            //判断是否有数据，有数据重定向到查询所有页面展示
            /**
             * 为什么用重定向不用请求转发：
             *        重定向的路径会改变
             */
            if (flag) {
                response.sendRedirect(request.getContextPath() + "/findContactByPage?pageNumber=1&pageSize=3");
            } else {
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}