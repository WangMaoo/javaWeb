package com.wmq.filter;

import com.wmq.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Lenovo
 */
@WebFilter("/contact/*")
public class PermissionFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //过滤请求
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 判断是否有用户登录
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        // 没有用户登录
        if(user==null){
            // 重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        // 放行
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
