package com.saveLife.Controller;

import java.io.IOException;
import java.util.List;

import com.saveLife.Model.User;
import com.saveLife.Service.UserService;
import com.saveLife.ServiceImpl.ServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserService us = new ServiceImpl();
        List<User> fetch = us.fetchAll();

        if (fetch == null || fetch.isEmpty()) {
            request.setAttribute("errorMessage", "No users found in the database.");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            return;
        }

        boolean isFound = false;
        User loggedInUser = null;

        for (User f : fetch) {
            if (f.getEmail().equals(email) && f.getPasswd().equals(password)) {
                isFound = true;
                loggedInUser = f;
                break;
            }
        }

        if (isFound) {
            
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", loggedInUser);
            response.sendRedirect("Home.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid email or password.");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }
}
