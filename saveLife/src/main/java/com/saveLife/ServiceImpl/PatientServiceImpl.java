package com.saveLife.ServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saveLife.Model.Patient;
import com.saveLife.Service.PatientService;

public class PatientServiceImpl implements PatientService {

    private static final String URL = "jdbc:mysql://localhost:3306/savelife";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root@dk";

    private static final String INSERT = "INSERT INTO patient (name, uniqueId, DOB, bloodType, conditions, medications, emergencyContact) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECTALL = "SELECT * FROM patient";
    private static final String SELECT_BY_ID = "SELECT * FROM patient WHERE uniqueId = ?";
    private static final String DELETE = "DELETE FROM patient WHERE pId = ?";

    @Override
    public List<Patient> fetchAll() {
        List<Patient> patients = new ArrayList<>();
        
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet res = stmt.executeQuery(SELECTALL)) {

            while (res.next()) {
                Patient p = new Patient(
                        res.getInt("pId"),
                        res.getString("name"),
                        res.getInt("uniqueId"),
                        res.getDate("DOB"),
                        res.getString("bloodType"),
                        res.getString("conditions"),
                        res.getString("medications"),
                        res.getString("emergencyContact")
                );
                patients.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public int insert(Patient patient) {
        int result = 0;
        
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(INSERT)) {
             
            pstmt.setString(1, patient.getName());
            pstmt.setInt(2, patient.getUniqueId());
            pstmt.setDate(3, new java.sql.Date(patient.getDOB().getTime()));
            pstmt.setString(4, patient.getBloodType());
            pstmt.setString(5, patient.getConditions());
            pstmt.setString(6, patient.getMedications());
            pstmt.setString(7, patient.getEmergencyContact());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Patient fetchById(int uniqueId) {
        Patient patient = null;

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(SELECT_BY_ID)) {
             
            pstmt.setInt(1, uniqueId);
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                patient = new Patient(
                        res.getInt("pId"),
                        res.getString("name"),
                        res.getInt("uniqueId"),
                        res.getDate("DOB"),
                        res.getString("bloodType"),
                        res.getString("conditions"),
                        res.getString("medications"),
                        res.getString("emergencyContact")
                );
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public void delete(int id) {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(DELETE)) {
             
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(Patient patient) {
        return 0;
    }
}
