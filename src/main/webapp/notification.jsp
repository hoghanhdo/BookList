<%--
  Created by IntelliJ IDEA.
  User: honghanh
  Date: 2020/09/21
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Added Successfully</title>
</head>
<body>
    <p>
        <img src="images/bookshelf22.jpg" alt="Magazine" width="600" height="326">
    </p>

    <p style="font-family: Courier">
        <span style="color: coral">${message}</span><br>
            <table style="color: cornflowerblue">
                <tr align="left">
                    <th>Book title:</th>
                    <td>${book.title}</td>
                </tr>
                <tr align="left">
                    <th>Author:</th>
                    <td>${book.author}</td>
                </tr>
                <tr align="left">
                    <th>Rating:</th>
                    <td>${book.rating}</td>
                </tr>
                <tr align="left">
                    <th>Pages:</th>
                    <td>${book.pages}</td>
                </tr>
            </table>
    </p>
    <p>
        <a href="booklist" style="color: darkred; font-family: Courier">View your book list</a>
    </p>
</body>
</html>
