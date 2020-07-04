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
 * @createTime 2020年07月03日 19:15:00
 * @Description: TODO
 */
@WebServlet("/aa/DemoAServlet")
public class DemoAaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Aa的servlet请求执行了");
        request.getRequestDispatcher("/aa/DemoBbServlet").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}