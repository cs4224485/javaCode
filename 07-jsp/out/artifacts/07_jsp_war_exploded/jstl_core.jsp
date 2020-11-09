<%@ page import="java.util.*" %>
<%@ page import="com.harry.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: harry.cai
  Date: 2019/11/26
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- c:out -->
<%
    pageContext.setAttribute("user", "admin");
%>
el表达式：${user}<br>
使用e:out标签:<c:out value="${user}"></c:out><br>
<!-- c:catch标签 -->
<c:catch var="e">
    ${pageContext.name}
</c:catch>
${e.message}
<!-- c:if标签  var后面的值可以存储判断结果 -->
<c:if test="${user == 'admin'}"  var="flag" >
    欢迎登录
    ${flag}
</c:if>
<!-- c:chose标签 -->
<%
    pageContext.setAttribute("hobby", "basketball");
%>
<c:choose>
    <c:when test="${hobby == 'basketball'}">
        我喜欢打篮球
    </c:when>
    <c:when test="${hobby == 'football'}">
        我喜欢踢足球
    </c:when>

    <c:otherwise>
        我没什么爱好
    </c:otherwise>
</c:choose>
<!-- c:forEach标签 -->
<br>---------------------遍历数组---------------<br>
<%
    Object[] city = {"北京", "上海", "广州", "天津"};
    pageContext.setAttribute("city", city);
%>
<c:forEach items="${city}" var="c">
    ${c}<br>
</c:forEach>
<br>---------------------遍历List---------------<br>
<%
    List<String> name = new ArrayList<String>();
    pageContext.setAttribute("name", name);
    name.add("sam");
    name.add("harry");
    name.add("jerry");
%>
<c:forEach items="${name}" var="n">
    ${n}<br>
</c:forEach>

<br>---------------------遍历set---------------<br>
<%
    HashSet<String> sport = new HashSet<String>();
    pageContext.setAttribute("sport", sport);
    sport.add("足球");
    sport.add("篮球");
    sport.add("乒乓球");
%>
<c:forEach items="${sport}" var="s">
    ${s}<br>

</c:forEach>
<br>---------------------遍历map---------------<br>
<%
    Map<String, String> map = new HashMap<String, String>();
    map.put("第一名", "中国");
    map.put("第二名", "美国");
    map.put("第三名", "德国");
    pageContext.setAttribute("map", map);
%>
<c:forEach items="${map}" var="m">
    ${m.key}:${m.value}<br>
</c:forEach>
<!-- 指定遍历的起始索引及步长 -->
<br>---------------------遍历起始索引和结束索引---------------<br>
<%
    Object[] country = {"0中国", "1美国", "2德国", "3法国", "4英国", "5瑞士", "6瑞典", "7意大利"};
    pageContext.setAttribute("country", country);
%>
<c:forEach items="${country}" var="c" begin="1" end="7" step="2">
    ${c}<br>
</c:forEach>
<br>---------------------varStatus---------------<br>
<%
    List<Student> student = new ArrayList<Student>();
    student.add(new Student("马云", 22));
    student.add(new Student("马化腾", 21));
    student.add(new Student("雷军", 30));
    student.add(new Student("王宇", 50));
    student.add(new Student("孙子轩", 25));
    student.add(new Student("袁梦颖", 23));
    student.add(new Student("罗正华", 20));
    pageContext.setAttribute("student", student);
%>
<table border="1">
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    <c:forEach items="${student}" var="s" varStatus="obj">
        <tr>
            <td>${obj.count}</td>
            <td>${s.name}</td>
            <td>${s.age}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
