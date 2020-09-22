<%--
  Created by IntelliJ IDEA.
  User: honghanh
  Date: 2020/09/13
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Add Book</title>
</head>
<body>
    <p>
        <img src="images/bookshelf24.jpg" alt="BookShelf Marvel" width="600" height="326"><br>
    </p>
    <p style="font-family: Courier; color: darkgoldenrod">
        Fill in the below items to add a book<br>
    </p>

    <div>
        <span style="font-family: Courier; color: crimson;">${errorMessage}</span>
    </div>

    <div>
        <c:url var="actionPath" value="/addBook"/>
        <form method="post" action="${actionPath}">
            <table>
                <tr style="font-family: Courier">
                    <th style="background: steelblue; color: antiquewhite"><label for="title">Title</label></th>
                    <td><input type="text" name="title" id="title" autofocus></td>
                </tr>
                <tr style="font-family: Courier">
                    <th style="background: steelblue; color: antiquewhite">Author</th>
                    <td><input type="text" name="author"></td>
                </tr>
                <tr style="font-family: Courier">
                    <th style="background: steelblue; color: antiquewhite">Rating</th>
                    <td><input type="text" name="rating"></td>
                </tr>
                <tr style="font-family: Courier">
                    <th style="background: steelblue; color: antiquewhite">Pages</th>
                    <td><input type="text" name="pages"></td>
                </tr>
            </table><br>
            <input style="font-family: Courier; color: darkslateblue; background: beige" type="submit" value="Add book">
        </form>
    </div>
</body>
</html>
