package com.wmq.servlet;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年06月27日 18:10:00
 * @Description: TODO
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getRequestRowServlet")
public class GetRequestRowServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式为: "+method);
        // 获取当前项目的名称 ★
        String contextPath = request.getContextPath();
        System.out.println("当前项目名称为: "+contextPath);
        // 获取请求者的ip地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println("请求者的IP地址为: "+remoteAddr);
        // 获取访问的端口
        int localPort = request.getLocalPort();
        System.out.println("访问的端口为: "+localPort);
        // ============ 了解
        // 获取协议和版本
        String protocol = request.getProtocol();
        System.out.println("协议和版本为: "+protocol);
        // 获取请求携带的参数信息,以一个字符串形式返回
        String queryString = request.getQueryString();
        System.out.println("请求参数为: "+queryString);
        // 获取请求路径
        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        System.out.println(uri);
        System.out.println(url);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
