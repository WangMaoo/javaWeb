package com.wmq.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年06月27日 11:31:00
 * @Description: TODO
 */
@WebServlet("/demo4Servlet")
public class Demo4Servlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("demo4");
    }
}
