<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.saveLife.Model.Patient" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Patient List</h2>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Patient ID</th>
                    <th>Name</th>
                    <th>Unique ID</th>
                    <th>Date of Birth</th>
                    <th>Blood Type</th>
                    <th>Conditions</th>
                    <th>Medications</th>
                    <th>Emergency Contact</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Patient> patients = (List<Patient>) request.getAttribute("patients");
                    if (patients != null && !patients.isEmpty()) {
                        for (Patient patient : patients) {
                %>
                    <tr>
                        <td><%= patient.getpId() %></td>
                        <td><%= patient.getName() %></td>
                        <td><%= patient.getUniqueId() %></td>
                        <td><%= patient.getDOB() %></td>
                        <td><%= patient.getBloodType() %></td>
                        <td><%= patient.getConditions() %></td>
                        <td><%= patient.getMedications() %></td>
                        <td><%= patient.getEmergencyContact() %></td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="8" class="text-center">No patients found.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
