//package com.example.demo.Document;
//
//import com.example.grpc.DocumentProto;
//import com.example.grpc.DocumentServiceGrpc;
//import com.google.protobuf.ByteString;
//import com.google.protobuf.Empty;
//import io.grpc.Status;
//import io.grpc.stub.StreamObserver;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//import java.net.URL;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class DocumentServiceGrpcImpl extends DocumentServiceGrpc.DocumentServiceImplBase {
//
//    private final DocumentService documentService;
//
//    public DocumentServiceGrpcImpl(DocumentService documentService) {
//        this.documentService = documentService;
//    }
//
//    @Override
//    public void addDocument(DocumentProto.DocumentAddRequest request, StreamObserver<DocumentProto.DocumentResponse> responseObserver) {
//        try {
//            String fileName = request.getFileName();
//            byte[] fileContent = request.getFileContent().toByteArray();
//            InputStream fileStream = new ByteArrayInputStream(fileContent);
//
//            documentService.addDocument(
//                    request.getLanguageCode(),
//                    request.getType(),
//                    VersionChangeRequest.valueOf(request.getVersion()),
//                    fileName,
//                    fileStream
//            );
//
//            DocumentProto.DocumentResponse response = DocumentProto.DocumentResponse.newBuilder()
//                    .setMessage("Dokument został dodany")
//                    .build();
//            responseObserver.onNext(response);
//            responseObserver.onCompleted();
//        } catch (Exception e) {
//            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
//        }
//    }
//
//    @Override
//    public void getAllDocuments(Empty request, StreamObserver<DocumentProto.GetDocumentsResponse> responseObserver) {
//        List<DocumentProto.Document> documents = documentService.getAllDocuments().stream()
//                .map(doc -> DocumentProto.Document.newBuilder()
//                        .setLanguageCode(doc.getLanguageCode())
//                        .setType(doc.getType())
//                        .addAllVersion(doc.getVersion())
//                        .setFilePath(doc.getFilePath())
//                        .build())
//                .collect(Collectors.toList());
//
//        DocumentProto.GetDocumentsResponse response = DocumentProto.GetDocumentsResponse.newBuilder()
//                .addAllDocuments(documents)
//                .build();
//
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void downloadFile(DocumentProto.DownloadFileRequest request, StreamObserver<DocumentProto.DownloadFileResponse> responseObserver) {
//        try {
//            String filename = request.getFilename();
//            String fileUrl = documentService.getAllDocuments().stream()
//                    .filter(doc -> doc.getFilePath().contains(filename))
//                    .map(Doc::getFilePath)
//                    .findFirst()
//                    .orElseThrow(() -> new FileNotFoundException("Plik nie znaleziony: " + filename));
//
//            // Pobranie zawartości pliku
//            URL url = new URL(fileUrl);
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            try (InputStream inputStream = url.openStream()) {
//                byte[] buffer = new byte[8192];
//                int bytesRead;
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    outputStream.write(buffer, 0, bytesRead);
//                }
//            }
//
//            DocumentProto.DownloadFileResponse response = DocumentProto.DownloadFileResponse.newBuilder()
//                    .setFileContent(ByteString.copyFrom(outputStream.toByteArray()))
//                    .build();
//
//            responseObserver.onNext(response);
//            responseObserver.onCompleted();
//        } catch (Exception e) {
//            responseObserver.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
//        }
//    }
//
//    @Override
//    public void checkOutdatedDocuments(DocumentProto.CheckOutdatedDocumentsRequest request, StreamObserver<DocumentProto.CheckOutdatedDocumentsResponse> responseObserver) {
//        try {
//            String type = request.getType();
//            Set<Doc> documents = (type != null && !type.isEmpty())
//                    ? documentService.getAllDocumentsByType(type)
//                    : documentService.getAllDocuments();
//
//            List<Doc> outdatedDocuments = documentService.getOutdatedDocuments(documents);
//
//            List<DocumentProto.Document> responseDocuments = outdatedDocuments.stream()
//                    .map(doc -> DocumentProto.Document.newBuilder()
//                            .setLanguageCode(doc.getLanguageCode())
//                            .setType(doc.getType())
//                            .addAllVersion(doc.getVersion())
//                            .setFilePath(doc.getFilePath())
//                            .build())
//                    .collect(Collectors.toList());
//
//            DocumentProto.CheckOutdatedDocumentsResponse response = DocumentProto.CheckOutdatedDocumentsResponse.newBuilder()
//                    .addAllOutdatedDocuments(responseDocuments)
//                    .build();
//
//            responseObserver.onNext(response);
//            responseObserver.onCompleted();
//        } catch (Exception e) {
//            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
//        }
//    }
//}