<html>
<body>
<h2>Hello World!</h2>


<!--
    模拟修改操作
    1. 原始数据为: 1, Tom, 123456,tom@atguigu.com,12
    2. 密码不能被修改.
    3. 表单回显, 模拟操作直接在表单填写对应的属性值
-->
<form action="testModelAttribute" method="Post">
    <input type="hidden" name="id" value="1"/>
    username: <input type="text" name="username" value="Tom"/>
    <br>
    email: <input type="text" name="email" value="tom@atguigu.com"/>
    <br>
    age: <input type="text" name="age" value="12"/>
    <br>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>
