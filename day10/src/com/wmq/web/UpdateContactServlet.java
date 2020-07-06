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
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月04日 20:31:00
 * @Description: TODO
 */
@WebServlet("/updateContact")
public class UpdateContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Map<String, String[]> map = request.getParameterMap();
            Contact contact = new Contact();
            BeanUtils.populate(contact, map);
            ContactService service = new ContactService();
            boolean flag = service.updateContact(contact);
            //判断是否有数据，有数据就返回展示，没有跳转到错误界面
            if (flag) {
                response.sendRedirect(request.getContextPath() + "/findContactAll");
            } else {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
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