package com.wmq.filter;

import com.wmq.pojo.User;
import com.wmq.web.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年06月28日 21:19:00
 * @Description: TODO
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user,parameterMap);
            UserService userService = new UserService();
            boolean flag = userService.login(user);
            if (flag) {
                response.getWriter().println("登陆成功");
            } else {
                response.getWriter().println("登陆失败");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}