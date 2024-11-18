const serverUrl = 'http://localhost:8080';
// const serverUrl = 'http://localhost:8083'

// Funkcje zarzadzania jezykami
async function fetchLanguages() {
    try {
        const response = await fetch(`${serverUrl}/api/languages`);
        if (!response.ok) throw new Error("Blad podczas pobierania jezykow.");
        const languages = await response.json();
        displayLanguages(languages);
    } catch (error) {
        showMessage(error.message, 'error', 'languageMessage');
    }
}

async function addLanguage() {
    hideLanguages();
    const code = document.getElementById('languageCode').value.trim();
    if (!code) {
        showMessage("Prosze wprowadzic kod jezyka.", 'error', 'languageMessage');
        return;
    }
    try {
        const response = await fetch(`${serverUrl}/api/languages`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ code })
        });
        const message = await response.text();
        if (!response.ok) throw new Error(message);
        showMessage(message, 'success', 'languageMessage');
    } catch (error) {
        showMessage(error.message, 'error', 'languageMessage');
    }
}

async function removeLanguage() {
    hideLanguages();
    const code = document.getElementById('languageCode').value.trim();
    if (!code) {
        showMessage("Prosze wprowadzic kod jezyka.", 'error', 'languageMessage');
        return;
    }
    try {
        const response = await fetch(`${serverUrl}/api/languages/${code}`, { method: 'DELETE' });
        const message = await response.text();
        if (!response.ok) throw new Error(message);
        showMessage(message, 'success', 'languageMessage');
    } catch (error) {
        showMessage(error.message, 'error', 'languageMessage');
    }
}

async function clearLanguages() {
    hideLanguages();
    try {
        const response = await fetch(`${serverUrl}/api/languages/clear`, { method: 'DELETE' });
        const message = await response.text();
        if (!response.ok) throw new Error(message);
        showMessage(message, 'success', 'languageMessage');
    } catch (error) {
        showMessage(error.message, 'error', 'languageMessage');
    }
}

function displayLanguages(languages) {
    const languagesList = document.getElementById('languages');
    languagesList.innerHTML = '';
    if (languages.length === 0) {
        languagesList.innerHTML = '<li>Brak dostepnych jezykow.</li>';
        return;
    }
    languages.forEach(lang => {
        const li = document.createElement('li');
        li.className = 'language-item';
        li.textContent = `Kod jezyka: ${lang.code}`;
        languagesList.appendChild(li);
    });
}

function hideLanguages() {
    document.getElementById('languages').innerHTML = '';
}

function showMessage(message, type, elementId) {
    const messageElement = document.getElementById(elementId);
    messageElement.textContent = message;
    messageElement.className = type;
}

document.addEventListener('DOMContentLoaded', populateLanguageSelect);

// Funkcje zarzadzania dokumentami
async function populateLanguageSelect() {
    const languageSelect = document.getElementById('documentLanguage');
    try {
        const response = await fetch(`${serverUrl}/api/languages`);
        if (!response.ok) throw new Error("Błąd podczas pobierania listy języków.");
        const languages = await response.json();
        languageSelect.innerHTML = '<option value="">Wybierz język</option>';
        languages.forEach(lang => {
            const option = document.createElement('option');
            option.value = lang.code;
            option.textContent = lang.code.toUpperCase();
            languageSelect.appendChild(option);
        });
    } catch (error) {
        showMessage(error.message, 'error', 'languageMessage');
    }
}



async function uploadDocument() {
    const fileInput = document.getElementById('documentFile');
    const languageCode = document.getElementById('documentLanguage').value;
    const documentType = document.getElementById('documentType').value.trim();

    if (!fileInput.files.length || !languageCode || !documentType) {
        showMessage("Prosze wypelnic wszystkie pola.", 'error', 'documentMessage');
        return;
    }

    const formData = new FormData();
    formData.append("file", fileInput.files[0]);
    formData.append("languageCode", languageCode);
    formData.append("type", documentType);

    try {
        const response = await fetch(`${serverUrl}/api/documents`, {
            method: 'POST',
            body: formData
        });
        const message = await response.text();
        if (!response.ok) throw new Error(message);
        showMessage(message, 'success', 'documentMessage');
    } catch (error) {
        showMessage(error.message, 'error', 'documentMessage');
    }
}

async function checkDocuments() {
    try {
        const response = await fetch(`${serverUrl}/api/documents`);
        const outdatedDocuments = await response.json();
        showMessage(outdatedDocuments.length === 0 ? "Wszystkie dokumenty sa aktualne." : "Nieaktualne dokumenty:", 'success', 'documentMessage');
        fetchDocuments();
    } catch (error) {
        showMessage(error.message, 'error', 'documentMessage');
    }
}

// function displayDocuments(documents) {
//     const documentsList = document.getElementById('documents');
//     documentsList.innerHTML = '';
//     if (documents.length === 0) {
//         documentsList.innerHTML = '<li>Brak dostępnych dokumentów.</li>';
//         return;
//     }

//     documents.forEach(doc => {
//         const li = document.createElement('li');
//         li.className = 'document-item';
//         console.log(doc);

//         const documentUrl = doc.url;
//         console.log("documnetUrl: ", doc.JSON);

//         li.innerHTML = `
//             <strong>Typ:</strong> ${doc.type}, 
//             <strong>Język:</strong> ${doc.languageCode.toUpperCase()}, 
//             <strong>Wersja:</strong> ${doc.version}
//             <button onclick="viewDocument('${documentUrl}')">Otwórz</button>
//         `;
//         documentsList.appendChild(li);
//     });
// }
async function fetchDocuments() {
    try {
        const response = await fetch(`${serverUrl}/api/documents`);
        if (!response.ok) throw new Error("Błąd podczas pobierania dokumentów.");
        const documents = await response.json();
        console.log(documents);
        displayDocuments(documents);
    } catch (error) {
        showMessage(error.message, 'error', 'documentMessage');
    }
}

function displayDocuments(documents) {
    const documentsList = document.getElementById('documents');
    documentsList.innerHTML = '';
    if (documents.length === 0) {
        documentsList.innerHTML = '<li>Brak dostępnych dokumentów.</li>';
        return;
    }

    documents.forEach(doc => {
        const li = document.createElement('li');
        li.className = 'document-item';
        console.log("XD",doc);

        const documentUrl = doc.filePath;
        console.log("documnetUrl: ", doc.filePath);

        li.innerHTML = `
            <strong>Typ:</strong> ${doc.type}, 
            <strong>Język:</strong> ${doc.languageCode.toUpperCase()}, 
            <strong>Wersja:</strong> ${doc.version}
            <button onclick="viewDocument('${documentUrl}')">Otwórz</button>
        `;
        documentsList.appendChild(li);
    });
}

function viewDocument(doc) {
    console.log(doc);
    // Upewnij się, że doc zawiera właściwy URL pliku
    const documentUrl = doc;  // Zmieniamy na doc.filePath, bo to tam znajduje się URL
    console.log("Otwieram dokument z URL: ", documentUrl);

    // Otwieramy dokument w nowej karcie
    if (documentUrl && documentUrl !== 'null') {
        window.open(documentUrl, '_blank');
    } else {
        alert('Błąd: Nieprawidłowy adres URL dokumentu.');
    }
}