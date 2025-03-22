<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Emergency Healthcare System</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/js/all.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gagalin&family=Horizon&display=swap">
    <style>
        body {
            background-color: black;
            color: white;
            font-family: 'Gagalin', sans-serif;
            transition: background 0.5s ease, color 0.5s ease;
        }
        .light-mode {
            background-color: white;
            color: black;
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
            transition: color 0.3s ease-in-out;
        }
        .nav-link:hover {
            color: cyan !important;
        }
        .hero-section {
            text-align: center;
            padding: 100px 20px;
            background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)), url('healthcare.jpg') center/cover;
            animation: fadeIn 1.5s ease-in-out;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }
        .btn-custom {
            background-color: cyan;
            color: black;
            padding: 10px 20px;
            font-size: 18px;
            border-radius: 10px;
            transition: all 0.3s;
        }
        .btn-custom:hover {
            background-color: white;
            color: black;
        }
        .content {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            align-items: center;
            padding: 50px;
            text-align: center;
        }
        .feature-section {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 50px;
        }
        .feature-box {
            background-color: #222;
            padding: 20px;
            border-radius: 10px;
            width: 300px;
            text-align: center;
            transition: transform 0.3s ease-in-out;
        }
        .feature-box:hover {
            transform: scale(1.05);
        }
        .theme-toggle {
            cursor: pointer;
            font-size: 24px;
            margin-left: 20px;
            color: cyan;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="#">SMART EMERGENCY HEALTHCARE SYSTEM</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="Home.jsp">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="Services.jsp">Services</a></li>
                    <li class="nav-item"><a class="nav-link" href="AboutUs.jsp">About Us</a></li>
                    <li class="nav-item"><a class="nav-link" href="ai.jsp">AI Bot</a></li>
                    <li class="nav-item"><a class="nav-link" href="SignIn.jsp">SignIn</a></li>
                    <li class="nav-item"><a class="nav-link" href="SignUp.jsp">SignUp</a></li>
                </ul>
                <span class="theme-toggle" onclick="toggleTheme()">🌙</span>
            </div>
        </div>
    </nav>
    
    <section class="hero-section">
        <div class="container">
            <h1>24/7 Emergency Healthcare at Your Fingertips</h1>
            <p>Fast, reliable, and expert medical assistance when you need it most.</p>
            <a href="#" class="btn btn-custom">Get Started</a>
        </div>
    </section>
    
    <div class="content">
        <div>
            <h1>SMART EMERGENCY <span>HEALTHCARE</span> SYSTEM</h1>
            <p>Revolutionizing emergency response with AI-driven real-time solutions.</p>
            <a href="#" class="btn btn-primary">🚨 Emergency Assistance</a>
        </div>
    </div>
    
    <div class="feature-section">
        <div class="feature-box"><h3 class="feature-title">Patient Identification</h3><p>Rapidly identify patients and access medical history.</p></div>
        <div class="feature-box"><h3 class="feature-title">AI Decision Support</h3><p>Real-time AI-driven treatment recommendations.</p></div>
        <div class="feature-box"><h3 class="feature-title">Hospital Integration</h3><p>Seamless emergency response communication.</p></div>
        <div class="feature-box"><h3 class="feature-title">One-Tap Emergency</h3><p>Instantly call for emergency assistance.</p></div>
        <div class="feature-box"><h3 class="feature-title">Blood Management</h3><p>Real-time blood donation and distribution.</p></div>
        <div class="feature-box"><h3 class="feature-title">AI Medical Chatbot</h3><p>Instant medical guidance for emergency cases.</p></div>
    </div>
    
    <footer class="footer text-center p-3">
        <p>&copy; 2025 Smart Emergency Healthcare System. All Rights Reserved.</p>
    </footer>
    
    <script>
        function toggleTheme() {
            document.body.classList.toggle("light-mode");
            let themeButton = document.querySelector(".theme-toggle");
            if (document.body.classList.contains("light-mode")) {
                themeButton.innerHTML = "☀️";
                localStorage.setItem("theme", "light");
            } else {
                themeButton.innerHTML = "🌙";
                localStorage.setItem("theme", "dark");
            }
        }
        window.onload = function() {
            if (localStorage.getItem("theme") === "light") {
                document.body.classList.add("light-mode");
                document.querySelector(".theme-toggle").innerHTML = "☀️";
            }
        };
    </script>
</body>
</html>