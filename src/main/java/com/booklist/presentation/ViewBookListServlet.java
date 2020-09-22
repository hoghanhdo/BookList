package com.booklist.presentation;

import com.booklist.beans.BookListInfo;
import com.booklist.beans.User;
import com.booklist.service.BookListManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/booklist")
public class ViewBookListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int accountId = user.getId();
        BookListManager bookListManager = new BookListManager();
        List<BookListInfo> bookList;
        try{
            bookList =  bookListManager.showBookList(accountId);
            request.setAttribute("bookList", bookList);
            RequestDispatcher rd = request.getRequestDispatcher("/viewBookList.jsp");
            rd.forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\" />");
            out.println("<title>Login Failed</title>");
            out.println("</head>");
            out.println("<body>");
            out.println();
            out.println("<span style=\"font-family: Courier; color:red\">");
            out.println(e.getMessage());
            out.println("</span>");
            out.println("<br>");
            out.println("<a href=\"homepage.jsp\"><span style=\"font-family: Courier\">Back to homepage</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
