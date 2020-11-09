<%--
  Created by IntelliJ IDEA.
  User: harry.cai
  Date: 2019/12/1
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>统计当前系统在线用户数量</title>
</head>
<body>
    该系统平台共有在线用户${ipMap.size()}个<br>
<a href="${pageContext.request.contextPath}/logout">安全退出</a>
</body>
</html>
