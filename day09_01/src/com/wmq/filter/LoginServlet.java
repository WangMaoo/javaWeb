package com.wmq.filter;

import com.wmq.pojo.User;
import com.wmq.web.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author Lenovo
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        try {
            //一: 验证码校验
            //1.获取请求携带的验证码
            String uCode = req.getParameter("uCode");
            //2.获取session生成的验证码
            HttpSession session = req.getSession();
            String sCode = (String) session.getAttribute("sCode");
            // 删除session中的验证码
            session.removeAttribute("sCode");
            //3.校验
            if (uCode == null || "".equals(uCode)) {
                // 生成响应结果: 验证码不可为空
                req.setAttribute("msg","验证码不可为空");
                req.getRequestDispatcher("/login.jsp").forward(req,response);
                return;
            }
            if (!uCode.equalsIgnoreCase(sCode)) {
                // 验证码错误时执行: 验证码不正确
                req.setAttribute("msg","验证码不正确");
                req.getRequestDispatcher("/login.jsp").forward(req,response);
                return;
            }
            //二: 登录
            //2.1: 获取用户名和密码,并封装到User实体中
            Map<String, String[]> map = req.getParameterMap();
            User user = new User();
            BeanUtils.populate(user,map);
            //2.2: 调用service处理业务逻辑
            UserService service = new UserService();
            User u = service.login(user);
            //2.3处理登录结果
            if(u!=null){
                //response.getWriter().print("登录成功...");
                // 将登录成功的状态保存到session中
                session.setAttribute("user",u);
                response.sendRedirect(req.getContextPath()+"/index.jsp");
            }else{
                //response.getWriter().print("用户名或密码错误");
                req.setAttribute("msg","用户名或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}