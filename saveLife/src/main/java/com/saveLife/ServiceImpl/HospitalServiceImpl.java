package com.saveLife.ServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.saveLife.Model.Hospital;
import com.saveLife.Service.HospitalService;

public class HospitalServiceImpl implements HospitalService {
    
    private static final String URL = "jdbc:mysql://localhost:3306/savelife";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root@dk";
    
    private static final String INSERT = "INSERT INTO hospital (name, location, contact, availableBeds, specialties, emergencyReady) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String FETCHALL = "SELECT * FROM hospital";
    private static final String FETCHBYID = "SELECT * FROM hospital WHERE hId = ?";
    private static final String UPDATE = "UPDATE hospital SET name=?, location=?, contact=?, availableBeds=?, specialties=?, emergencyReady=? WHERE hId=?";
    private static final String DELETE = "DELETE FROM hospital WHERE hId=?";
    
    @Override
    public List<Hospital> fetchAll() {
        List<Hospital> hospitals = new ArrayList<>();
        
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(FETCHALL)) {
            
            while(rs.next()){
                Hospital hospital = new Hospital(
                        rs.getInt("hId"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getString("contact"),
                        rs.getString("availableBeds"),
                        rs.getString("specialties"),
                        rs.getString("emergencyReady")
                );
                hospitals.add(hospital);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return hospitals;
    }
    
    @Override
    public int insert(Hospital hospital) {
        int result = 0;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(INSERT)) {
             
            pstmt.setString(1, hospital.getName());
            pstmt.setString(2, hospital.getLocation());
            pstmt.setString(3, hospital.getContact());
            pstmt.setString(4, hospital.getAvailableBeds());
            pstmt.setString(5, hospital.getSpecialties());
            pstmt.setString(6, hospital.getEmergencyReady());
            
            result = pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int update(Hospital hospital) {
        int result = 0;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(UPDATE)) {
             
            pstmt.setString(1, hospital.getName());
            pstmt.setString(2, hospital.getLocation());
            pstmt.setString(3, hospital.getContact());
            pstmt.setString(4, hospital.getAvailableBeds());
            pstmt.setString(5, hospital.getSpecialties());
            pstmt.setString(6, hospital.getEmergencyReady());
            pstmt.setInt(7, hospital.gethId());
            
            result = pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public void delete(int hId) {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(DELETE)) {
             
            pstmt.setInt(1, hId);
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Hospital fetchById(int hId) {
        Hospital hospital = null;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(FETCHBYID)) {
             
            pstmt.setInt(1, hId);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                hospital = new Hospital(
                        rs.getInt("hId"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getString("contact"),
                        rs.getString("availableBeds"),
                        rs.getString("specialties"),
                        rs.getString("emergencyReady")
                );
            }
            rs.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return hospital;
    }
}
