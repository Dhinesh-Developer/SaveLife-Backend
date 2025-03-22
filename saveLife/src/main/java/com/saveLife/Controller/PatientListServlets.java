package com.saveLife.Controller;

import java.io.IOException;
import java.util.List;

import com.saveLife.Model.Patient;
import com.saveLife.Service.PatientService;
import com.saveLife.ServiceImpl.PatientServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PatientListServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PatientListServlets() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        PatientService ps = new PatientServiceImpl();
        List<Patient> patients = ps.fetchAll();
        
       
        request.setAttribute("patients", patients);
        
       
        RequestDispatcher rd = request.getRequestDispatcher("Patient.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}
