package com.saveLife.ServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.saveLife.Model.MedicalRecords;
import com.saveLife.Service.MedicalReportService;

public class MedicalReportServiceImpl implements MedicalReportService {

    private static final String URL = "jdbc:mysql://localhost:3306/savelife";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root@dk";
    
   
    private static final String FETCHALL = "SELECT * FROM medicalrecords";
    private static final String FETCH_BY_ID = "SELECT * FROM medicalrecords WHERE mrId = ?";
    private static final String UPDATE = "UPDATE medicalrecords SET date=?,  treatment=?, medications=?, notes=?, pId=? WHERE mrId=?";
    
    @Override
    public List<MedicalRecords> fetchAll() {
        List<MedicalRecords> records = new ArrayList<>();
        
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(FETCHALL)) {
            
            while(rs.next()){
                MedicalRecords mr = new MedicalRecords(
                    rs.getInt("mrId"),
                    rs.getString("date"),
                   
                    rs.getString("treatment"),
                    rs.getString("medications"),
                    rs.getString("notes"),
                    rs.getInt("pId")
                );
                records.add(mr);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
    
    @Override
    public MedicalRecords fetchById(int mrId) {
        MedicalRecords record = null;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(FETCH_BY_ID)) {
            
            pstmt.setInt(1, mrId);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                record = new MedicalRecords(
                    rs.getInt("mrId"),
                    rs.getString("date"),
                    
                    rs.getString("treatment"),
                    rs.getString("medications"),
                    rs.getString("notes"),
                    rs.getInt("pId")
                );
            }
            rs.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return record;
    }
    
    @Override
    public int update(MedicalRecords medicalrecords) {
        int result = 0;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(UPDATE)) {
            
            pstmt.setString(1, medicalrecords.getDate());
          
            pstmt.setString(2, medicalrecords.getTreatment());
            pstmt.setString(3, medicalrecords.getMedications());
            pstmt.setString(4, medicalrecords.getNotes());
            pstmt.setInt(5, medicalrecords.getpId());
            pstmt.setInt(6, medicalrecords.getMrId());
            
            result = pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
