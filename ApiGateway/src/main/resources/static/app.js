const BASE_URL = "http://localhost:8060";

function setText(id, text, className = "") {
    const el = document.getElementById(id);
    el.className = className ? `result-box ${className}` : "result-box";
    el.innerText = text;
}

function appendMessage(text, type) {
    const chatMessages = document.getElementById("chatMessages");
    const msg = document.createElement("div");
    msg.className = `msg ${type === "user" ? "user-msg" : "bot-msg"}`;
    msg.innerText = text;
    chatMessages.appendChild(msg);
    chatMessages.scrollTop = chatMessages.scrollHeight;
}

async function createUser() {
    const data = {
        name: document.getElementById("name").value.trim(),
        email: document.getElementById("email").value.trim(),
        password: document.getElementById("password").value.trim(),
        pinCode: document.getElementById("pinCode").value.trim(),
        username: document.getElementById("username").value.trim()
    };

    if (!data.name || !data.email || !data.password || !data.pinCode || !data.username) {
        setText("userResult", "Bütün xanaları doldur.", "error-text");
        return;
    }

    try {
        const res = await fetch(`${BASE_URL}/api/users/register`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        const text = await res.text();

        if (!res.ok) {
            setText("userResult", `Create error: ${text}`, "error-text");
            return;
        }

        setText("userResult", "User created ✅", "success-text");

        document.getElementById("name").value = "";
        document.getElementById("email").value = "";
        document.getElementById("password").value = "";
        document.getElementById("pinCode").value = "";
        document.getElementById("username").value = "";
    } catch (err) {
        setText("userResult", `Connection error: ${err.message}`, "error-text");
        console.error("CREATE USER ERROR:", err);
    }
}

async function loadRates() {
    const result = document.getElementById("currencyResult");
    result.innerText = "Yüklənir...";

    try {
        const res = await fetch(`${BASE_URL}/api/currency/rates`);
        const text = await res.text();

        if (!res.ok) {
            result.innerText = `Currency error: ${text}`;
            return;
        }

        try {
            const data = JSON.parse(text);
            result.innerText = JSON.stringify(data, null, 2);
        } catch {
            result.innerText = text;
        }
    } catch (err) {
        result.innerText = `Connection error: ${err.message}`;
        console.error("CURRENCY ERROR:", err);
    }
}

async function sendMessage() {
    const input = document.getElementById("aiInput");
    const message = input.value.trim();

    if (!message) {
        return;
    }

    appendMessage(message, "user");
    input.value = "";

    try {
        const res = await fetch(`${BASE_URL}/api/ai/chat`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ message })
        });

        const text = await res.text();

        if (!res.ok) {
            appendMessage(`AI error: ${text}`, "bot");
            return;
        }

        try {
            const data = JSON.parse(text);
            appendMessage(data.response || "Cavab boş gəldi.", "bot");
        } catch {
            appendMessage(text, "bot");
        }
    } catch (err) {
        appendMessage(`Connection error: ${err.message}`, "bot");
        console.error("AI CHAT ERROR:", err);
    }
}

document.getElementById("aiInput").addEventListener("keydown", function (e) {
    if (e.key === "Enter") {
        sendMessage();
    }
});