package com.booklist.presentation;

import com.booklist.beans.User;
import com.booklist.service.UserAccountManager;
import com.booklist.utility.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/homepage")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        UserAccountManager userAccountManager = new UserAccountManager();
        User user;
        try{
            Validator.validateLoginName(userId);
            Validator.validatePassword(password);

            user = userAccountManager.findUser(userId,password);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
            rd.forward(request, response);

        }catch (Exception e){
            String loginErrorMessage = e.getMessage().toString();
            request.setAttribute("loginErrorMessage", loginErrorMessage);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }
}
