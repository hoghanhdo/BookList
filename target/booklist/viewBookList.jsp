<%--
  Created by IntelliJ IDEA.
  User: honghanh
  Date: 2020/09/12
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Book List</title>
</head>
<body>
    <img src="images/bookshelf22.jpg" alt="Bookshelf with a doll" width="600" height="326"/><br>

    <p style="font-family: Courier; color: grey;">
        User: ${user.firstName}, ${user.lastName}<br>
    </p>
    <form action="addBook.jsp">
        <input style="font-family: Courier; background: antiquewhite; color: darkred" type="submit" value="Add Book" />
    </form>
    <p>
        <span style="color: lightsalmon; font-family: Courier">${message}</span>
    <table style="font-family: Courier; width: 100%;" border="1">
        <colgroup>
            <col span="1" style="width: 45%;">
            <col span="1" style="width: 20%;">
            <col span="1" style="width: 15%;">
            <col span="1" style="width: 10%;">
            <col span="1" style="width: 10%;">
        </colgroup>
        <tbody>
            <tr style="color: beige; background: darkgoldenrod">
                <th>Book Title</th>
                <th>Author</th>
                <th>Added on</th>
                <th>Pages</th>
                <th>Rating</th>
            </tr>
            <c:forEach var="book" items="${bookList}">
                <tr>
                    <td><c:out value="${book.title}"/></td>
                    <td><c:out value="${book.author}"/></td>
                    <td align="center"><c:out value="${book.addedDate}"/></td>
                    <td align="center"><c:out value="${book.pages}"/></td>
                    <td align="center"><c:out value="${book.rating}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table><br>
    </p>
    <p>
    <form action="homepage.jsp">
        <input style="font-family: Courier; background: antiquewhite; color: darkred" type="submit" value="Back to homepage" />
    </form>
    </p>
</body>
</html>
