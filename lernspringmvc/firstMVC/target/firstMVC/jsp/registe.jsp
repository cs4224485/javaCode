<%--
  Created by IntelliJ IDEA.
  User: harry.cai
  Date: 2019/12/8
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/user/params01.do">
    姓名:<input type="text" name="username"><br>
    年龄:<input type="text" name="age">
    <input type="submit" value="提交">
</form>
</body>
</html>
