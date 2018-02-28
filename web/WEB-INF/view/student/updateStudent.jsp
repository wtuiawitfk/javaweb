<%@ page import="javax.naming.Name" %><%--
  Created by IntelliJ IDEA.
  User: yuhonghao
  Date: 2018/2/27
  Time: 下午5:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑学生信息</title>
</head>
<h2 align="center">编辑学生信息</h2>
<body>
<form action="/student?cmd=saveOrUpdate" method="post">
    <table align="center" cellpadding="0" cellspacing="0" border="1">
        <td>
            <input type="hidden" value="${param.id}" name="id"><br/>
            学生姓名：<input type="text" value="${param.name}" name="name"/><br/>
            学生年龄：<input type="text" value="${param.age}" name="age"/><br/>
            <input align="center" type="submit" value="提交">
        </td>
    </table>
</form>
</body>
</html>
