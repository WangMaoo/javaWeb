package com.wmq.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年06月27日 11:23:00
 * @Description: TODO
 */
@WebServlet("/demo3Servlet")
public class Demo3Servlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo3执行了");
    }
}
