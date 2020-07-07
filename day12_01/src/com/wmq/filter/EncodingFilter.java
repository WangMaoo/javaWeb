package com.wmq.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤所有请求携带的中文乱码问题
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 过滤请求
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String method = request.getMethod();
        // 针对指定的请求方式,解决中文乱码问题
        if("POST".equalsIgnoreCase(method)){
            request.setCharacterEncoding("utf-8");
            chain.doFilter(request, response);
        }else {
            chain.doFilter(req,resp);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
