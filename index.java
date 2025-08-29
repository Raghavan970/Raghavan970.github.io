<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>My AI Chatbot</title>
  <style>
    body { font-family: Arial, sans-serif; padding: 20px; background: #f4f4f9; }
    #chatbox { width: 100%; max-width: 500px; height: 400px; border: 1px solid #ccc; padding: 10px; overflow-y: auto; background: white; margin-bottom: 10px; }
    .user { color: blue; margin: 5px 0; }
    .bot { color: green; margin: 5px 0; }
    #inputArea { display: flex; }
    #userInput { flex: 1; padding: 10px; }
    button { padding: 10px; }
  </style>
</head>
<body>
  <h2>💬 Welcome to My AI Chatbot!</h2>
  <div id="chatbox"></div>
  <div id="inputArea">
    <input type="text" id="userInput" placeholder="Type your message..." />
    <button onclick="sendMessage()">Send</button>
  </div>

  <script>
    async function sendMessage() {
      const input = document.getElementById("userInput");
      const message = input.value.trim();
      if (!message) return;

      const chatbox = document.getElementById("chatbox");
      chatbox.innerHTML += <div class="user"><b>You:</b> ${message}</div>;
      input.value = "";

      // Call our backend (serverless function)
      const response = await fetch("https://YOUR_BACKEND_URL/chat", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ message })
      });
      const data = await response.json();

      chatbox.innerHTML += <div class="bot"><b>Bot:</b> ${data.reply}</div>;
      chatbox.scrollTop = chatbox.scrollHeight;
    }
  </script>
</body>
</html>
