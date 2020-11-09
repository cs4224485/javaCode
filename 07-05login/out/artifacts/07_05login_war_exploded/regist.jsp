<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/register" method="post">
	${msg}
	<table>
		<tr>
			<td>用户名：</td><td><input type="text" name="name" value=""/></td>
		</tr>
		<tr>
			<td>密码：</td><td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td>确认密码：</td><td><input type="password" name="repassword"/></td>
		</tr>
		<tr>
			<td>邮箱：</td><td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td>生日：</td><td><input type="text" name="birthday" /></td>
		</tr>
	</table>
		<input type="submit" value="注册"/><br/>
	</form>
</body>
</html>