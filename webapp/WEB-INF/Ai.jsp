<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Emergency Chatbot</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            background-color: #f1f8fc;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .chat-container {
            width: 400px;
            height: 600px;
            display: flex;
            flex-direction: column;
            background: white;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.3);
            border-radius: 10px;
        }

        .chat-header {
            background: #009ee3;
            color: white;
            padding: 15px;
            text-align: center;
            font-size: 22px;
            font-weight: bold;
            border-radius: 10px 10px 0 0;
        }

        .chat-box {
            flex: 1;
            overflow-y: auto;
            padding: 20px;
            background: #f8f9fa;
            display: flex;
            flex-direction: column;
        }

        .chat-message {
            padding: 12px;
            margin: 8px;
            border-radius: 10px;
            max-width: 70%;
            font-size: 16px;
            line-height: 1.5;
            animation: fadeIn 0.5s ease-in-out;
        }

        .bot {
            background-color: #009ee3;
            color: white;
            align-self: flex-start;
        }

        .user {
            background-color: #e3e3e3;
            color: black;
            align-self: flex-end;
        }

        .chat-input {
            display: flex;
            padding: 15px;
            background: white;
            border-top: 1px solid #ccc;
        }

        .chat-input input {
            flex: 1;
            padding: 10px;
            border: 2px solid #ccc;
            border-radius: 8px;
            outline: none;
            font-size: 16px;
        }

        .chat-input button {
            background: #009ee3;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 8px;
            margin-left: 10px;
            cursor: pointer;
            font-size: 16px;
            transition: 0.3s;
        }

        .chat-input button:hover {
            background: #007bb3;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(5px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>
    <div class="chat-container">
        <div class="chat-header">SAVELIFE Emergency Chatbot</div>
        <div class="chat-box" id="chat-box">
            <div class="chat-message bot">
                <p>👋 Hello! How can I assist you in an emergency?</p>
            </div>
        </div>
        <div class="chat-input">
            <input type="text" id="user-input" placeholder="Type your message..." />
            <button onclick="sendMessage()">Send</button>
        </div>
    </div>

    <script>
        function sendMessage() {
            var userInput = document.getElementById("user-input").value.trim();
            if (userInput === "") return;

            var chatBox = document.getElementById("chat-box");
            var userMessage = document.createElement("div");
            userMessage.classList.add("chat-message", "user");
            userMessage.innerHTML = "<p>" + userInput + "</p>";
            chatBox.appendChild(userMessage);
            chatBox.scrollTop = chatBox.scrollHeight;

            setTimeout(function () {
                var botReply = document.createElement("div");
                botReply.classList.add("chat-message", "bot");
                var responseText = getBotResponse(userInput);
                botReply.innerHTML = "<p>" + responseText + "</p>";
                chatBox.appendChild(botReply);
                chatBox.scrollTop = chatBox.scrollHeight;
            }, 1000);

            document.getElementById("user-input").value = "";
        }

        function getBotResponse(input) {
            var responses = {
                "help": "Stay calm. What is your emergency?",
                "fire": "Call 101 immediately! Stay away from fire hazards.",
                "police": "Call 100 for police assistance.",
                "ambulance": "Call 102 for emergency medical services.",
                "accident": "Ensure safety, call emergency services, and provide first aid if trained."
            };

            return responses[input.toLowerCase()] || "I am here to help. Please provide more details.";
        }
    </script>
</body>
</html>
