package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.0)",
    comments = "Source: document.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DocumentServiceGrpc {

  private DocumentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "DocumentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.DocumentProto.DocumentAddRequest,
      com.example.grpc.DocumentProto.DocumentResponse> getAddDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddDocument",
      requestType = com.example.grpc.DocumentProto.DocumentAddRequest.class,
      responseType = com.example.grpc.DocumentProto.DocumentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.DocumentProto.DocumentAddRequest,
      com.example.grpc.DocumentProto.DocumentResponse> getAddDocumentMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.DocumentProto.DocumentAddRequest, com.example.grpc.DocumentProto.DocumentResponse> getAddDocumentMethod;
    if ((getAddDocumentMethod = DocumentServiceGrpc.getAddDocumentMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getAddDocumentMethod = DocumentServiceGrpc.getAddDocumentMethod) == null) {
          DocumentServiceGrpc.getAddDocumentMethod = getAddDocumentMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.DocumentProto.DocumentAddRequest, com.example.grpc.DocumentProto.DocumentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddDocument"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.DocumentProto.DocumentAddRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.DocumentProto.DocumentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DocumentServiceMethodDescriptorSupplier("AddDocument"))
              .build();
        }
      }
    }
    return getAddDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.grpc.DocumentProto.GetDocumentsResponse> getGetAllDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllDocuments",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.example.grpc.DocumentProto.GetDocumentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.grpc.DocumentProto.GetDocumentsResponse> getGetAllDocumentsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.example.grpc.DocumentProto.GetDocumentsResponse> getGetAllDocumentsMethod;
    if ((getGetAllDocumentsMethod = DocumentServiceGrpc.getGetAllDocumentsMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getGetAllDocumentsMethod = DocumentServiceGrpc.getGetAllDocumentsMethod) == null) {
          DocumentServiceGrpc.getGetAllDocumentsMethod = getGetAllDocumentsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.example.grpc.DocumentProto.GetDocumentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllDocuments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.DocumentProto.GetDocumentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DocumentServiceMethodDescriptorSupplier("GetAllDocuments"))
              .build();
        }
      }
    }
    return getGetAllDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.DocumentProto.DownloadFileRequest,
      com.example.grpc.DocumentProto.DownloadFileResponse> getDownloadFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DownloadFile",
      requestType = com.example.grpc.DocumentProto.DownloadFileRequest.class,
      responseType = com.example.grpc.DocumentProto.DownloadFileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.DocumentProto.DownloadFileRequest,
      com.example.grpc.DocumentProto.DownloadFileResponse> getDownloadFileMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.DocumentProto.DownloadFileRequest, com.example.grpc.DocumentProto.DownloadFileResponse> getDownloadFileMethod;
    if ((getDownloadFileMethod = DocumentServiceGrpc.getDownloadFileMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getDownloadFileMethod = DocumentServiceGrpc.getDownloadFileMethod) == null) {
          DocumentServiceGrpc.getDownloadFileMethod = getDownloadFileMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.DocumentProto.DownloadFileRequest, com.example.grpc.DocumentProto.DownloadFileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DownloadFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.DocumentProto.DownloadFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.DocumentProto.DownloadFileResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DocumentServiceMethodDescriptorSupplier("DownloadFile"))
              .build();
        }
      }
    }
    return getDownloadFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.DocumentProto.CheckOutdatedDocumentsRequest,
      com.example.grpc.DocumentProto.CheckOutdatedDocumentsResponse> getCheckOutdatedDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckOutdatedDocuments",
      requestType = com.example.grpc.DocumentProto.CheckOutdatedDocumentsRequest.class,
      responseType = com.example.grpc.DocumentProto.CheckOutdatedDocumentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.DocumentProto.CheckOutdatedDocumentsRequest,
      com.example.grpc.DocumentProto.CheckOutdatedDocumentsResponse> getCheckOutdatedDocumentsMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.DocumentProto.CheckOutdatedDocumentsRequest, com.example.grpc.DocumentProto.CheckOutdatedDocumentsResponse> getCheckOutdatedDocumentsMethod;
    if ((getCheckOutdatedDocumentsMethod = DocumentServiceGrpc.getCheckOutdatedDocumentsMethod) == null) {
      synchronized (DocumentServiceGrpc.class) {
        if ((getCheckOutdatedDocumentsMethod = DocumentServiceGrpc.getCheckOutdatedDocumentsMethod) == null) {
          DocumentServiceGrpc.getCheckOutdatedDocumentsMethod = getCheckOutdatedDocumentsMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.DocumentProto.CheckOutdatedDocumentsRequest, com.example.grpc.DocumentProto.CheckOutdatedDocumentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckOutdatedDocuments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.DocumentProto.CheckOutdatedDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.DocumentProto.CheckOutdatedDocumentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DocumentServiceMethodDescriptorSupplier("CheckOutdatedDocuments"))
              .build();
        }
      }
    }
    return getCheckOutdatedDocumentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DocumentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DocumentServiceStub>() {
        @java.lang.Override
        public DocumentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DocumentServiceStub(channel, callOptions);
        }
      };
    return DocumentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DocumentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DocumentServiceBlockingStub>() {
        @java.lang.Override
        public DocumentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DocumentServiceBlockingStub(channel, callOptions);
        }
      };
    return DocumentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DocumentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DocumentServiceFutureStub>() {
        @java.lang.Override
        public DocumentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DocumentServiceFutureStub(channel, callOptions);
        }
      };
    return DocumentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addDocument(com.example.grpc.DocumentProto.DocumentAddRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.DocumentProto.DocumentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddDocumentMethod(), responseObserver);
    }

    /**
     */
    default void getAllDocuments(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.DocumentProto.GetDocumentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllDocumentsMethod(), responseObserver);
    }

    /**
     */
    default void downloadFile(com.example.grpc.DocumentProto.DownloadFileRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.DocumentProto.DownloadFileResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDownloadFileMethod(), responseObserver);
    }

    /**
     */
    default void checkOutdatedDocuments(com.example.grpc.DocumentProto.CheckOutdatedDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.DocumentProto.CheckOutdatedDocumentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckOutdatedDocumentsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DocumentService.
   */
  public static abstract class DocumentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DocumentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DocumentService.
   */
  public static final class DocumentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DocumentServiceStub> {
    private DocumentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentServiceStub(channel, callOptions);
    }

    /**
     */
    public void addDocument(com.example.grpc.DocumentProto.DocumentAddRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.DocumentProto.DocumentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddDocumentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllDocuments(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.DocumentProto.GetDocumentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllDocumentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void downloadFile(com.example.grpc.DocumentProto.DownloadFileRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.DocumentProto.DownloadFileResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDownloadFileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkOutdatedDocuments(com.example.grpc.DocumentProto.CheckOutdatedDocumentsRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.DocumentProto.CheckOutdatedDocumentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckOutdatedDocumentsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DocumentService.
   */
  public static final class DocumentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DocumentServiceBlockingStub> {
    private DocumentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.DocumentProto.DocumentResponse addDocument(com.example.grpc.DocumentProto.DocumentAddRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddDocumentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.DocumentProto.GetDocumentsResponse getAllDocuments(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllDocumentsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.DocumentProto.DownloadFileResponse downloadFile(com.example.grpc.DocumentProto.DownloadFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDownloadFileMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.DocumentProto.CheckOutdatedDocumentsResponse checkOutdatedDocuments(com.example.grpc.DocumentProto.CheckOutdatedDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckOutdatedDocumentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DocumentService.
   */
  public static final class DocumentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DocumentServiceFutureStub> {
    private DocumentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.DocumentProto.DocumentResponse> addDocument(
        com.example.grpc.DocumentProto.DocumentAddRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddDocumentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.DocumentProto.GetDocumentsResponse> getAllDocuments(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllDocumentsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.DocumentProto.DownloadFileResponse> downloadFile(
        com.example.grpc.DocumentProto.DownloadFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDownloadFileMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.DocumentProto.CheckOutdatedDocumentsResponse> checkOutdatedDocuments(
        com.example.grpc.DocumentProto.CheckOutdatedDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckOutdatedDocumentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_DOCUMENT = 0;
  private static final int METHODID_GET_ALL_DOCUMENTS = 1;
  private static final int METHODID_DOWNLOAD_FILE = 2;
  private static final int METHODID_CHECK_OUTDATED_DOCUMENTS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_DOCUMENT:
          serviceImpl.addDocument((com.example.grpc.DocumentProto.DocumentAddRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.DocumentProto.DocumentResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_DOCUMENTS:
          serviceImpl.getAllDocuments((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.DocumentProto.GetDocumentsResponse>) responseObserver);
          break;
        case METHODID_DOWNLOAD_FILE:
          serviceImpl.downloadFile((com.example.grpc.DocumentProto.DownloadFileRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.DocumentProto.DownloadFileResponse>) responseObserver);
          break;
        case METHODID_CHECK_OUTDATED_DOCUMENTS:
          serviceImpl.checkOutdatedDocuments((com.example.grpc.DocumentProto.CheckOutdatedDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.DocumentProto.CheckOutdatedDocumentsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddDocumentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.DocumentProto.DocumentAddRequest,
              com.example.grpc.DocumentProto.DocumentResponse>(
                service, METHODID_ADD_DOCUMENT)))
        .addMethod(
          getGetAllDocumentsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.example.grpc.DocumentProto.GetDocumentsResponse>(
                service, METHODID_GET_ALL_DOCUMENTS)))
        .addMethod(
          getDownloadFileMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.DocumentProto.DownloadFileRequest,
              com.example.grpc.DocumentProto.DownloadFileResponse>(
                service, METHODID_DOWNLOAD_FILE)))
        .addMethod(
          getCheckOutdatedDocumentsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.DocumentProto.CheckOutdatedDocumentsRequest,
              com.example.grpc.DocumentProto.CheckOutdatedDocumentsResponse>(
                service, METHODID_CHECK_OUTDATED_DOCUMENTS)))
        .build();
  }

  private static abstract class DocumentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DocumentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.DocumentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DocumentService");
    }
  }

  private static final class DocumentServiceFileDescriptorSupplier
      extends DocumentServiceBaseDescriptorSupplier {
    DocumentServiceFileDescriptorSupplier() {}
  }

  private static final class DocumentServiceMethodDescriptorSupplier
      extends DocumentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DocumentServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DocumentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DocumentServiceFileDescriptorSupplier())
              .addMethod(getAddDocumentMethod())
              .addMethod(getGetAllDocumentsMethod())
              .addMethod(getDownloadFileMethod())
              .addMethod(getCheckOutdatedDocumentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
