package com.saveLife.Controller;

import java.io.IOException;
import java.util.List;
import com.saveLife.Model.MedicalRecords;
import com.saveLife.Service.MedicalReportService;
import com.saveLife.ServiceImpl.MedicalReportServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MedicalReportsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MedicalReportsServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        MedicalReportService mrs = new MedicalReportServiceImpl();
        List<MedicalRecords> records = mrs.fetchAll();
        
        request.setAttribute("records", records);
        RequestDispatcher rd = request.getRequestDispatcher("Reports.jsp");
        rd.forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request, response);
    }
}
