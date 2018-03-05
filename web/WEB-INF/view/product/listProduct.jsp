<%--
  Created by IntelliJ IDEA.
  User: yuhonghao
  Date: 2018/3/1
  Time: 下午6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品信息列表</title>
</head>
<body>
<h2 align="center">商品信息列表</h2>
<a href="/product?cmd=edit" style="color: firebrick">增加商品</a>
<form action="#" method="post">
    <table align="center" cellpadding="0" cellspacing="0" border="1" width="90%">
        <tr style="background-color: darkorange">
            <th>编号</th>
            <th>名称</th>
            <th>分类</th>
            <th>售价</th>
            <th>供应商</th>
            <th>商标</th>
            <th>折价</th>
            <th>成本价</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="p" varStatus="vs">
            <tr align="center" style="background-color: ${vs.count%2==0? 'aliceblue':''}">
                <td>${vs.index+1}</td>
                <td>${p.productName}</td>
                <td>${p.productDir.dirName}</td>
                <td>${p.salePrice}</td>
                <td>${p.supplier}</td>
                <td>${p.brand}</td>
                <td>${p.cutoff}</td>
                <td>${p.costPrice}</td>
                <td>
                    <a href="/product?cmd=edit&id=${p.id}">编辑</a>|<a href="/product?cmd=delete&id=${p.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>