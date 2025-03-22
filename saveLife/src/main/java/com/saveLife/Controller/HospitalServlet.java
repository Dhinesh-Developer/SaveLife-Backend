package com.saveLife.Controller;

import java.io.IOException;
import java.util.List;
import com.saveLife.Model.Hospital;
import com.saveLife.Service.HospitalService;
import com.saveLife.ServiceImpl.HospitalServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HospitalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public HospitalServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        HospitalService hs = new HospitalServiceImpl();
        List<Hospital> hospitals = hs.fetchAll();
        
        request.setAttribute("hospitals", hospitals);
        RequestDispatcher rd = request.getRequestDispatcher("Hospital.jsp");
        rd.forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request, response);
    }
}
