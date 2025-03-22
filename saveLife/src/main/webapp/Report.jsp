<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.saveLife.Model.MedicalRecords" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Medical Records</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Medical Records</h2>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Record ID</th>
                    <th>Date</th>
                   
                    <th>Treatment</th>
                    <th>Medications</th>
                    <th>Notes</th>
                    <th>Patient ID</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<MedicalRecords> records = (List<MedicalRecords>) request.getAttribute("records");
                    if (records != null && !records.isEmpty()) {
                        for (MedicalRecords record : records) {
                %>
                    <tr>
                        <td><%= record.getMrId() %></td>
                        <td><%= record.getDate() %></td>
                        
                        <td><%= record.getTreatment() %></td>
                        <td><%= record.getMedications() %></td>
                        <td><%= record.getNotes() %></td>
                        <td><%= record.getpId() %></td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="7" class="text-center">No records found.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
