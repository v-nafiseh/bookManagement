<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/25/2021
  Time: 2:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>publisher</title>
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
        <a href="/update/${book.id}" class="link">update</a>
        <a href="/deleteBook/${book.id}" class="link">delete</a>
        <a href="/get_book/${book.id}"   class="link">get</a>
      </td>
    </tr>
  </c:forEach>
</table>

<h2 class="headline">add book</h2>
<c:url value="/addBook" var="addBook"/>
<a href="${addBook}" class="link">add</a>



</body>
</html>
