package com.wmq.servlet;

import com.wmq.utils.DownLoadUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年06月30日 19:56:00
 * @Description: TODO
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取文件的类型并返回给浏览器
        String filename = request.getParameter("filename");
        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType(filename);
        response.setContentType(mimeType);
        //解决不同浏览器的编码问题
        String uHeader = request.getHeader("user-agent");
        String defaultName = DownLoadUtils.getName("uHeader", filename);
        //设置下载文件专用头
        response.setHeader("content-disposition", "attachment;filename=" + defaultName);

        ServletOutputStream outputStream = response.getOutputStream();
        String realPath = servletContext.getRealPath("/download/" + filename);
        FileInputStream fileInputStream = new FileInputStream(realPath);
        IOUtils.copy(fileInputStream,outputStream);
        outputStream.close();
        fileInputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}