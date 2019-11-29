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
<a href="ProductController?action=new">Add</a>
<table border="2">
<tr>
<td>Id</td>
<td>Code</td>
<td>Desc</td>
<td>Price</td>
<td>Date</td>
<td>Category</td>
<td>Action</td>
<td>
</tr>
<c:forEach items="${ list}" var="product">
<tr>
<td>${ product.productId}</td>
<td>${ product.productCode}</td>
<td>${ product.description}</td>
<td>${ product.price}</td>
<%-- <td>${ product.munfDate}</td> --%>
<td>

<fmt:formatDate value="${product.munfDate}" pattern="dd/MM/yyyy"/>
</td>
<td>${ product.categoryList}</td>
<td><a href="ProductController?action=delete&id=${ product.productId}">delete</a><a href="ProductController?action=edit&id=${ product.productId}">  edit</a></td>

</tr>
</c:forEach>
</table>
</body>
</html>