<%--
  Created by IntelliJ IDEA.
  User: honghanh
  Date: 2020/09/12
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %><html>

<head>
    <title>Homepage</title>
</head>
<body>
    <img src="images/bookshelf21.jpg" alt="Bookshelf" width="600" height="326"/><br>
    <p style="font-family: Courier; color: grey">
         User: ${user.firstName} ${user.lastName}
    </p>
    <p style="font-family: Courier; color: #b8860b; font-size: larger">
        <a href="booklist">♦︎ View your book list</a><br>
        <a href="searchBook">♦︎ Search books</a><br>
        <a href="addBook">♦ Add books</a><br>
        <a href="logout">♦︎ Logout</a>
    </p>
</body>
</html>
