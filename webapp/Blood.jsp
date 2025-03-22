<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blood Bank</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body {
            background-color: black;
            color: white;
            font-family: 'Arial', sans-serif;
        }
        .navbar {
            background-color: #0a0a0a;
        }
        .navbar-brand {
            color: cyan !important;
            font-size: 24px;
            font-weight: bold;
        }
        .nav-link {
            color: white !important;
        }
        .container {
            margin-top: 20px;
            padding: 20px;
            background: #222;
            border-radius: 10px;
            box-shadow: 0px 0px 10px cyan;
        }
        .card {
            background-color: #1e1e1e;
            color: white;
            border: 1px solid #444;
        }
        .btn-custom {
            background-color: cyan;
            color: black;
        }
        .btn-custom:hover {
            background-color: white;
            color: black;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Blood Bank</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Donate</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Request</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
                </ul>
            </div>
        </div>
    </nav>
    
    <div class="container">
        <h2 class="text-center">Blood Bank Management</h2>
        <div class="d-flex justify-content-between my-3">
            <input type="text" id="search" class="form-control w-25" placeholder="Search by Name or Location">
            <select id="bloodGroup" class="form-select w-25">
                <option value="">All Blood Groups</option>
                <option value="A+">A+</option>
                <option value="A-">A-</option>
                <option value="B+">B+</option>
                <option value="B-">B-</option>
                <option value="O+">O+</option>
                <option value="O-">O-</option>
                <option value="AB+">AB+</option>
                <option value="AB-">AB-</option>
            </select>
            <button class="btn btn-custom" onclick="addBlood()">Add Blood Details</button>
            <button class="btn btn-warning" onclick="requestBlood()">Request Blood</button>
        </div>
        
        <div id="bloodData" class="row">
            <div class="col-md-4">
                <div class="card p-3 mb-3">
                    <h5>John Doe</h5>
                    <p>Blood Group: A+</p>
                    <p>Location: New York</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card p-3 mb-3">
                    <h5>Jane Smith</h5>
                    <p>Blood Group: O-</p>
                    <p>Location: Los Angeles</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card p-3 mb-3">
                    <h5>David Johnson</h5>
                    <p>Blood Group: B+</p>
                    <p>Location: Chicago</p>
                </div>
            </div>
        </div>
    </div>
    
    <footer class="text-center p-3 mt-3" style="background: #0a0a0a;">
        <p>&copy; 2025 Blood Bank Management. All Rights Reserved.</p>
    </footer>

    <script>
        $(document).ready(function() {
            $("#search, #bloodGroup").on("input", function() {
                loadBloodData();
            });
        });

        function loadBloodData() {
            let search = $("#search").val();
            let bloodGroup = $("#bloodGroup").val();
            
            $.ajax({
                url: "fetchBloodData.jsp",
                type: "GET",
                data: { search: search, bloodGroup: bloodGroup },
                success: function(response) {
                    $("#bloodData").html(response);
                }
            });
        }

        function addBlood() {
            window.location.href = "addBlood.jsp";
        }
        
        function requestBlood() {
            window.location.href = "requestBlood.jsp";
        }
    </script>
</body>
</html>