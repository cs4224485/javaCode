<%--
  Created by IntelliJ IDEA.
  User: harry.cai
  Date: 2019/11/29
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.harry.listener.Student" %>
<%@ page import="com.harry.listener.Person" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>测试监听器</h1>
<%
    Person p = new Person();
    session.setAttribute("person", p);


%>

</body>
</html>
