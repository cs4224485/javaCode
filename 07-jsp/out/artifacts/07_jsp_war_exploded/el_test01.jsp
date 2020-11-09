<%--
  Created by IntelliJ IDEA.
  User: harry.cai
  Date: 2019/11/25
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.harry.bean.Student" %>
<%@ page import="com.harry.bean.School" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("name", "page");
    request.setAttribute("name2", "request");
    session.setAttribute("name", "session");
    application.setAttribute("name", "application");
%>
${name}
${name2}
<!-- 使用域属性空间相关的内置对象获取数据 -->
${pageScope.name}<br>
${requestScope.name}<br>
${sessionScope.name}<br>
${applicationScope.name}<br>
<!-- 访问bean属性 -->
<%
    Student s = new Student("张三", 21);
    request.setAttribute("s", s);
%>
${ s.name}<br>
${s.age}<br>
${requestScope.s.name}
${s["name"]}
<%
    School school = new School("清华大学", s);
    request.setAttribute("school", school);
%>
从school中取得的学生姓名${school.stu.name}
${school.stu.age}
<!-- 从List中取得数据 -->
<%
    List<Student> list  = new ArrayList<Student>();
    list.add(new Student("李四", 24));
    list.add(new Student("王五", 25));
    list.add(new Student("赵六", 26 ));
    request.setAttribute("list", list);
%>
${list[1].name}<br>

<!-- 从map中获取数据 -->
<%
    Map<String,String> map =new HashMap<String, String>();
    map.put("name", "harry");
    map.put("password", "123456");
    request.setAttribute("map", map);
%>
${map.name}<br>
${map.password}<br>

<!-- 运算符 -->
${ 2 > 1} <br>
${2 == 2} <br>
${2 + 2} <br>

</body>
</html>
