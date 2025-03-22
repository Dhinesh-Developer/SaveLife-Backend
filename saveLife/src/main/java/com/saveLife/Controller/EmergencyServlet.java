package com.saveLife.Controller;

import java.io.IOException;
import java.util.List;

import com.saveLife.Model.Emergency;
import com.saveLife.Service.EmergencyService;
import com.saveLife.ServiceImpl.EmergencyServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmergencyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EmergencyService es = new EmergencyServiceImpl();
        List<Emergency> emergencyList = es.fetchAll();
        
        request.setAttribute("emergencyList", emergencyList);
        RequestDispatcher rd = request.getRequestDispatcher("Emergency.jsp");
        rd.forward(request, response);
    }
}
