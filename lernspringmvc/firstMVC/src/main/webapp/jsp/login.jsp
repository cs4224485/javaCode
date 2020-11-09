<%--
  Created by IntelliJ IDEA.
  User: harry.cai
  Date: 2019/12/11
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 当访问该页面的时候，表示已经登录了 -->
<%
    request.getSession().setAttribute("user", "harry");
%>
</body>
</html>
