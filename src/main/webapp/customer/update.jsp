<%--
  Created by IntelliJ IDEA.
  User: AE
  Date: 5/25/2022
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form method="post">
<input type="text" name="id" placeholder="Enter in id"value="${update.id}">
<input type="text" name="name" placeholder="Enter in name" value="${update.name}">
<input type="text" name="age" placeholder="Enter in age" value="${update.age}">
<button>Click</button>
</form>

</body>
</html>
