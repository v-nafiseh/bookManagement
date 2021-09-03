<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/25/2021
  Time: 4:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
div class="container">

<br>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3>Book Details</h3>
    </div>
    <div class="panel-body">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Book Name</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Year</th>
                <th>Searchable</th>


            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${book.bookName}</td>
                <td>${book.author}</td>
                <td>${book.publisher}</td>
                <td>${book.year}</td>
                <td>${book.searchable}</td>


            </tr>

            </tbody>
        </table>


    </div>
</div>

</div>
</body>
</html>
