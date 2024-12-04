const serverUrl = 'http://localhost:8080';
// // const serverUrl = 'http://localhost:8083'

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
        // console.log(response);
        const message = await response.text();
        // console.log(message);
        if (!response.ok) throw new Error(message);
        showMessage(message, 'success', 'languageMessage');
        await populateLanguageSelect();
    } catch (error) {
        showMessage(error.message, 'error', 'languageMessage');
    } finally {
        clearInput('languageCode'); 
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
        await populateLanguageSelect();
    } catch (error) {
        showMessage(error.message, 'error', 'languageMessage');
    } finally {
        clearInput('languageCode'); 
    }
}

async function clearLanguages() {
    hideLanguages();
    try {
        const response = await fetch(`${serverUrl}/api/languages/clear`, { method: 'DELETE' });
        const message = await response.text();
        if (!response.ok) throw new Error(message);
        showMessage(message, 'success', 'languageMessage');
        await populateLanguageSelect();
    } catch (error) {
        showMessage(error.message, 'error', 'languageMessage');
    } finally {
        clearInput('languageCode'); 
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

function clearInput(type) {
    const input = document.getElementById(`${type}`);
    input.value = '';
}
function showMessage(message, type, elementId) {
    const messageElement = document.getElementById(elementId);
    messageElement.textContent = message;
    messageElement.className = type;
}

function clearFileInput() {
    const fileInput = document.getElementById('documentFile');
    fileInput.value = '';
}


document.addEventListener('DOMContentLoaded', populateLanguageSelect);

// Funkcje zarzadzania dokumentami
async function populateLanguageSelect() {
    const languageSelect = document.getElementById('documentLanguage');
    try {
        const response = await fetch(`${serverUrl}/api/languages`);
        if (!response.ok) throw new Error("Blad podczas pobierania listy jezykow.");
        const languages = await response.json();
        languageSelect.innerHTML = '<option value="">Wybierz jezyk</option>';
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
    const versionOption  = document.getElementById('versionOption').value;

    const documentsList = document.getElementById('documents');
    documentsList.innerHTML = '';

    if (!fileInput.files.length || !languageCode || !documentType) {
        showMessage("Prosze wypelnic wszystkie pola.", 'error', 'documentMessage');
        return;
    }

    const formData = new FormData();
    formData.append("file", fileInput.files[0]);
    formData.append("languageCode", languageCode);
    formData.append("type", documentType);
    formData.append("version", versionOption);

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
    } finally {
        clearFileInput(); 
        clearInput('documentType');
        resetLanguageSelection();
    }
}

function resetLanguageSelection() {
    const languageSelect = document.getElementById('documentLanguage');
    languageSelect.value = '';
}

function displayDocuments(documents) {
    const documentsList = document.getElementById('documents');
    documentsList.innerHTML = '';
    if (documents.length === 0) {
        documentsList.innerHTML = '<li>Brak dostepnych dokumentow.</li>';
        return;
    }
    
    documents.forEach(doc => {
        const li = document.createElement('li');
        li.className = 'document-item';
        // console.log(doc);
        const documentUrl = doc.filePath;
        // console.log("documnetUrl: ", doc.JSON);
        li.innerHTML = `
            <strong>Typ:</strong> ${doc.type}, 
            <strong>Jezyk:</strong> ${doc.languageCode.toUpperCase()}, 
            <strong>Wersja:</strong> ${doc.version[0]}.${doc.version[1]}.${doc.version[2]}
            <button onclick="viewDocument('${documentUrl}')">Otworz</button>
        `;
        documentsList.appendChild(li);
    });
}


function viewDocument(doc) {
    // console.log(doc);
    const documentUrl = doc;  
    // console.log("Otwieram dokument z URL: ", documentUrl);

    if (documentUrl && documentUrl !== 'null') {
        window.open(documentUrl, '_blank');
    } else {
        alert('Blad: Nieprawidlowy adres URL dokumentu.');
    }
}

async function fetchDocuments() {
    try {
        const typeInput = document.getElementById('documentType').value.trim();
        const queryParam = typeInput ? `?type=${encodeURIComponent(typeInput)}` : '';
        const response = await fetch(`${serverUrl}/api/documents${queryParam}`);
        if (!response.ok) throw new Error("blad podczas pobierania dokumentow.");
        const documents = await response.json();
        // console.log(documents);
        showMessage(documents.length === 0 ? "Brak dokumentow." : "Dostepne dokumenty:", 'success', 'documentMessage');
        displayDocuments(documents);
    const documentsList = document.getElementById('documents');
    documentsList.innerHTML = '';
    if (documents.length === 0) {
        documentsList.innerHTML = '<li>Brak dostepnych dokumentow.</li>';
        return;
    }

    documents.forEach(doc => {
        const li = document.createElement('li');
        li.className = 'document-item';

        const documentUrl = doc.filePath;
        li.innerHTML = `
            <strong>Typ:</strong> ${doc.type}, 
            <strong>Jezyk:</strong> ${doc.languageCode.toUpperCase()}, 
            <strong>Wersja:</strong> ${doc.version[0]}.${doc.version[1]}.${doc.version[2]}
            <button onclick="viewDocument('${documentUrl}')">Otworz</button>
        `;
        documentsList.appendChild(li);
    });
    }catch (error) {
        showMessage(error.message, 'error', 'languageMessage');
    }
}

async function checkDocuments() {
    try {
        const typeInput = document.getElementById('documentType').value.trim();
        const queryParam = typeInput ? `?type=${encodeURIComponent(typeInput)}` : '';
        const response = await fetch(`${serverUrl}/api/documents/check${queryParam}`);
        const outdatedDocuments = await response.json();
        showMessage(outdatedDocuments.length === 0 ? "Wszystkie dokumenty sa aktualne." : "Nieaktualne dokumenty:", 'success', 'documentMessage');
        const documentsList = document.getElementById('documents');
        documentsList.innerHTML = '';
        if (outdatedDocuments.length > 0) {
            // console.log(outdatedDocuments);
            displayDocuments(outdatedDocuments); 
        }
    } catch (error) {
        showMessage(error.message, 'error', 'documentMessage');
    }
}