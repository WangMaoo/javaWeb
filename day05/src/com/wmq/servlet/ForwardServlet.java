package com.wmq.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年06月28日 20:27:00
 * @Description: TODO
 */
@WebServlet("/forwardServlet")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String money = request.getParameter("money");
        System.out.println("money = " + money);
        request.setAttribute("name","张三");
        request.getRequestDispatcher("/myServlet").forward(request,response);
        response.getWriter().println("我是forward");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}