package com.saveLife.ServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.saveLife.Model.Blood;
import com.saveLife.Service.BloodService;

public class BloodServiceImpl implements BloodService {
    
    private static final String URL = "jdbc:mysql://localhost:3306/savelife";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root@dk";
    
    private static final String INSERT = "INSERT INTO blood_inventory (bloodType, quantity, critical, hId) VALUES (?, ?, ?, ?)";
    private static final String FETCHALL = "SELECT * FROM blood_inventory";
    private static final String FETCH_BY_ID = "SELECT * FROM blood_inventory WHERE bId = ?";
    private static final String UPDATE = "UPDATE blood_inventory SET bloodType=?, quantity=?, critical=?, hId=? WHERE bId=?";
    private static final String DELETE = "DELETE FROM blood_inventory WHERE bId=?";
    
    @Override
    public List<Blood> fetchAll() {
        List<Blood> bloodList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(FETCHALL)) {
            
            while (rs.next()) {
                Blood blood = new Blood(
                        rs.getInt("bId"),
                        rs.getString("bloodType"),
                        rs.getInt("quantity"),
                        rs.getBoolean("critical"),
                        rs.getInt("hId")
                );
                bloodList.add(blood);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bloodList;
    }
    
    @Override
    public int insert(Blood blood) {
        int result = 0;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(INSERT)) {
            
            pstmt.setString(1, blood.getBloodType());
            pstmt.setInt(2, blood.getQuantity());
            pstmt.setBoolean(3, blood.isCritical());
            pstmt.setInt(4, blood.gethId());
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int update(Blood blood) {
        int result = 0;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(UPDATE)) {
            
            pstmt.setString(1, blood.getBloodType());
            pstmt.setInt(2, blood.getQuantity());
            pstmt.setBoolean(3, blood.isCritical());
            pstmt.setInt(4, blood.gethId());
            pstmt.setInt(5, blood.getbId());
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public void delete(int bId) {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(DELETE)) {
            
            pstmt.setInt(1, bId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Blood fetchById(int bId) {
        Blood blood = null;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(FETCH_BY_ID)) {
            
            pstmt.setInt(1, bId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                blood = new Blood(
                        rs.getInt("bId"),
                        rs.getString("bloodType"),
                        rs.getInt("quantity"),
                        rs.getBoolean("critical"),
                        rs.getInt("hId")
                );
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blood;
    }
}
