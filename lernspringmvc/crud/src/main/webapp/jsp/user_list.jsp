<%--
  Created by IntelliJ IDEA.
  User: harry.cai
  Date: 2019/12/11
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container theme-showcase" role="main">
    <div id="msg">
        <div class="alert alert-info" role="alert">删除成功!</div>
    </div>
    <div class="page-header">
        <form id="query-by-id" action="/findById.do" method="post">
            <input id="query-id" type="text" name="id" placeholder="请输入id" value="${id}">
            <button id="query" type="button" class="btn btn-sm btn-primary">查询</button>
            <a id="add" type="button" class="btn btn-sm btn-success" href="/jsp/user_add.jsp">添加</a>
        </form>
    </div>
    <div class="row">
        <div class="">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>手机</th>
                    <th>生日</th>
                    <th>地址</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allUser}" var="user">
                    <tr>

                        <td>${user.key}</td>
                        <td>${user.value.name}</td>
                        <td>${user.value.phone}</td>
                        <td>${user.value.birthday}</td>
                        <td>${user.value.address}</td>
                        <td>
                            <a type="button" class="btn btn-sm btn-info" href="/delete.do?id=${user.key}">删除</a>
                            <a type="button" class="btn btn-sm btn-warning" href="/goUpdate.do?id=${user.key}">修改</a>
                        </td>
                    </tr>
                </c:forEach>


                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script type="text/javascript">
    $(function () {
        $("#query").click(function () {
            var userId = $("#query-id").val();
            if (userId == ""){
                window.location.href = "/findAll.do";
            }else {
                $("#query-by-id").submit();
            }

        })
    })
</script>
</body>
</html>
