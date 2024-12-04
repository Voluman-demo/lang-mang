//package com.example.demo.LangMang;
//
//import com.example.grpc.LanguageServiceGrpc;
//import io.grpc.stub.StreamObserver;
//import net.devh.boot.grpc.server.service.GrpcService;
//import static com.example.grpc.LanguageProto.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@GrpcService
//public class LanguageServiceGrpcImpl extends LanguageServiceGrpc.LanguageServiceImplBase {
//
//    private final LangMangService langMangService;
//
//    public LanguageServiceGrpcImpl(LangMangService langMangService) {
//        this.langMangService = langMangService;
//    }
//
//    @Override
//    public void getAllLanguages(Empty request, StreamObserver<LanguageList> responseObserver) {
//        List<Language> languages = langMangService.getAllLanguages().stream()
//                .map(lang -> Language.newBuilder().setCode(lang.getCode()).build())
//                .collect(Collectors.toList());
//
//        LanguageList response = LanguageList.newBuilder().addAllLanguages(languages).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void addLanguage(LanguageRequest request, StreamObserver<Response> responseObserver) {
//        try {
//            langMangService.validateISO639_1Code(request.getCode());
//            langMangService.validateLanguageNotExists(request.getCode());
//            langMangService.addLanguage(new Lang(request.getCode()));
//            Response response = Response.newBuilder().setMessage("Language added successfully").setSuccess(true).build();
//            responseObserver.onNext(response);
//        } catch (IllegalArgumentException e) {
//            Response response = Response.newBuilder().setMessage(e.getMessage()).setSuccess(false).build();
//            responseObserver.onNext(response);
//        }
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void removeLanguage(LanguageRequest request, StreamObserver<Response> responseObserver) {
//        try {
//            langMangService.validateLanguageExists(request.getCode());
//            langMangService.removeLanguage(request.getCode());
//            Response response = Response.newBuilder().setMessage("Language removed successfully").setSuccess(true).build();
//            responseObserver.onNext(response);
//        } catch (IllegalArgumentException e) {
//            Response response = Response.newBuilder().setMessage(e.getMessage()).setSuccess(false).build();
//            responseObserver.onNext(response);
//        }
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void clearLanguages(Empty request, StreamObserver<Response> responseObserver) {
//        langMangService.clearLanguages();
//        Response response = Response.newBuilder().setMessage("Languages cleared successfully").setSuccess(true).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//}