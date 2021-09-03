<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/25/2021
  Time: 2:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/addBook" var="addBook"/>
<form class="transparent" action="${addBook}" method="POST">
    <div class="form-inner">
        <h3>add book</h3>
        <label for="bookName">bookName</label>
        <input type="text" name="bookName" id="bookName" required>

        <label for="publisher">publisher</label>
        <input type="text" name="publisher" id="publisher" required>

        <label for="author">author</label>
        <input type="text" name="author" id="author" required>

        <label for="year">year</label>
        <input type="number" name="year" id="year" required>


        <label for="searchable">searchable</label>
        <input type="text" name="searchable" id="searchable" required>

        <input type="submit" value="submit" name="sub">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </div>
</form>
</body>
</html>
