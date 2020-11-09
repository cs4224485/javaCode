<%--
  Created by IntelliJ IDEA.
  User: harry.cai
  Date: 2019/12/10
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/user/register.do">
    姓名:<input type="tex", name="name">${nameError}<br>
    年龄:<input type="tex", name="age">${ageError}<br>
    手机号:<input type="tex", name="phone">${phoneError}<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
