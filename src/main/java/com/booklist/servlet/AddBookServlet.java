package com.booklist.servlet;

import com.booklist.beans.Book;
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

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getId();

        String author = request.getParameter("author");
        String title = request.getParameter("title");
        double rating = Double.parseDouble(request.getParameter("rating"));
        int pages = Integer.parseInt(request.getParameter("pages"));
        Book book = new Book(title, author, rating, pages);

        BookListManager bookListManager = new BookListManager();

        try{
            bookListManager.addBook(book, userId);
            String message = "Book has been successfully added.";
            request.setAttribute("message", message);
            request.setAttribute("book", book);
            RequestDispatcher rd = request.getRequestDispatcher("/notification.jsp");
            rd.forward(request, response);
        }catch (Exception e){
            String errorMessage = e.getMessage();
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher rd = request.getRequestDispatcher("/addBook.jsp");
            rd.forward(request,response);
        }
    }
}
