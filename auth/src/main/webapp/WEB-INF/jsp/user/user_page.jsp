<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/25/2021
  Time: 4:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 class="headline">BOOK LIST</h3>
<table>
    <tr>
        <th>bookName</th>
        <th>author</th>
        <th>publisher</th>
        <th>year</th>
        <th>date</th>
        <th>searchable</th>


    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.bookName}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.year}</td>
            <td>${book.searchable}</td>

            <td>
                <a href="/user/get_book/${book.id}"   class="link">get</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
