<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.saveLife.Model.Hospital" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hospital List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Hospital List</h2>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Hospital ID</th>
                    <th>Name</th>
                    <th>Location</th>
                    <th>Contact</th>
                    <th>Available Beds</th>
                    <th>Specialties</th>
                    <th>Emergency Ready</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Hospital> hospitals = (List<Hospital>) request.getAttribute("hospitals");
                    if (hospitals != null && !hospitals.isEmpty()) {
                        for (Hospital hospital : hospitals) {
                %>
                    <tr>
                        <td><%= hospital.gethId() %></td>
                        <td><%= hospital.getName() %></td>
                        <td><%= hospital.getLocation() %></td>
                        <td><%= hospital.getContact() %></td>
                        <td><%= hospital.getAvailableBeds() %></td>
                        <td><%= hospital.getSpecialties() %></td>
                        <td><%= hospital.getEmergencyReady() %></td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="7" class="text-center">No hospitals found.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
