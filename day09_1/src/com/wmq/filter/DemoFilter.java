package com.wmq.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月03日 19:20:00
 * @Description: TODO
 */
//@WebFilter(value = "/aa/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class DemoFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("aaa");
        chain.doFilter(req, resp);
        System.out.println("bbb");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }
}