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
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Gagalin&display=swap');
        @import url('https://fonts.googleapis.com/css2?family=Horizon&display=swap');
        
        body {
            background-color: black;
            color: white;
            font-family: 'Gagalin', sans-serif;
        }
        .navbar {
            background-color: #0a0a0a;
        }
        .navbar-brand {
            color: cyan !important;
            font-size: 24px;
            font-weight: bold;
            font-family: 'Horizon', sans-serif;
        }
        .nav-link {
            color: white !important;
            transition: 0.3s;
        }
        .nav-link:hover {
            color: cyan !important;
        }
        .hero-section {
            text-align: center;
            padding: 100px 20px;
            background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)), url('healthcare.jpg') center/cover;
        }
        .hero-section h1 {
            font-size: 50px;
            color: cyan;
            font-weight: bold;
            font-family: 'Horizon', sans-serif;
            animation: fadeIn 2s ease-in-out;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }
        .service-box {
            background: #222;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            transition: transform 0.3s;
        }
        .service-box:hover {
            transform: scale(1.05);
        }
        .service-title {
            color: cyan;
            font-size: 1.5rem;
            font-weight: bold;
        }
        .service-text {
            color: #ddd;
        }
        .service-btn {
            margin-top: 10px;
            background-color: red;
            color: white;
            border: none;
            padding: 8px 15px;
            border-radius: 5px;
            transition: 0.3s;
        }
        .service-btn:hover {
            background-color: cyan;
            color: black;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="#">&#9825; SAVELIFE</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="Home.jsp">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="Services.jsp">Services</a></li>
                    <li class="nav-item"><a class="nav-link" href="Blood.jsp">Blood Bank</a></li>
                    <li class="nav-item"><a class="nav-link" href="ai.jsp">AI</a></li>
                    <li class="nav-item"><a class="btn btn-danger" href="Emergency.jsp">Emergency</a></li>
                	  
                </ul>
            </div>
        </div>
    </nav>

    <section class="hero-section">
        <h1>OUR <span style="color: red;">EMERGENCY HEALTHCARE SERVICES</span></h1>
        <p>Comprehensive AI-powered emergency healthcare solutions designed to save lives.</p>
    </section>

    <div class="container my-5">
        <div class="row g-4">
            <div class="col-md-4">
                <div class="service-box">
                    <h2 class="service-title">Emergency Response</h2>
                    <p class="service-text">One-tap emergency assistance with real-time location sharing.</p>
                    <a href="Emergency.jsp" class="btn service-btn">Take me there</a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="service-box">
                    <h2 class="service-title">AI Medical Assistant</h2>
                    <p class="service-text">Advanced AI algorithms analyze symptoms and history.</p>
                    <a href="ai.jsp" class="btn service-btn">Take me there</a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="service-box">
                    <h2 class="service-title">Blood Donation Network</h2>
                    <p class="service-text">Connecting donors with recipients based on location.</p>
                    <a href="Blood.jsp" class="btn service-btn">Take me there</a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="service-box">
                    <h2 class="service-title">Hospital Locator</h2>
                    <p class="service-text">Find nearest hospitals based on your emergency type.</p>
                    <a href="hospital_locator.jsp" class="btn service-btn">Take me there</a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="service-box">
                    <h2 class="service-title">Medical Records Access</h2>
                    <p class="service-text">Instant access to patient medical history during emergencies.</p>
                    <a href="Patient.jsp" class="btn service-btn">Take me there</a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="service-box">
                    <h2 class="service-title">AI Medical Chatbot</h2>
                    <p class="service-text">24/7 AI chatbot providing medical guidance and first aid.</p>
                    <a href="ai.jsp" class="btn service-btn">Take me there</a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="service-box">
                    <h2 class="service-title">Remote Vital Monitoring</h2>
                    <p class="service-text">Continuous patient monitoring with automatic alerts.</p>
                    <a href="Report.jsp" class="btn service-btn">Take me there</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
