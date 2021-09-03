<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>ADMIN PAGE</title>
</head>
<body>

<h3 class="headline">USER LIST</h3>
<table>
    <tr>
        <th>id</th>
        <th>username</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>
                <a href="/updateUser/${user.id}" class="link">update</a>
                <a href="/deleteUser/${user.id}" class="link">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2 class="headline">add user</h2>
<c:url value="/addUser" var="addUSer"/>
<a href="${addUSer}" class="link">add</a>






<%--<jsp:useBean id="command"  scope="request"></jsp:useBean>--%>
</body>
</html>

</body>
</html>