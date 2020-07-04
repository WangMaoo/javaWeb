package com.wmq.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月03日 20:37:00
 * @Description: TODO
 */
@WebFilter("/loginServlet")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String key = "post";
        String method = request.getMethod();
        if (key.equalsIgnoreCase(method)) {
            request.setCharacterEncoding("utf-8");
            chain.doFilter(request, response);
        } else {
            chain.doFilter(req,resp);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }
}