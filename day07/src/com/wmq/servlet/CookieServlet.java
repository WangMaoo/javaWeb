package com.wmq.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年06月30日 17:50:00
 * @Description: TODO
 */
@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie
        Cookie aaa = new Cookie("aaa","第一个cookie");
        Cookie bbb = new Cookie("bbb","第一个cookie");
        //设置cookie时间
        aaa.setMaxAge(20);
        bbb.setMaxAge(1000);
        bbb.setPath(request.getContextPath()+"/bbb");
        //将cookie写回浏览器
        response.addCookie(aaa);
        response.addCookie(bbb);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}