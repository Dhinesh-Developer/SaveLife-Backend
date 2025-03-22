<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
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
            margin-top: 50px;
            text-align: center;
        }
        .about-section {
            padding: 50px 20px;
            background: #222;
            border-radius: 10px;
            box-shadow: 0px 0px 10px cyan;
        }
        h1 {
            color: cyan;
            font-weight: bold;
        }
        p {
            font-size: 18px;
            line-height: 1.6;
        }
        .btn-custom {
            background-color: cyan;
            color: black;
            padding: 10px 20px;
            font-size: 18px;
            border-radius: 5px;
            text-decoration: none;
        }
        .btn-custom:hover {
            background-color: white;
            color: black;
        }
        footer {
            margin-top: 20px;
            text-align: center;
            padding: 10px;
            background: #0a0a0a;
        }
    </style>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="#">SEHS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Patients</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Hospitals</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="about-section">
            <h1>About Us</h1>
            <p>Welcome to <strong>AI Healthcare</strong>, your trusted healthcare companion. Our mission is to provide 
               seamless healthcare management by connecting patients with top hospitals and offering instant access 
               to medical services.</p>
            <p>We leverage cutting-edge technology to ensure efficient healthcare solutions, bridging the gap 
               between patients and healthcare providers. Our AI-driven system helps in managing medical records, 
               finding the best healthcare facilities, and ensuring timely medical attention.</p>
            <a href="#" class="btn-custom">Learn More</a>
        </div>
    </div>

    <footer>
        <p>&copy; 2025 AI Healthcare Chatbot. All Rights Reserved.</p>
    </footer>

</body>
</html>
