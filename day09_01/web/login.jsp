<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        function changeImg(object) {
            object.src = "codeServlet?t="+new Date().getTime();
        }
    </script>
</head>
<body>
    ${msg}
    <form action="/loginServlet" method="post">
        用户名: <input type="text" name="username"> <br>
        密码: <input type="password" name="password"> <br>
        验证码: <input type="text" name="uCode"> <img src="/codeServlet" alt="" onclick="changeImg(this)"> <br>
        <input type="submit" value="登录">
    </form>
</body>
</html>