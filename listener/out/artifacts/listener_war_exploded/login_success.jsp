<%--
  Created by IntelliJ IDEA.
  User: harry.cai
  Date: 2019/12/1
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>序号</th>
            <th>用户</th>
            <td>操作</td>
        </tr>
        <c:forEach items="${applicationScope.map}" var="m" varStatus="obj">
            <tr>
                <td>${obj.count}</td>
                <td>${m.key}</td>
                <td><a href="${pageContext.request.contextPath}/deleteUser?name=${m.key}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
