package com.saveLife.Controller;

import java.io.IOException;
import java.util.List;
import com.saveLife.Model.Blood;
import com.saveLife.Service.BloodService;
import com.saveLife.ServiceImpl.BloodServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BloodServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public BloodServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        BloodService bs = new BloodServiceImpl();
        List<Blood> bloodList = bs.fetchAll();
        
        request.setAttribute("bloodList", bloodList);
        RequestDispatcher rd = request.getRequestDispatcher("Blood.jsp");
        rd.forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doPost(request, response);
    }
}
