package com.booklist.presentation;

import com.booklist.beans.Book;
import com.booklist.beans.User;
import com.booklist.service.BookListManager;
import com.booklist.utility.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        BookListManager bookListManager = new BookListManager();

        try {
            String title = "";
            String author = "";
            double rating = 0.0;
            int pages = 0;

            if (Validator.validateTitle(request.getParameter("title"))) {
                title = request.getParameter("title");
            }
            if (Validator.validateAuthor(request.getParameter("author"))) {
                author = request.getParameter("author");
            }

            if(request.getParameter("rating").length() != 0 && Validator.isNumeric(request.getParameter("rating"), "Rating")){
                rating = Double.parseDouble(request.getParameter("rating"));
            }else{
                rating = 0.0;
            }

            if(request.getParameter("pages").length() != 0 && Validator.isNumeric(request.getParameter("pages"), "Pages")){
                pages = Integer.parseInt(request.getParameter("pages"));
            }else{
                pages = 0;
            }
            
            Book book = new Book(title, author, rating, pages);
            bookListManager.addBook(book, userId);
            String message = "Book has been successfully added.";
            request.setAttribute("message", message);
            request.setAttribute("book", book);
            RequestDispatcher rd = request.getRequestDispatcher("/notification.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher rd = request.getRequestDispatcher("/addBook.jsp");
            rd.forward(request, response);
        }
    }
}
