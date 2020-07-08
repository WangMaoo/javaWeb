package com.wmq.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmq.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月08日 17:56:00
 * @Description: TODO
 */
@WebServlet("/demoServlet")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String word = request.getParameter("word");
        SearchService searchService = new SearchService();
        List<Object> list = searchService.searchWord(word);
        //将查询到的数据转换为json
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(list);
        response.getWriter().print(s);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}