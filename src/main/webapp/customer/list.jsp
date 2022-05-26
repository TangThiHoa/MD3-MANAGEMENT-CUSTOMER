<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AE
  Date: 5/25/2022
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1><a href="/customers?action=create">Create product</a></h1
<c:forEach items="${danhSach}" var="customer">
    <h2>${customer.id},${customer.name},${customer.age}
    <a href="/customers?action=edit&id=${customer.id}">Edit</a>
    <a href="/customers?action=delete&id=${customer.id}">Delete</a>
    </h2>
</c:forEach>


</body>
</html>
