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
<c:url value="/updateUser" var="updateUser"/>
<form class="transparent" action="${updateUser}">
    <div class="form-inner">
        <h3>update user</h3>


        <label for="username">username</label>
        <input type="text" name="username" id="username" value="${user.username}" required>


        <input type="submit" value="Edit book" name="sub">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </div>
</form>
</body>
</html>
