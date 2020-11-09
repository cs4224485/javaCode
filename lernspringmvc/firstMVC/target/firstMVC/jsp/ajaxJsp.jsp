<%--
  Created by IntelliJ IDEA.
  User: harry.cai
  Date: 2019/12/9
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
    <input id="submitAjax" type="submit">
</body>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
    $(function () {
        $("#submitAjax").click(function () {
            $.ajax({
                url:"${pageContext.request.contextPath}/ajaxResponse.do",
                type:"post",
                data:{name:"harry", age:24},
                dataType:"json",
                success:function (result) {
                    alert(result.name + "," + result.age)
                }
            })
        })
    })
</script>
</html>
