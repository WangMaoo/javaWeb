<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap模板</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">显示所有联系人</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th colspan="8">
                <form action="/contact" method="post">
                    <input type="hidden" name="action" value="findContactByPage_1">
                    <input type="hidden" name="pageSize" value="3">
                    <input type="hidden" name="pageNumber" value="1">
                    姓名: <input type="text" name="name" value="${contact.name}"/>
                    QQ: <input type="text" name="qq" value="${contact.qq}"/>
                    <input class="btn btn-success" type="submit" value="查询">
                </form>
            </th>
        </tr>
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
    <c:forEach items="${pb.data}" var="contact">
        <tr>
            <td>${contact.id}</td>
            <td>${contact.name}</td>
            <td>${contact.sex}</td>
            <td>${contact.age}</td>
            <td>${contact.address}</td>
            <td>${contact.qq}</td>
            <td>${contact.email}</td>
            <td>
                <a class="btn btn-default btn-sm" href="/contact?action=findContactById&id=${contact.id}">修改</a>&nbsp;
                <a class="btn btn-default btn-sm" href="JavaScript:deleteContactById(${contact.id})">删除</a></td>
        </tr>
    </c:forEach>
        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="/add.jsp">添加联系人</a></td>
        </tr>
    </table>
    <%-- 分页条 --%>
    <nav class="text-center">
        <ul class="pagination">
            <%-- 上一页 --%>
            <c:if test="${pb.pageNumber<=1}">
                <li class="disabled"><span>&laquo;</span></li>
            </c:if>
            <c:if test="${pb.pageNumber>1}">
                <li><a href="/contact?action=findContactByPage_1&name=${contact.name}&qq=${contact.qq}&pageNumber=${pb.pageNumber-1}&pageSize=${pb.pageSize}" ><span>&laquo;</span></a></li>
            </c:if>

            <c:forEach begin="1" end="${pb.totalPage}" step="1" var="i">
                <c:if test="${pb.pageNumber==i}">
                    <li class="active"><a href="JavaScript:void(0);">${i}</a></li>
                </c:if>
                <c:if test="${pb.pageNumber!=i}">
                    <li><a href="/contact?action=findContactByPage_1&name=${contact.name}&qq=${contact.qq}&pageNumber=${i}&pageSize=${pb.pageSize}">${i}</a></li>
                </c:if>
            </c:forEach>
            <%-- 页码显示区 --%>
           <%-- <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>--%>

            <%-- 下一页 --%>
            <c:if test="${pb.pageNumber>=pb.totalPage}">
                <li class="disabled"><span>&raquo;</span></li>
            </c:if>
            <c:if test="${pb.pageNumber<pb.totalPage}">
                <li><a href="/contact?action=findContactByPage_1&name=${contact.name}&qq=${contact.qq}&pageNumber=${pb.pageNumber+1}&pageSize=${pb.pageSize}"><span>&raquo;</span></a></li>
            </c:if>
        </ul>
    </nav>
    <script>
        function deleteContactById(id) {
            var flag = confirm("是否删除");
            if(flag){
                location.href = "/contact?action=deleteContact&id="+id;
            }
        }
    </script>
</div>
</body>
</html>
