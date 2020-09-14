package com.booklist.servlet;

import com.booklist.beans.User;
import com.booklist.service.UserAccountManager;

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
            user = userAccountManager.findUser(userId,password);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
            rd.forward(request, response);

        }catch (Exception e){
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
            out.println("<a href=\"index.html\"><span style=\"font-family: Courier\">Re-login Here</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
