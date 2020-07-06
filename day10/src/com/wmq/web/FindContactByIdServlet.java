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

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月04日 19:46:00
 * @Description: 根据id查询用户
 */
@WebServlet("/findContactById")
public class FindContactByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ContactService contactService = new ContactService();
        Contact contactById = contactService.findContactById(id);
        //将查询到的数据放入共享区并请求转发到修改界面
        request.setAttribute("contact",contactById);
        request.getRequestDispatcher("/update.jsp").forward(request,response );
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}