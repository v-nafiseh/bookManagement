<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>edit</title>
</head>
<body>

<%--<c:url value="updateUser" var="updateUser"/>--%>
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