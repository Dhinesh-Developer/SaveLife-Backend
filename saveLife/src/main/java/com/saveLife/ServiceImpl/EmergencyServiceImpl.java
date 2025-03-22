package com.saveLife.ServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.saveLife.Model.Emergency;
import com.saveLife.Service.EmergencyService;

public class EmergencyServiceImpl implements EmergencyService {
    
    private static final String URL = "jdbc:mysql://localhost:3306/savelife";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root@dk";

    private static final String INSERT = "INSERT INTO emergency (pId, hId, location, emergencyType, symptoms, vitalSigns, AiRecommendations, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String FETCHALL = "SELECT * FROM emergency";
    private static final String FETCH_BY_ID = "SELECT * FROM emergency WHERE eId = ?";
    private static final String UPDATE = "UPDATE emergency SET status = ? WHERE eId = ?";
    private static final String DELETE = "DELETE FROM emergency WHERE eId = ?";

    @Override
    public List<Emergency> fetchAll() {
        List<Emergency> emergencies = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(FETCHALL)) {
            
            while (rs.next()) {
                Emergency emergency = new Emergency(
                        rs.getInt("eId"),
                        rs.getInt("pId"),
                        rs.getInt("hId"),
                        rs.getString("location"),
                        rs.getString("emergencyType"),
                        rs.getString("symptoms"),
                        rs.getString("vitalSigns"),
                        rs.getString("AiRecommendations"),
                        rs.getString("status")
                );
                emergencies.add(emergency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emergencies;
    }

    @Override
    public int insert(Emergency emergency) {
        int result = 0;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(INSERT)) {

            pstmt.setInt(1, emergency.getpId());
            pstmt.setInt(2, emergency.gethId());
            pstmt.setString(3, emergency.getLocation());
            pstmt.setString(4, emergency.getEmergencyType());
            pstmt.setString(5, emergency.getSymptoms());
            pstmt.setString(6, emergency.getVitalSigns());
            pstmt.setString(7, emergency.getAiRecommendations());
            pstmt.setString(8, emergency.getStatus());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Emergency emergency) {
        int result = 0;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(UPDATE)) {

            pstmt.setString(1, emergency.getStatus());
            pstmt.setInt(2, emergency.geteId());
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(int eId) {
        int result = 0;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(DELETE)) {
            pstmt.setInt(1, eId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Emergency fetchById(int eId) {
        Emergency emergency = null;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(FETCH_BY_ID)) {

            pstmt.setInt(1, eId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                emergency = new Emergency(
                        rs.getInt("eId"),
                        rs.getInt("pId"),
                        rs.getInt("hId"),
                        rs.getString("location"),
                        rs.getString("emergencyType"),
                        rs.getString("symptoms"),
                        rs.getString("vitalSigns"),
                        rs.getString("AiRecommendations"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emergency;
    }
}
