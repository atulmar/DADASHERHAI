<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ProductController" method="post">
<c:if test="${param.action eq 'edit' }">
<input type="hidden" name="action" value="update">
</c:if>
<c:if test="${param.action eq 'new' }">
<input type="hidden" name="action" value="save">
</c:if>
<table>
<tr>
<td>Id</td>
<td><input type="text" name="productId" value="${ product.productId}"></td>
</tr>
<tr>
<td>ProductCode</td>
<td><input type="text" name="productCode" value="${ product.productCode}" ></td>
</tr>
<tr>
<td>ProductDescription</td>
<td><input type="text" name="productDesc" value="${ product.description}" ></td>
</tr>
<tr>
<td>ProductPrice</td>
<td><input type="text" name="productPrice" value="${ product.price}" ></td>
</tr>
<tr>
<td>Manufacturing Date</td>
<fmt:formatDate value="${product.munfDate}" pattern="dd/MM/yyyy" var="mdate"/>
<td><input type="text" name="munfDate" value="${mdate}" ></td>
</tr>
<tr>
<td><input type="submit"></td>
<td><input type="reset"></td>
</tr>
</table>
</form>
</body>
</html>