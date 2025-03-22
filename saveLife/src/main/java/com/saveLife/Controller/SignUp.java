package com.saveLife.Controller;

import java.io.IOException;

import com.saveLife.Model.User;
import com.saveLife.Service.UserService;
import com.saveLife.ServiceImpl.ServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		User u = new User(name,email,password,role);
		UserService us = new ServiceImpl();
		int status = us.insert(u);
		
		if(status>0) {
			response.sendRedirect("Home.jsp");
		}else {
			response.sendRedirect("Error.jsp");
		}
		
	}

}
