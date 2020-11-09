<%--
  Created by IntelliJ IDEA.
  User: harry.cai
  Date: 2019/12/11
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="page-header"></div>
<div class="container">
    <form action="/update.do" method="post" style="max-width: 330px;padding: 15px;margin: 0 auto;">
        <input type="hidden" name="id" value="${id}">
        <div class="form-group">
            <label for="name">姓名:</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}">
        </div>
        <div class="form-group">
            <label for="phone">手机:</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}">
        </div>
        <div class="form-group">
            <label for="birthday">生日:</label>
            <input type="date" class="form-control" id="birthday" name="birthday" value="${user.birthday}">
        </div>
        <div class="form-group">
            <label for="address">地址:</label>
            <input type="text" class="form-control" id="address" name="address" value="${user.address}">
        </div>

        <input type="submit" value="提交">
    </form>
</div>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
</body>
</html>
