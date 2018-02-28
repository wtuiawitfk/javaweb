<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: yuhonghao
  Date: 2018/2/26
  Time: 上午11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL标签--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>JSTL标签</title>
</head>
<body>
<%--C标签--%>
<%
    Integer age = 45;
    request.setAttribute("age", age);
%>
<c:if test="${age>=18}">
    你满足要求！<br/>
</c:if>
<c:if test="${age>18}" var="ret" scope="page">
    ${pageScope.ret}<br/>
</c:if>
<hr/>
<%--choose标签--%>
<c:choose>
    <c:when test="${age>80}">
        你太老了！<br/>
    </c:when>
    <c:when test="${age<18}">
        你太小了！<br/>
    </c:when>
    <c:otherwise>
        你可以的！<br/>
    </c:otherwise>
</c:choose>
<%--foreach标签--%>
<%
    List<String> names = Arrays.asList("yuhh", "gth", "yxy");
    request.setAttribute("names", names);
%>
<c:forEach items="${names}" var="name">
    ${name}
</c:forEach>
<br/>
<c:forEach var="num" begin="1" end="10" step="1">
    ${num}
</c:forEach>
<%--国际化标签--%>
<%--设置国际化资源文件名称--%>
<fmt:bundle basename="app"/>
<form action="#">
    <fmt:message key="username"/>：<input type="text"><br/>
    <fmt:message key="password"/>：<input type="password"><br/>
    <input type="submit" value="login"><br/>
</form>
<%
    Date date = new Date();
    request.setAttribute("date", date);
%>
<fmt:formatDate value="${date}" pattern="yyyy年MM月dd日 hh时mm分ss秒"/>
</body>
</html>
