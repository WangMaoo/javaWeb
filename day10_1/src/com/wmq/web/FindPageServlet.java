package com.wmq.web;

import com.wmq.pojo.PageBean;
import com.wmq.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月05日 08:56:00
 * @Description: TODO
 */
@WebServlet("/findContactByPage")
public class FindPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageSize = 3;
        int pageNumber = 1;
        pageSize = Integer.parseInt(request.getParameter("pageSize"));
        pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        ContactService contactService = new ContactService();
        PageBean contactByPage = contactService.findContactByPage(pageSize, pageNumber);
        request.setAttribute("pb",contactByPage);
        request.getRequestDispatcher("pageList.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}