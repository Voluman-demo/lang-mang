const serverUrl = 'http://localhost:8080';
// const serverUrl = 'http://localhost:8083'


async function RpcCallGet(method, params = {}) {
    try {
        const queryString = new URLSearchParams({ method, ...params }).toString();
        const response = await fetch(`${serverUrl}/api/rpc?${queryString}`);
        if (response.ok || response.status === 400) {
            const contentType = response.headers.get('Content-Type');
            if (contentType && contentType.includes('application/json')) {
                return await response.json(); 
            } else {
                return await response.text(); 
            }
        } else {
            throw new Error(response.body);
        }

    } catch (error) {
        throw new Error(`Blad podczas wykonywania RPC GET: ${error.message}`);
    }
}

async function RpcCallPost(method, params = {}) {
    try {
        console.log(params);
        let formData;
        
        
        if (params instanceof FormData) {
            formData = params;
        } else {
            formData = new FormData();
            Object.keys(params).forEach(key => formData.append(key, params[key]));
        }
        formData.append("method", method);

        for (const [key, value] of formData.entries()) {
            console.log(key, value);
        }

        const response = await fetch(`${serverUrl}/api/rpc`, {
            method: 'POST',
            body: formData
        });
        const contentType = response.headers.get("Content-Type");
        if (contentType && contentType.includes('application/json')) {
            return await response.json(); 
        } else {
            return await response.text(); 
        }
    } catch (error) {
        throw new Error(`Blad podczas wykonywania RPC POST: ${error.message}`);
    }
}


async function fetchLanguages() {
    try {
        hideLanguages();
        const data = await RpcCallGet('getAllLanguages');
        displayLanguages(data);

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
        const data = await RpcCallGet('addLanguage', { code });
        const message = await data;
        if(data.status == 200){
            showMessage(message, 'success', 'languageMessage');
        } 
        else{
            showMessage(message, 'error', 'languageMessage');
        }
        await populateLanguageSelect();
    } catch (error) {
        console.log(error);
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
        const data = await RpcCallGet('removeLanguage', { code });
        const message = await data;
        if(data.status == 200){
            showMessage(message, 'success', 'languageMessage');
        } 
        else{
            showMessage(message, 'error', 'languageMessage');
        }

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
        const data = await RpcCallGet('clearLanguages');
        const message = await data;
        if(data.status == 200){
            showMessage(message, 'success', 'languageMessage');
        } 
        else{
            showMessage(message, 'error', 'languageMessage');
        }
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
    document.getElementById('languageMessage').innerHTML = '';
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

document.addEventListener('DOMContentLoaded', populateLanguageSelect);


async function populateLanguageSelect() {
    const languageSelect = document.getElementById('documentLanguage');
    try {
        const data = await RpcCallGet('getAllLanguages');
        const languages = await data;
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

    if (!fileInput.files.length || !languageCode || !documentType) {
        showMessage("Prosze wypelnic wszystkie pola.", 'error', 'documentMessage');
        return;
    }

    const formData = new FormData();
    formData.append("documentFile", fileInput.files[0]);
    formData.append("documentLanguage", languageCode);
    formData.append("documentType", documentType);
    formData.append("versionOption", versionOption);

    

    try {
        const message = await RpcCallPost('addDocument', formData);
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

async function checkDocuments() {
    try {
        const typeInput = document.getElementById('documentType').value.trim();
        const params = typeInput ? { type: typeInput } : {};
        const outdatedDocuments = await RpcCallGet('getOutdatedDocuments', params);
        showMessage(outdatedDocuments.length === 0 ? "Wszystkie dokumenty sa aktualne." : "Nieaktualne dokumenty:", 'success', 'documentMessage');
        const documentsList = document.getElementById('documents');
        documentsList.innerHTML = '';
        if (outdatedDocuments.length > 0) {
            displayDocuments(outdatedDocuments); 
        }
    } catch (error) {
        showMessage(error.message, 'error', 'documentMessage');
    }
}

async function fetchDocuments() {
    try {
        const typeInput = document.getElementById('documentType').value.trim();
        const params = typeInput ? { type: typeInput } : {};
        const documents = await RpcCallGet('getAllDocuments', params);
        console.log(documents);
        displayDocuments(documents);
    } catch (error) {
        showMessage(error.message, 'error', 'documentMessage');
    }
}

function displayDocuments(documents) {
    const documentsList = document.getElementById('documents');
    documentsList.innerHTML = '';
    if (!Array.isArray(documents) || documents.length === 0) {
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
            <button onclick="viewDocument('${documentUrl}')">Otwórz</button>
        `;
        documentsList.appendChild(li);
    });
}

function viewDocument(doc) {
    const documentUrl = doc; 

    if (documentUrl && documentUrl !== 'null') {
        window.open(documentUrl, '_blank');
    } else {
        alert('Blad: Nieprawidlowy adres URL dokumentu.');
    }
}

function clearFileInput() {
    const fileInput = document.getElementById('documentFile');
    fileInput.value = '';
}