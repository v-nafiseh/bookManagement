<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/25/2021
  Time: 2:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/addUser" var="addUser"/>
<form class="transparent" action="${addUser}" method="POST">
    <div class="form-inner">
        <h3>enter user details</h3>
        <label for="username">username</label>
        <input type="text" name="username" id="username" required>

        <label for="password">password</label>
        <input type="text" name="password" id="password" required>
        <input type="submit" value="submit" name="sub">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </div>
</form>
</body>
</html>
