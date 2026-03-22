async function checkStatus() {
    try {
        const res = await fetch("http://localhost:8060/api/ai/status");
        const data = await res.text();

        document.getElementById("status").innerText = "🟢 " + data + " (via Gateway)";
    } catch (e) {
        document.getElementById("status").innerText = "🔴 Service unavailable";
    }
}

async function send() {
    const input = document.getElementById("message");
    const chatBox = document.getElementById("chat-box");

    const message = input.value.trim();
    if (!message) return;

    addMessage(message, "user");
    input.value = "";

    // loading göstər
    const loading = addMessage("...", "bot");

    try {
        const res = await fetch("http://localhost:8060/api/ai/chat", {
            method: "POST",
            headers: {
                "Content-Type": "text/plain"
            },
            body: message
        });

        const data = await res.text();

        loading.remove();
        addMessage(data, "bot");

    } catch (e) {
        loading.remove();
        addMessage("❌ Server error", "bot");
    }
}

function addMessage(text, type) {
    const chatBox = document.getElementById("chat-box");

    const div = document.createElement("div");
    div.classList.add("message", type);
    div.innerText = text;

    chatBox.appendChild(div);
    chatBox.scrollTop = chatBox.scrollHeight;

    return div;
}

window.onload = checkStatus;