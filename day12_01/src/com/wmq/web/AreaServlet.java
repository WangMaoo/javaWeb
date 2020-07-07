package com.wmq.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmq.pojo.Area;
import com.wmq.service.AreaService;

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
 * @createTime 2020年07月07日 21:50:00
 * @Description: TODO
 */
@WebServlet("/areaServlet")
public class AreaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String pid = request.getParameter("pid");
        AreaService areaService = new AreaService();
        List<Area> area = areaService.findArea(pid);
        //将查询到数据转化为json
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(area);
        response.getWriter().print(s);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}