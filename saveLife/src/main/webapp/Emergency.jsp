<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.saveLife.Model.Emergency" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Emergency List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4 text-center">Emergency Cases</h2>
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Emergency ID</th>
                    <th>Patient ID</th>
                    <th>Hospital ID</th>
                    <th>Location</th>
                    <th>Emergency Type</th>
                    <th>Symptoms</th>
                    <th>Vital Signs</th>
                    <th>AI Recommendations</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Emergency> emergencyList = (List<Emergency>) request.getAttribute("emergencyList");
                    if (emergencyList != null && !emergencyList.isEmpty()) {
                        for (Emergency emergency : emergencyList) {
                %>
                <tr>
                    <td><%= emergency.geteId() %></td>
                    <td><%= emergency.getpId() %></td>
                    <td><%= emergency.gethId() %></td>
                    <td><%= emergency.getLocation() %></td>
                    <td><%= emergency.getEmergencyType() %></td>
                    <td><%= emergency.getSymptoms() %></td>
                    <td><%= emergency.getVitalSigns() %></td>
                    <td><%= emergency.getAiRecommendations() %></td>
                    <td><%= emergency.getStatus() %></td>
                    <td>
                        <a href="EditEmergency.jsp?eId=<%= emergency.geteId() %>" class="btn btn-primary btn-sm">Edit</a>
                        <a href="DeleteEmergencyServlet?eId=<%= emergency.geteId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="10" class="text-center">No emergency cases found.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <
        <div class="text-center">
            <a href="AddEmergency.jsp" class="btn btn-success">Add New Emergency</a>
        </div>
    </div>
</body>
</html>
