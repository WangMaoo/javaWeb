package com.wmq.web;

import com.wmq.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月04日 21:12:00
 * @Description: TODO
 */
@WebServlet("/deleteContact")
public class DeleteContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ContactService contactService = new ContactService();
        boolean b = contactService.deleteContact(id);
        //当删除成功后跳转到展示页面
        if (b) {
            response.sendRedirect(request.getContextPath() + "/findContactAll");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}