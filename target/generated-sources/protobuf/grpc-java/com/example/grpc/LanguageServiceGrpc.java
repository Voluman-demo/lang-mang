package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.0)",
    comments = "Source: language.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LanguageServiceGrpc {

  private LanguageServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "LanguageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.LanguageProto.Empty,
      com.example.grpc.LanguageProto.LanguageList> getGetAllLanguagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllLanguages",
      requestType = com.example.grpc.LanguageProto.Empty.class,
      responseType = com.example.grpc.LanguageProto.LanguageList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.LanguageProto.Empty,
      com.example.grpc.LanguageProto.LanguageList> getGetAllLanguagesMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.LanguageProto.Empty, com.example.grpc.LanguageProto.LanguageList> getGetAllLanguagesMethod;
    if ((getGetAllLanguagesMethod = LanguageServiceGrpc.getGetAllLanguagesMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getGetAllLanguagesMethod = LanguageServiceGrpc.getGetAllLanguagesMethod) == null) {
          LanguageServiceGrpc.getGetAllLanguagesMethod = getGetAllLanguagesMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.LanguageProto.Empty, com.example.grpc.LanguageProto.LanguageList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllLanguages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.LanguageProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.LanguageProto.LanguageList.getDefaultInstance()))
              .setSchemaDescriptor(new LanguageServiceMethodDescriptorSupplier("GetAllLanguages"))
              .build();
        }
      }
    }
    return getGetAllLanguagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.LanguageProto.LanguageRequest,
      com.example.grpc.LanguageProto.Response> getAddLanguageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddLanguage",
      requestType = com.example.grpc.LanguageProto.LanguageRequest.class,
      responseType = com.example.grpc.LanguageProto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.LanguageProto.LanguageRequest,
      com.example.grpc.LanguageProto.Response> getAddLanguageMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.LanguageProto.LanguageRequest, com.example.grpc.LanguageProto.Response> getAddLanguageMethod;
    if ((getAddLanguageMethod = LanguageServiceGrpc.getAddLanguageMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getAddLanguageMethod = LanguageServiceGrpc.getAddLanguageMethod) == null) {
          LanguageServiceGrpc.getAddLanguageMethod = getAddLanguageMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.LanguageProto.LanguageRequest, com.example.grpc.LanguageProto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddLanguage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.LanguageProto.LanguageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.LanguageProto.Response.getDefaultInstance()))
              .setSchemaDescriptor(new LanguageServiceMethodDescriptorSupplier("AddLanguage"))
              .build();
        }
      }
    }
    return getAddLanguageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.LanguageProto.LanguageRequest,
      com.example.grpc.LanguageProto.Response> getRemoveLanguageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveLanguage",
      requestType = com.example.grpc.LanguageProto.LanguageRequest.class,
      responseType = com.example.grpc.LanguageProto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.LanguageProto.LanguageRequest,
      com.example.grpc.LanguageProto.Response> getRemoveLanguageMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.LanguageProto.LanguageRequest, com.example.grpc.LanguageProto.Response> getRemoveLanguageMethod;
    if ((getRemoveLanguageMethod = LanguageServiceGrpc.getRemoveLanguageMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getRemoveLanguageMethod = LanguageServiceGrpc.getRemoveLanguageMethod) == null) {
          LanguageServiceGrpc.getRemoveLanguageMethod = getRemoveLanguageMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.LanguageProto.LanguageRequest, com.example.grpc.LanguageProto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveLanguage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.LanguageProto.LanguageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.LanguageProto.Response.getDefaultInstance()))
              .setSchemaDescriptor(new LanguageServiceMethodDescriptorSupplier("RemoveLanguage"))
              .build();
        }
      }
    }
    return getRemoveLanguageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.LanguageProto.Empty,
      com.example.grpc.LanguageProto.Response> getClearLanguagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClearLanguages",
      requestType = com.example.grpc.LanguageProto.Empty.class,
      responseType = com.example.grpc.LanguageProto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.LanguageProto.Empty,
      com.example.grpc.LanguageProto.Response> getClearLanguagesMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.LanguageProto.Empty, com.example.grpc.LanguageProto.Response> getClearLanguagesMethod;
    if ((getClearLanguagesMethod = LanguageServiceGrpc.getClearLanguagesMethod) == null) {
      synchronized (LanguageServiceGrpc.class) {
        if ((getClearLanguagesMethod = LanguageServiceGrpc.getClearLanguagesMethod) == null) {
          LanguageServiceGrpc.getClearLanguagesMethod = getClearLanguagesMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.LanguageProto.Empty, com.example.grpc.LanguageProto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClearLanguages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.LanguageProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.LanguageProto.Response.getDefaultInstance()))
              .setSchemaDescriptor(new LanguageServiceMethodDescriptorSupplier("ClearLanguages"))
              .build();
        }
      }
    }
    return getClearLanguagesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LanguageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LanguageServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LanguageServiceStub>() {
        @java.lang.Override
        public LanguageServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LanguageServiceStub(channel, callOptions);
        }
      };
    return LanguageServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LanguageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LanguageServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LanguageServiceBlockingStub>() {
        @java.lang.Override
        public LanguageServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LanguageServiceBlockingStub(channel, callOptions);
        }
      };
    return LanguageServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LanguageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LanguageServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LanguageServiceFutureStub>() {
        @java.lang.Override
        public LanguageServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LanguageServiceFutureStub(channel, callOptions);
        }
      };
    return LanguageServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getAllLanguages(com.example.grpc.LanguageProto.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.LanguageProto.LanguageList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllLanguagesMethod(), responseObserver);
    }

    /**
     */
    default void addLanguage(com.example.grpc.LanguageProto.LanguageRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.LanguageProto.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddLanguageMethod(), responseObserver);
    }

    /**
     */
    default void removeLanguage(com.example.grpc.LanguageProto.LanguageRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.LanguageProto.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveLanguageMethod(), responseObserver);
    }

    /**
     */
    default void clearLanguages(com.example.grpc.LanguageProto.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.LanguageProto.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getClearLanguagesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LanguageService.
   */
  public static abstract class LanguageServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LanguageServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LanguageService.
   */
  public static final class LanguageServiceStub
      extends io.grpc.stub.AbstractAsyncStub<LanguageServiceStub> {
    private LanguageServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LanguageServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LanguageServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllLanguages(com.example.grpc.LanguageProto.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.LanguageProto.LanguageList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllLanguagesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addLanguage(com.example.grpc.LanguageProto.LanguageRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.LanguageProto.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddLanguageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeLanguage(com.example.grpc.LanguageProto.LanguageRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.LanguageProto.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveLanguageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void clearLanguages(com.example.grpc.LanguageProto.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.LanguageProto.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getClearLanguagesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LanguageService.
   */
  public static final class LanguageServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LanguageServiceBlockingStub> {
    private LanguageServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LanguageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LanguageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.LanguageProto.LanguageList getAllLanguages(com.example.grpc.LanguageProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllLanguagesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.LanguageProto.Response addLanguage(com.example.grpc.LanguageProto.LanguageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddLanguageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.LanguageProto.Response removeLanguage(com.example.grpc.LanguageProto.LanguageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveLanguageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.LanguageProto.Response clearLanguages(com.example.grpc.LanguageProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getClearLanguagesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LanguageService.
   */
  public static final class LanguageServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<LanguageServiceFutureStub> {
    private LanguageServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LanguageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LanguageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.LanguageProto.LanguageList> getAllLanguages(
        com.example.grpc.LanguageProto.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllLanguagesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.LanguageProto.Response> addLanguage(
        com.example.grpc.LanguageProto.LanguageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddLanguageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.LanguageProto.Response> removeLanguage(
        com.example.grpc.LanguageProto.LanguageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveLanguageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.LanguageProto.Response> clearLanguages(
        com.example.grpc.LanguageProto.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getClearLanguagesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_LANGUAGES = 0;
  private static final int METHODID_ADD_LANGUAGE = 1;
  private static final int METHODID_REMOVE_LANGUAGE = 2;
  private static final int METHODID_CLEAR_LANGUAGES = 3;

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
        case METHODID_GET_ALL_LANGUAGES:
          serviceImpl.getAllLanguages((com.example.grpc.LanguageProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.LanguageProto.LanguageList>) responseObserver);
          break;
        case METHODID_ADD_LANGUAGE:
          serviceImpl.addLanguage((com.example.grpc.LanguageProto.LanguageRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.LanguageProto.Response>) responseObserver);
          break;
        case METHODID_REMOVE_LANGUAGE:
          serviceImpl.removeLanguage((com.example.grpc.LanguageProto.LanguageRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.LanguageProto.Response>) responseObserver);
          break;
        case METHODID_CLEAR_LANGUAGES:
          serviceImpl.clearLanguages((com.example.grpc.LanguageProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.LanguageProto.Response>) responseObserver);
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
          getGetAllLanguagesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.LanguageProto.Empty,
              com.example.grpc.LanguageProto.LanguageList>(
                service, METHODID_GET_ALL_LANGUAGES)))
        .addMethod(
          getAddLanguageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.LanguageProto.LanguageRequest,
              com.example.grpc.LanguageProto.Response>(
                service, METHODID_ADD_LANGUAGE)))
        .addMethod(
          getRemoveLanguageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.LanguageProto.LanguageRequest,
              com.example.grpc.LanguageProto.Response>(
                service, METHODID_REMOVE_LANGUAGE)))
        .addMethod(
          getClearLanguagesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.LanguageProto.Empty,
              com.example.grpc.LanguageProto.Response>(
                service, METHODID_CLEAR_LANGUAGES)))
        .build();
  }

  private static abstract class LanguageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LanguageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.LanguageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LanguageService");
    }
  }

  private static final class LanguageServiceFileDescriptorSupplier
      extends LanguageServiceBaseDescriptorSupplier {
    LanguageServiceFileDescriptorSupplier() {}
  }

  private static final class LanguageServiceMethodDescriptorSupplier
      extends LanguageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LanguageServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LanguageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LanguageServiceFileDescriptorSupplier())
              .addMethod(getGetAllLanguagesMethod())
              .addMethod(getAddLanguageMethod())
              .addMethod(getRemoveLanguageMethod())
              .addMethod(getClearLanguagesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
