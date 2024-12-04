// // import * as grpcWeb from 'grpc-web';
// import { LanguageServiceClient } from './generated/src/main/proto/LanguageServiceClientPb.ts';  // Klient wygenerowany z .proto
// import { LanguageRequest } from './generated/src/main/proto/language_pb.d.ts';  // Definicje wiadomości

// const clientLang = new LanguageServiceClient('http://localhost:8080', null, null);

// // Funkcja pobierająca języki
// async function fetchLanguages() {
//     const request = new LanguageRequest();
//     clientLang.fetchLanguages(request, {}, (err, response) => {
//         if (err) {
//             showMessage('Blad podczas pobierania jezykow.', 'error', 'languageMessage');
//             return;
//         }
//         const languages = response.getLanguagesList();  // Zakładając, że jest to lista języków
//         displayLanguages(languages);
//     });
// }

// // Funkcja dodająca język
// async function addLanguage() {
//     hideLanguages();
//     const code = document.getElementById('languageCode').value.trim();
//     if (!code) {
//         showMessage("Prosze wprowadzic kod jezyka.", 'error', 'languageMessage');
//         return;
//     }
//     const request = new LanguageRequest();
//     request.setCode(code);

//     clientLang.addLanguage(request, {}, (err, response) => {
//         if (err) {
//             showMessage('Blad podczas dodawania jezyka.', 'error', 'languageMessage');
//             return;
//         }
//         showMessage('Język dodany pomyślnie!', 'success', 'languageMessage');
//         fetchLanguages();
//     });
// }

// // Funkcja usuwająca język
// async function removeLanguage() {
//     hideLanguages();
//     const code = document.getElementById('languageCode').value.trim();
//     if (!code) {
//         showMessage("Prosze wprowadzic kod jezyka.", 'error', 'languageMessage');
//         return;
//     }
//     const request = new LanguageRequest();
//     request.setCode(code);

//     clientLang.removeLanguage(request, {}, (err, response) => {
//         if (err) {
//             showMessage('Blad podczas usuwania jezyka.', 'error', 'languageMessage');
//             return;
//         }
//         showMessage('Język usunięty pomyślnie!', 'success', 'languageMessage');
//         fetchLanguages();
//     });
// }

// // Funkcja czyszcząca wszystkie języki
// async function clearLanguages() {
//     hideLanguages();
//     clientLang.clearLanguages(new Empty(), {}, (err, response) => {
//         if (err) {
//             showMessage('Blad podczas czyszczenia jezykow.', 'error', 'languageMessage');
//             return;
//         }
//         showMessage('Wszystkie języki zostały usunięte.', 'success', 'languageMessage');
//         fetchLanguages();
//     });
// }



// /**
//  * Upload document
//  */
// function uploadDocument() {
//     const fileInput = document.getElementById('documentFile');
//     const languageCode = document.getElementById('documentLanguage').value;
//     const type = document.getElementById('documentType').value;
//     const versionOption = document.getElementById('versionOption').value;

//     if (!fileInput.files[0] || !languageCode || !type) {
//         alert('Wszystkie pola są wymagane!');
//         return;
//     }

//     const reader = new FileReader();
//     reader.onload = function () {
//         const fileContent = reader.result;
//         const request = {
//             languageCode,
//             type,
//             version: versionOption,
//             fileName: fileInput.files[0].name,
//             fileContent: fileContent
//         };

//         client.addDocument(request, (err, response) => {
//             const messageElement = document.getElementById('documentMessage');
//             if (err) {
//                 messageElement.textContent = `Błąd: ${err.message}`;
//             } else {
//                 messageElement.textContent = response.message;
//             }
//         });
//     };

//     reader.readAsArrayBuffer(fileInput.files[0]);
// }

// /**
//  * Fetch all documents
//  */
// function fetchDocuments() {
//     client.getAllDocuments({}, (err, response) => {
//         const docsList = document.getElementById('docs');
//         docsList.innerHTML = '';

//         if (err) {
//             alert(`Błąd: ${err.message}`);
//             return;
//         }

//         response.documents.forEach(doc => {
//             const listItem = document.createElement('li');
//             listItem.textContent = `${doc.languageCode} - ${doc.type} - wersja: ${doc.version.join('.')}`;
//             docsList.appendChild(listItem);
//         });
//     });
// }

// /**
//  * Check outdated documents
//  */
// function checkDocuments() {
//     const type = prompt('Podaj typ dokumentu (opcjonalnie):');

//     const request = type ? { type } : {};
//     client.checkOutdatedDocuments(request, (err, response) => {
//         const docsList = document.getElementById('docs');
//         docsList.innerHTML = '';

//         if (err) {
//             alert(`Błąd: ${err.message}`);
//             return;
//         }

//         response.outdatedDocuments.forEach(doc => {
//             const listItem = document.createElement('li');
//             listItem.textContent = `${doc.languageCode} - ${doc.type} - wersja: ${doc.version.join('.')}`;
//             docsList.appendChild(listItem);
//         });
//     });
// }

// function hideLanguages() {
//     document.getElementById('languages').innerHTML = '';
// }

// function clearInput(type) {
//     const input = document.getElementById(`${type}`);
//     input.value = '';
// }
// function showMessage(message, type, elementId) {
//     const messageElement = document.getElementById(elementId);
//     messageElement.textContent = message;
//     messageElement.className = type;
// }

