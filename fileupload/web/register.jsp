<%--
  Created by IntelliJ IDEA.
  User: yuhonghao
  Date: 2018/3/2
  Time: 下午8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    上传头像<input type="file" name="headImg"/><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
