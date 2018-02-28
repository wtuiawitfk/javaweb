<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: yuhonghao
  Date: 2018/2/23
  Time: 下午7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>当前时间</title>
</head>
<body>
<%=new Date().toLocaleString()%><br/>
<% String name = "yuhh"; %>
<%=name%><br/>
<% int num = 1 / 0;%>
<%=num%>
</body>
</html>
