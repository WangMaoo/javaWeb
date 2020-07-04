package com.wmq.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年06月30日 20:25:00
 * @Description: TODO
 */
@WebServlet("/timeServlet")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 获取所有的cookie
         *
         */
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        Cookie c = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("lastTime".equals(cookie.getName())) {
                    c = cookie;
                }
            }
        }

        if (c == null) {
            response.getWriter().println("第一次访问");
        } else {
            String date = c.getValue();
            //解码并且输出
            String date_m = URLDecoder.decode(date, "utf-8");
            response.getWriter().println("第一次的访问时间为："+date_m);
        }

        //解决cookie的不允许特殊字符问题
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String format = simpleDateFormat.format(new Date());
        //设置编码格式
        String encode = URLEncoder.encode(format, "utf-8");
        c = new Cookie("lastTime", encode);
        c.setMaxAge(3600);
        c.setPath(request.getContextPath() + "/timeServlet");
        response.addCookie(c);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}