<%--
  Created by IntelliJ IDEA.
  User: yuhonghao
  Date: 2018/2/27
  Time: 下午3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息列表</title>
</head>
<body>
<h2 align="center">学生信息列表</h2>
<a href="/student?cmd=edit">新增学生</a>
<table align="center" border="1" cellpadding="0" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="stu" varStatus="vs">
        <tr>
            <td>${vs.index+1}</td>
            <td>${pageScope.stu.name}</td>
            <td>${pageScope.stu.age}</td>
            <td><a href="/student?cmd=edit&id=${stu.id}&name=${stu.name}&age=${stu.age}">编辑</a>|<a href="/student?cmd=delete&id=${stu.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
