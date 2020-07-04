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
 * @createTime 2020年06月28日 20:41:00
 * @Description: TODO
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String referer = request.getHeader("referer");
        if (referer != null) {
            if (referer.endsWith("download.html")) {
                response.getWriter().println("下载成功。。。");
            } else {
                response.getWriter().println("不允许下载。。。");
            }
        } else {
            response.getWriter().println("不允许下载");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}