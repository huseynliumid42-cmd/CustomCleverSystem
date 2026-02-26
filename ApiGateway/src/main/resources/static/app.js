async function loadCustomsData() {
    const listElement = document.getElementById('customs-list');
    listElement.innerHTML = "Yüklənir...";

    try {
        
        const response = await fetch('/api/customs/all');
        const data = await response.json();

        listElement.innerHTML = ""; 

        data.forEach(item => {
            const li = document.createElement('li');
            li.textContent = `Bəyannamə: ${item.id} - Status: ${item.status}`;
            listElement.appendChild(li);
        });
    } catch (error) {
        console.error("Xəta baş verdi:", error);
        listElement.innerHTML = "Məlumat alınarkən xəta baş verdi.";
    }
}