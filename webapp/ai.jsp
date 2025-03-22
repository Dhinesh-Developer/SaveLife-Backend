<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AI Healthcare Chatbot</title>
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
        .chat-container {
            max-width: 600px;
            margin: 50px auto;
            background: #222;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px cyan;
        }
        .chat-box {
            height: 300px;
            overflow-y: auto;
            padding: 10px;
            border: 1px solid cyan;
            border-radius: 10px;
            background: black;
        }
        .chat-message {
            margin: 10px 0;
            padding: 10px;
            border-radius: 10px;
            max-width: 80%;
        }
        .bot-message {
            background: cyan;
            color: black;
            align-self: flex-start;
        }
        .user-message {
            background: white;
            color: black;
            align-self: flex-end;
            text-align: right;
        }
        .input-group input {
            background: black;
            color: white;
            border: 1px solid cyan;
        }
        .btn-custom {
            background-color: cyan;
            color: black;
            padding: 10px 20px;
            border-radius: 10px;
            transition: 0.3s;
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
            <a class="navbar-brand" href="#">AI Healthcare Chatbot</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Services</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Chatbot</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <section class="hero-section">
        <div class="container">
            <h1>24/7 AI Healthcare Assistance</h1>
            <p>Get real-time medical advice from our AI-powered chatbot.</p>
            <a href="#chatbox" class="btn btn-custom">Start Chat</a>
        </div>
    </section>

    <div class="chat-container">
        <h3 class="text-center text-cyan">Healthcare Chatbot</h3>
        <div class="chat-box" id="chatbox">
            <div class="chat-message bot-message">Hello! I am your AI Healthcare Assistant. How can I help you?</div>
        </div>
        <div class="input-group mt-3">
            <input type="text" id="userInput" class="form-control" placeholder="Type a message..." onkeypress="handleKeyPress(event)">
            <button class="btn btn-custom" onclick="sendMessage()">Send</button>
        </div>
    </div>

    <script>
        function sendMessage() {
            var inputField = document.getElementById("userInput");
            var userMessage = inputField.value.trim();
            if (userMessage === "") return;

            var chatbox = document.getElementById("chatbox");

            // User message
            var userMessageDiv = document.createElement("div");
            userMessageDiv.classList.add("chat-message", "user-message");
            userMessageDiv.innerHTML = userMessage;
            chatbox.appendChild(userMessageDiv);

            // Bot Response
            setTimeout(function () {
                var botMessageDiv = document.createElement("div");
                botMessageDiv.classList.add("chat-message", "bot-message");
                botMessageDiv.innerHTML = getBotResponse(userMessage);
                chatbox.appendChild(botMessageDiv);

                chatbox.scrollTop = chatbox.scrollHeight;
            }, 1000);

            inputField.value = "";
        }

        function handleKeyPress(event) {
            if (event.key === "Enter") {
                sendMessage();
            }
        }

        function getBotResponse(input) {
            input = input.toLowerCase();
            if (input.includes("fever")) return "If you have a fever, stay hydrated and take rest. If symptoms persist, consult a doctor.";
            if (input.includes("headache")) return "Try drinking water, resting, or taking a pain reliever like paracetamol.";
            if (input.includes("covid")) return "COVID-19 symptoms include fever, cough, and difficulty breathing. Please isolate and get tested.";
            if (input.includes("emergency")) return "Call 911 immediately for urgent medical help.";
            return "I'm not sure about that. Please contact a medical professional.";
        }
    </script>

    <footer class="footer">
        <center><p>&copy; 2025 AI Healthcare Chatbot. All Rights Reserved.</p></center>
    </footer>

</body>
</html>
