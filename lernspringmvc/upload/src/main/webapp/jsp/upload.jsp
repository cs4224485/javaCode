<%--
  Created by IntelliJ IDEA.
  User: harry.cai
  Date: 2019/12/10
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form enctype="multipart/form-data" method="post" action="/upload.do">
    图片1:<input type="file" name="photos"><br>
    图片2:<input type="file" name="photos"><br>
    图片3:<input type="file" name="photos"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
