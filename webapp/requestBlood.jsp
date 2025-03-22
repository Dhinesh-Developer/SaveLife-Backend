<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blood Inventory - Smart Emergency Healthcare System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/js/all.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gagalin&family=Horizon&display=swap">
    <style>
        body {
            background-color: black;
            color: white;
            font-family: 'Gagalin', sans-serif;
        }
        .navbar {
            background-color: #0a0a0a;
            padding: 10px;
        }
        .navbar-brand {
            color: cyan !important;
            font-size: 24px;
            font-weight: bold;
            font-family: 'Horizon', sans-serif;
        }
        .nav-link {
            color: white !important;
        }
        .nav-link:hover {
            color: cyan !important;
        }
        .table {
            background-color: #1e1e1e;
            color: white;
        }
        .thead-dark {
            background-color: cyan;
        }
        .btn-custom {
            background-color: cyan;
            color: black;
            border-radius: 8px;
        }
        .btn-custom:hover {
            background-color: white;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg">
        <a class="navbar-brand" href="#">Smart Healthcare</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="Blood.jsp">Blood Inventory</a></li>
                <li class="nav-item"><a class="nav-link" href="donors.jsp">Donors</a></li>
                <li class="nav-item"><a class="nav-link" href="hospitals.jsp">Hospitals</a></li>
                <li class="nav-item"><a class="nav-link" href="logout.jsp">Logout</a></li>
            </ul>
        </div>
    </nav>

    <div class="container mt-4">
        <h2 class="text-center text-info">Blood Inventory</h2>
        <input type="text" id="search" class="form-control mb-3" placeholder="Search Blood Type..." onkeyup="filterTable()">
        
        <%-- Database Connection --%>
        <%
            String url = "jdbc:mysql://localhost:3306/savelife";
            String user = "root";
            String password = "root@dk";
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);
                pstmt = con.prepareStatement("SELECT * FROM blood_inventory");
                rs = pstmt.executeQuery();
        %>
        <table class="table table-bordered mt-3" id="bloodTable">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Blood Type</th>
                    <th>Quantity</th>
                    <th>Critical</th>
                    <th>Hospital ID</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% while (rs.next()) { %>
                    <tr>
                        <td><%= rs.getInt("bId") %></td>
                        <td><%= rs.getString("bloodType") %></td>
                        <td><%= rs.getInt("quantity") %></td>
                        <td><%= rs.getBoolean("critical") ? "Yes" : "No" %></td>
                        <td><%= rs.getInt("hId") %></td>
                        <td>
                            <a href="editBlood.jsp?id=<%= rs.getInt("bId") %>" class="btn btn-warning btn-sm">Edit</a>
                            <a href="deleteBlood.jsp?id=<%= rs.getInt("bId") %>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?');">Delete</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <% 
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            }
        %>

        <h3 class="mt-4 text-info">Add New Blood Record</h3>
        <form action="Blood.jsp" method="post" onsubmit="return validateForm()">
            <div class="form-group">
                <label>Blood Type:</label>
                <input type="text" name="bloodType" id="bloodType" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Quantity:</label>
                <input type="number" name="quantity" id="quantity" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Critical:</label>
                <select name="critical" class="form-control">
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>
            </div>
            <div class="form-group">
                <label>Hospital ID:</label>
                <input type="number" name="hId" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-custom">Add Blood Record</button>
        </form>
    </div>

    <script>
        function filterTable() {
            let input = document.getElementById("search").value.toUpperCase();
            let table = document.getElementById("bloodTable");
            let tr = table.getElementsByTagName("tr");
            for (let i = 1; i < tr.length; i++) {
                let td = tr[i].getElementsByTagName("td")[1];
                if (td) {
                    let txtValue = td.textContent || td.innerText;
                    tr[i].style.display = txtValue.toUpperCase().indexOf(input) > -1 ? "" : "none";
                }
            }
        }
    </script>
</body>
</html>