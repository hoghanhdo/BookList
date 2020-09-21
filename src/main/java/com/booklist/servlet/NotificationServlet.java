package com.booklist.servlet;

import com.booklist.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/notification")
public class NotificationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.getAttribute("message");
        request.getAttribute("book");

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\" />");
        out.println("<title>Added successfully</title>");
        out.println("</head>");
        out.println("<body>");
        out.println();
        out.println("<span style=\"font-family: Courier; color: cornflowerblue\">");
        out.println("${message}");
        out.println("</span>");
        out.println("<br>");
        out.println("<span style=\"font-family: Courier; color: coral\">");
        out.println("${book.title}<br>");
        out.println("${book.author}<br>");
        out.println("${book.rating}<br>");
        out.println("${book.pages}<br>");
        out.println("</span>");
        out.println("<br>");
        out.println("<a href=\"viewBookList.jsp\"><span style=\"font-family: Courier\">See your book list</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
