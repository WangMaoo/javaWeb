package com.wmq.body;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/body")
public class BodyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 访问此servlet返回给浏览器一个表格 (html是弱类型语言)
        PrintWriter writer = response.getWriter();
        writer.print("<table border='1px' align='center'>");
        writer.print("<tr>");
        writer.print("<th>ID</th>");
        writer.print("<th>姓名</th>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.print("<th>1</th>");
        writer.print("<th>tom</th>");
        writer.print("</tr>");
        writer.print("<tr>");
        writer.print("<th>2</th>");
        writer.print("<th>张三</th>");
        writer.print("</tr>");
        writer.print("</table>");

        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}