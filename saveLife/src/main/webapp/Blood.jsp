<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.saveLife.Model.Blood" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blood Inventory</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Blood Inventory</h2>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Blood ID</th>
                    <th>Blood Type</th>
                    <th>Quantity</th>
                    <th>Critical</th>
                    <th>Hospital ID</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Blood> bloodList = (List<Blood>) request.getAttribute("bloodList");
                    if (bloodList != null && !bloodList.isEmpty()) {
                        for (Blood blood : bloodList) {
                %>
                    <tr>
                        <td><%= blood.getbId() %></td>
                        <td><%= blood.getBloodType() %></td>
                        <td><%= blood.getQuantity() %></td>
                        <td><%= blood.isCritical() ? "Yes" : "No" %></td>
                        <td><%= blood.gethId() %></td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="5" class="text-center">No blood records found.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
