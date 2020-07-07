package com.wmq.web;

import com.wmq.pojo.User;
import com.wmq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月07日 20:58:00
 * @Description: TODO
 */
@WebServlet("/ajaxServlet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        UserService userService = new UserService();
        User userByName = userService.findUserByName(name);
        if (userByName == null) {
            response.getWriter().print(1);
        } else {
            response.getWriter().print(0);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}