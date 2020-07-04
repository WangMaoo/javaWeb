package com.wmq.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月03日 18:16:00
 * @Description: TODO
 */
//@WebFilter("/testServlet")
public class TestFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤执行前");
        chain.doFilter(req, resp);
        System.out.println("过滤执行后");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
