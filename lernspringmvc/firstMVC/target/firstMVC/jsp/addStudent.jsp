<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/student/add2.do">
    姓名:<input type="text" name="name"><br>
    年龄:<input type="text" name="age"><br>
    <!-- 用协程对象属性.属性的方式 -->
    学校名称：<input type="text" name="school.schoolName"><br>
    学校地址：<input type="text" name="school.address"><br>

    <input type="submit" value="提交">
</form>
</body>
</html>
