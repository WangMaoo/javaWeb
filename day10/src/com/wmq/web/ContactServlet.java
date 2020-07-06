package com.wmq.web;

import com.wmq.pojo.Contact;
import com.wmq.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Lenovo
 */
@WebServlet("/findContactAll")
public class ContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service处理业务逻辑
        ContactService service = new ContactService();
        List<Contact> list = service.findContactAll();
        /**
         *请求转发到jsp页面(jsp本质上就是Servlet)
         *共享数据信息到下一个Servlet
         */
        request.setAttribute("list",list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}