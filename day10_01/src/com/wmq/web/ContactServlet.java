package com.wmq.web;

import com.wmq.pojo.Contact;
import com.wmq.pojo.PageBean;
import com.wmq.service.ContactService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


/**
 * @author Lenovo
 */
@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if("findContactAll".equals(action)){
            findContactAll(request,response);
        }else if("addContact".equals(action)){
            addContact(request,response);
        }else if("findContactById".equals(action)){
            findContactById(request,response);
        }else if("updateContact".equals(action)){
            updateContact(request,response);
        }else if("deleteContact".equals(action)){
            deleteContactById(request,response);
        }else if("findContactByPage".equals(action)){
            findContactByPage(request,response);
        } else if ("findContactByPage_1".equals(action)) {
            findContactByPage_1(request,response);
        }

    }

    /**
     * 按条件查询
     * @param request
     * @param response
     */
    private void findContactByPage_1(HttpServletRequest request, HttpServletResponse response) {
        try {
            int pageSize = 3;
            int pageNumber = 1;
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            ContactService contactService = new ContactService();
            //获取页面表单中的数据进行封装
            Map<String, String[]> parameterMap = request.getParameterMap();
            Contact contact = new Contact();
            BeanUtils.populate(contact,parameterMap);
            //获取PageBean中的所有数据返回
            PageBean<Contact> contactByPage_1 = contactService.findContactByPage_1(pageSize, pageNumber, contact);
            request.setAttribute("pb",contactByPage_1);
            request.setAttribute("contact",contact);
            request.getRequestDispatcher("/pageList_1.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findContactByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageSize = 3;
        int pageNumber = 1;
        pageSize = Integer.parseInt(request.getParameter("pageSize"));
        pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        ContactService contactService = new ContactService();
        PageBean contactByPage = contactService.findContactByPage(pageSize, pageNumber);
        request.setAttribute("pb",contactByPage);
        request.getRequestDispatcher("pageList_1.jsp").forward(request,response);
    }

    private void deleteContactById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ContactService contactService = new ContactService();
        boolean b = contactService.deleteContact(id);
        //当删除成功后跳转到展示页面
        if (b) {
            response.sendRedirect(request.getContextPath() + "/contact?action=findContactByPage_1&pageNumber=1&pageSize=3");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    private void updateContact(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, String[]> map = request.getParameterMap();
            Contact contact = new Contact();
            BeanUtils.populate(contact, map);
            ContactService service = new ContactService();
            boolean flag = service.updateContact(contact);
            //判断是否有数据，有数据就返回展示，没有跳转到错误界面
            if (flag) {
                response.sendRedirect(request.getContextPath() + "/contact?action=findContactByPage_1&pageNumber=1&pageSize=3");
            } else {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findContactById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ContactService contactService = new ContactService();
        Contact contactById = contactService.findContactById(id);
        //将查询到的数据放入共享区并请求转发到修改界面
        request.setAttribute("contact",contactById);
        request.getRequestDispatcher("/update.jsp").forward(request,response );
    }

    private void addContact(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Contact contact = new Contact();
            BeanUtils.populate(contact,parameterMap);
            ContactService contactService = new ContactService();
            boolean flag = contactService.addContact(contact);
            //判断是否有数据，有数据重定向到查询所有页面展示
            /**
             * 为什么用重定向不用请求转发：
             *        重定向的路径会改变，不然刷新会重新执行一次
             */
            if (flag) {
                response.sendRedirect(request.getContextPath() + "/contact?action=findContactByPage_1&pageNumber=1&pageSize=3");
            } else {
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findContactAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service处理业务逻辑
        ContactService service = new ContactService();
        List<Contact> list = service.findContactAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}