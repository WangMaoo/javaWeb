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
 * @createTime 2020年06月28日 19:28:00
 * @Description: TODO
 */
@WebServlet("/rowServlet")
public class RowServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求方式
        System.out.println("请求方式"+request.getMethod());
        System.out.println("请求的项目地址"+request.getContextPath());
        System.out.println("请求的ip地址"+request.getRemoteAddr());
        System.out.println("请求的端口号"+request.getLocalPort());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}