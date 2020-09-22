<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<img src="images/bookshelf.jpg" alt="Bookshelf" width= "483" height= "321"><br>
    <p>
        <span style="font-family: Courier; color:crimson;">${loginErrorMessage}</span>
    </p>
    <form method="post" action="homepage">
        <table style="font-family: Courier; font-size: 20px">
            <tr>
                <td><label for="userId">User ID</label></td>
                <td><input type="text" name="userId" id="userId" autofocus/></td>
            </tr>
            <tr>
                <td><label for="password">Password</label></td>
                <td><input type="password" name="password" id="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login" style="font-family: Courier; font-size: 15px"></td>
            </tr>
        </table>
    </form>
</body>
</html>
