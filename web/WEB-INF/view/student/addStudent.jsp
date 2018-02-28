<%--
  Created by IntelliJ IDEA.
  User: yuhonghao
  Date: 2018/2/27
  Time: 下午4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增学生</title>
</head>
<body>
<h2 align="center">新增学生</h2>
<form action="/student?cmd=saveOrUpdate" method="post">
    <table align="center" cellspacing="0" cellpadding="0" border="1">
        <td>
            学生姓名：<input type="text" name="name"><br/>
            学生年龄：<input type="text" name="age"><br/>
            <input type="submit" value="保存">
        </td>
    </table>
</form>
</body>
</html>
