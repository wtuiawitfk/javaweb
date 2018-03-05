<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yuhonghao
  Date: 2018/3/4
  Time: 下午3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加商品</title>
</head>
<body>
<form
        action="${pageContext.request.contextPath}/product?cmd=saveOrUpdate"
        method="post">
    <input type="hidden" name="id" value="${pro.id}"/>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>货品名称</td>
            <td><input type="text" name="productName"
                       value="${pro.productName}"/></td>
        </tr>
        <tr>
            <td>货品品牌</td>
            <td><input type="text" name="brand" value="${pro.brand}"/></td>
        </tr>
        <tr>
            <td>供&nbsp;应&nbsp;商</td>
            <td><input type="text" name="supplier" value="${pro.supplier}"/></td>
        </tr>
        <tr>
            <td>零&nbsp;售&nbsp;价</td>
            <td><input type="text" name="salePrice"
                       value="${pro.salePrice}"/></td>
        </tr>
        <tr>
            <td>成&nbsp;本&nbsp;价</td>
            <td><input type="text" name="costPrice"
                       value="${pro.costPrice}"/></td>
        </tr>
        <tr>
            <td>折&emsp;&emsp;扣</td>
            <td><input type="text" name="cutoff" value="${pro.cutoff}"/></td>
        </tr>
        <tr>
            <td>货品分类</td>
            <td><select name="productDir">
                <c:forEach items="${dir}" var="pd">
                    <option value="${pd.id}"
                        ${pd.id==pro.productDir.id?'selected="selected"':''}>${pd.dirName}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="保存"/></td>
        </tr>
    </table>
</form>
</body>
</html>