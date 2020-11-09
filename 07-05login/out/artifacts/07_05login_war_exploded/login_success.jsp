<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功</title>
</head>
<body>
	欢迎你：${user.name}<br>${sessionScope.user.name}
	<a href="${pageContext.request.contextPath}/logout">注销</a>
</body>
</html>