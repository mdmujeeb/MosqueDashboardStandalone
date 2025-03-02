package com.mujeeb.mosquedashboard.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The Mosque Dashboard Service Definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.1)",
    comments = "Source: mosque-dashboard.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MosqueDashboardServiceGrpc {

  private MosqueDashboardServiceGrpc() {}

  public static final String SERVICE_NAME = "com.mujeeb.mosquedashboard.grpc.MosqueDashboardService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.EmptyRequest,
      com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest> getGetDataForMobileAppMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataForMobileApp",
      requestType = com.mujeeb.mosquedashboard.grpc.EmptyRequest.class,
      responseType = com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.EmptyRequest,
      com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest> getGetDataForMobileAppMethod() {
    io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.EmptyRequest, com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest> getGetDataForMobileAppMethod;
    if ((getGetDataForMobileAppMethod = MosqueDashboardServiceGrpc.getGetDataForMobileAppMethod) == null) {
      synchronized (MosqueDashboardServiceGrpc.class) {
        if ((getGetDataForMobileAppMethod = MosqueDashboardServiceGrpc.getGetDataForMobileAppMethod) == null) {
          MosqueDashboardServiceGrpc.getGetDataForMobileAppMethod = getGetDataForMobileAppMethod =
              io.grpc.MethodDescriptor.<com.mujeeb.mosquedashboard.grpc.EmptyRequest, com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataForMobileApp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.EmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest.getDefaultInstance()))
              .setSchemaDescriptor(new MosqueDashboardServiceMethodDescriptorSupplier("GetDataForMobileApp"))
              .build();
        }
      }
    }
    return getGetDataForMobileAppMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.NamazTime,
      com.mujeeb.mosquedashboard.grpc.GenericReply> getUpdateNamazTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNamazTime",
      requestType = com.mujeeb.mosquedashboard.grpc.NamazTime.class,
      responseType = com.mujeeb.mosquedashboard.grpc.GenericReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.NamazTime,
      com.mujeeb.mosquedashboard.grpc.GenericReply> getUpdateNamazTimeMethod() {
    io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.NamazTime, com.mujeeb.mosquedashboard.grpc.GenericReply> getUpdateNamazTimeMethod;
    if ((getUpdateNamazTimeMethod = MosqueDashboardServiceGrpc.getUpdateNamazTimeMethod) == null) {
      synchronized (MosqueDashboardServiceGrpc.class) {
        if ((getUpdateNamazTimeMethod = MosqueDashboardServiceGrpc.getUpdateNamazTimeMethod) == null) {
          MosqueDashboardServiceGrpc.getUpdateNamazTimeMethod = getUpdateNamazTimeMethod =
              io.grpc.MethodDescriptor.<com.mujeeb.mosquedashboard.grpc.NamazTime, com.mujeeb.mosquedashboard.grpc.GenericReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNamazTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.NamazTime.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.GenericReply.getDefaultInstance()))
              .setSchemaDescriptor(new MosqueDashboardServiceMethodDescriptorSupplier("UpdateNamazTime"))
              .build();
        }
      }
    }
    return getUpdateNamazTimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest,
      com.mujeeb.mosquedashboard.grpc.GenericReply> getChangeHijriAdjustmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeHijriAdjustment",
      requestType = com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest.class,
      responseType = com.mujeeb.mosquedashboard.grpc.GenericReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest,
      com.mujeeb.mosquedashboard.grpc.GenericReply> getChangeHijriAdjustmentMethod() {
    io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest, com.mujeeb.mosquedashboard.grpc.GenericReply> getChangeHijriAdjustmentMethod;
    if ((getChangeHijriAdjustmentMethod = MosqueDashboardServiceGrpc.getChangeHijriAdjustmentMethod) == null) {
      synchronized (MosqueDashboardServiceGrpc.class) {
        if ((getChangeHijriAdjustmentMethod = MosqueDashboardServiceGrpc.getChangeHijriAdjustmentMethod) == null) {
          MosqueDashboardServiceGrpc.getChangeHijriAdjustmentMethod = getChangeHijriAdjustmentMethod =
              io.grpc.MethodDescriptor.<com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest, com.mujeeb.mosquedashboard.grpc.GenericReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ChangeHijriAdjustment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.GenericReply.getDefaultInstance()))
              .setSchemaDescriptor(new MosqueDashboardServiceMethodDescriptorSupplier("ChangeHijriAdjustment"))
              .build();
        }
      }
    }
    return getChangeHijriAdjustmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.EmptyRequest,
      com.mujeeb.mosquedashboard.grpc.GenericReply> getTestAudioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestAudio",
      requestType = com.mujeeb.mosquedashboard.grpc.EmptyRequest.class,
      responseType = com.mujeeb.mosquedashboard.grpc.GenericReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.EmptyRequest,
      com.mujeeb.mosquedashboard.grpc.GenericReply> getTestAudioMethod() {
    io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.EmptyRequest, com.mujeeb.mosquedashboard.grpc.GenericReply> getTestAudioMethod;
    if ((getTestAudioMethod = MosqueDashboardServiceGrpc.getTestAudioMethod) == null) {
      synchronized (MosqueDashboardServiceGrpc.class) {
        if ((getTestAudioMethod = MosqueDashboardServiceGrpc.getTestAudioMethod) == null) {
          MosqueDashboardServiceGrpc.getTestAudioMethod = getTestAudioMethod =
              io.grpc.MethodDescriptor.<com.mujeeb.mosquedashboard.grpc.EmptyRequest, com.mujeeb.mosquedashboard.grpc.GenericReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestAudio"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.EmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.GenericReply.getDefaultInstance()))
              .setSchemaDescriptor(new MosqueDashboardServiceMethodDescriptorSupplier("TestAudio"))
              .build();
        }
      }
    }
    return getTestAudioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest,
      com.mujeeb.mosquedashboard.grpc.GenericReply> getChangeScreenSaverStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeScreenSaverState",
      requestType = com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest.class,
      responseType = com.mujeeb.mosquedashboard.grpc.GenericReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest,
      com.mujeeb.mosquedashboard.grpc.GenericReply> getChangeScreenSaverStateMethod() {
    io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest, com.mujeeb.mosquedashboard.grpc.GenericReply> getChangeScreenSaverStateMethod;
    if ((getChangeScreenSaverStateMethod = MosqueDashboardServiceGrpc.getChangeScreenSaverStateMethod) == null) {
      synchronized (MosqueDashboardServiceGrpc.class) {
        if ((getChangeScreenSaverStateMethod = MosqueDashboardServiceGrpc.getChangeScreenSaverStateMethod) == null) {
          MosqueDashboardServiceGrpc.getChangeScreenSaverStateMethod = getChangeScreenSaverStateMethod =
              io.grpc.MethodDescriptor.<com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest, com.mujeeb.mosquedashboard.grpc.GenericReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ChangeScreenSaverState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.GenericReply.getDefaultInstance()))
              .setSchemaDescriptor(new MosqueDashboardServiceMethodDescriptorSupplier("ChangeScreenSaverState"))
              .build();
        }
      }
    }
    return getChangeScreenSaverStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.StringContainer,
      com.mujeeb.mosquedashboard.grpc.GenericReply> getSetDateTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetDateTime",
      requestType = com.mujeeb.mosquedashboard.grpc.StringContainer.class,
      responseType = com.mujeeb.mosquedashboard.grpc.GenericReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.StringContainer,
      com.mujeeb.mosquedashboard.grpc.GenericReply> getSetDateTimeMethod() {
    io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.StringContainer, com.mujeeb.mosquedashboard.grpc.GenericReply> getSetDateTimeMethod;
    if ((getSetDateTimeMethod = MosqueDashboardServiceGrpc.getSetDateTimeMethod) == null) {
      synchronized (MosqueDashboardServiceGrpc.class) {
        if ((getSetDateTimeMethod = MosqueDashboardServiceGrpc.getSetDateTimeMethod) == null) {
          MosqueDashboardServiceGrpc.getSetDateTimeMethod = getSetDateTimeMethod =
              io.grpc.MethodDescriptor.<com.mujeeb.mosquedashboard.grpc.StringContainer, com.mujeeb.mosquedashboard.grpc.GenericReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetDateTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.StringContainer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.GenericReply.getDefaultInstance()))
              .setSchemaDescriptor(new MosqueDashboardServiceMethodDescriptorSupplier("SetDateTime"))
              .build();
        }
      }
    }
    return getSetDateTimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.EmptyRequest,
      com.mujeeb.mosquedashboard.grpc.GenericReply> getRestartSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestartSystem",
      requestType = com.mujeeb.mosquedashboard.grpc.EmptyRequest.class,
      responseType = com.mujeeb.mosquedashboard.grpc.GenericReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.EmptyRequest,
      com.mujeeb.mosquedashboard.grpc.GenericReply> getRestartSystemMethod() {
    io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.EmptyRequest, com.mujeeb.mosquedashboard.grpc.GenericReply> getRestartSystemMethod;
    if ((getRestartSystemMethod = MosqueDashboardServiceGrpc.getRestartSystemMethod) == null) {
      synchronized (MosqueDashboardServiceGrpc.class) {
        if ((getRestartSystemMethod = MosqueDashboardServiceGrpc.getRestartSystemMethod) == null) {
          MosqueDashboardServiceGrpc.getRestartSystemMethod = getRestartSystemMethod =
              io.grpc.MethodDescriptor.<com.mujeeb.mosquedashboard.grpc.EmptyRequest, com.mujeeb.mosquedashboard.grpc.GenericReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestartSystem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.EmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.GenericReply.getDefaultInstance()))
              .setSchemaDescriptor(new MosqueDashboardServiceMethodDescriptorSupplier("RestartSystem"))
              .build();
        }
      }
    }
    return getRestartSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.EmptyRequest,
      com.mujeeb.mosquedashboard.grpc.StringContainer> getHasDateChangedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HasDateChanged",
      requestType = com.mujeeb.mosquedashboard.grpc.EmptyRequest.class,
      responseType = com.mujeeb.mosquedashboard.grpc.StringContainer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.EmptyRequest,
      com.mujeeb.mosquedashboard.grpc.StringContainer> getHasDateChangedMethod() {
    io.grpc.MethodDescriptor<com.mujeeb.mosquedashboard.grpc.EmptyRequest, com.mujeeb.mosquedashboard.grpc.StringContainer> getHasDateChangedMethod;
    if ((getHasDateChangedMethod = MosqueDashboardServiceGrpc.getHasDateChangedMethod) == null) {
      synchronized (MosqueDashboardServiceGrpc.class) {
        if ((getHasDateChangedMethod = MosqueDashboardServiceGrpc.getHasDateChangedMethod) == null) {
          MosqueDashboardServiceGrpc.getHasDateChangedMethod = getHasDateChangedMethod =
              io.grpc.MethodDescriptor.<com.mujeeb.mosquedashboard.grpc.EmptyRequest, com.mujeeb.mosquedashboard.grpc.StringContainer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HasDateChanged"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.EmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mujeeb.mosquedashboard.grpc.StringContainer.getDefaultInstance()))
              .setSchemaDescriptor(new MosqueDashboardServiceMethodDescriptorSupplier("HasDateChanged"))
              .build();
        }
      }
    }
    return getHasDateChangedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MosqueDashboardServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MosqueDashboardServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MosqueDashboardServiceStub>() {
        @java.lang.Override
        public MosqueDashboardServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MosqueDashboardServiceStub(channel, callOptions);
        }
      };
    return MosqueDashboardServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MosqueDashboardServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MosqueDashboardServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MosqueDashboardServiceBlockingStub>() {
        @java.lang.Override
        public MosqueDashboardServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MosqueDashboardServiceBlockingStub(channel, callOptions);
        }
      };
    return MosqueDashboardServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MosqueDashboardServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MosqueDashboardServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MosqueDashboardServiceFutureStub>() {
        @java.lang.Override
        public MosqueDashboardServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MosqueDashboardServiceFutureStub(channel, callOptions);
        }
      };
    return MosqueDashboardServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The Mosque Dashboard Service Definition.
   * </pre>
   */
  public static abstract class MosqueDashboardServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDataForMobileApp(com.mujeeb.mosquedashboard.grpc.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDataForMobileAppMethod(), responseObserver);
    }

    /**
     */
    public void updateNamazTime(com.mujeeb.mosquedashboard.grpc.NamazTime request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateNamazTimeMethod(), responseObserver);
    }

    /**
     */
    public void changeHijriAdjustment(com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChangeHijriAdjustmentMethod(), responseObserver);
    }

    /**
     */
    public void testAudio(com.mujeeb.mosquedashboard.grpc.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestAudioMethod(), responseObserver);
    }

    /**
     */
    public void changeScreenSaverState(com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChangeScreenSaverStateMethod(), responseObserver);
    }

    /**
     */
    public void setDateTime(com.mujeeb.mosquedashboard.grpc.StringContainer request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetDateTimeMethod(), responseObserver);
    }

    /**
     */
    public void restartSystem(com.mujeeb.mosquedashboard.grpc.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestartSystemMethod(), responseObserver);
    }

    /**
     */
    public void hasDateChanged(com.mujeeb.mosquedashboard.grpc.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.StringContainer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHasDateChangedMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDataForMobileAppMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.mujeeb.mosquedashboard.grpc.EmptyRequest,
                com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest>(
                  this, METHODID_GET_DATA_FOR_MOBILE_APP)))
          .addMethod(
            getUpdateNamazTimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.mujeeb.mosquedashboard.grpc.NamazTime,
                com.mujeeb.mosquedashboard.grpc.GenericReply>(
                  this, METHODID_UPDATE_NAMAZ_TIME)))
          .addMethod(
            getChangeHijriAdjustmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest,
                com.mujeeb.mosquedashboard.grpc.GenericReply>(
                  this, METHODID_CHANGE_HIJRI_ADJUSTMENT)))
          .addMethod(
            getTestAudioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.mujeeb.mosquedashboard.grpc.EmptyRequest,
                com.mujeeb.mosquedashboard.grpc.GenericReply>(
                  this, METHODID_TEST_AUDIO)))
          .addMethod(
            getChangeScreenSaverStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest,
                com.mujeeb.mosquedashboard.grpc.GenericReply>(
                  this, METHODID_CHANGE_SCREEN_SAVER_STATE)))
          .addMethod(
            getSetDateTimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.mujeeb.mosquedashboard.grpc.StringContainer,
                com.mujeeb.mosquedashboard.grpc.GenericReply>(
                  this, METHODID_SET_DATE_TIME)))
          .addMethod(
            getRestartSystemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.mujeeb.mosquedashboard.grpc.EmptyRequest,
                com.mujeeb.mosquedashboard.grpc.GenericReply>(
                  this, METHODID_RESTART_SYSTEM)))
          .addMethod(
            getHasDateChangedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.mujeeb.mosquedashboard.grpc.EmptyRequest,
                com.mujeeb.mosquedashboard.grpc.StringContainer>(
                  this, METHODID_HAS_DATE_CHANGED)))
          .build();
    }
  }

  /**
   * <pre>
   * The Mosque Dashboard Service Definition.
   * </pre>
   */
  public static final class MosqueDashboardServiceStub extends io.grpc.stub.AbstractAsyncStub<MosqueDashboardServiceStub> {
    private MosqueDashboardServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MosqueDashboardServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MosqueDashboardServiceStub(channel, callOptions);
    }

    /**
     */
    public void getDataForMobileApp(com.mujeeb.mosquedashboard.grpc.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataForMobileAppMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateNamazTime(com.mujeeb.mosquedashboard.grpc.NamazTime request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNamazTimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeHijriAdjustment(com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChangeHijriAdjustmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void testAudio(com.mujeeb.mosquedashboard.grpc.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestAudioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeScreenSaverState(com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChangeScreenSaverStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setDateTime(com.mujeeb.mosquedashboard.grpc.StringContainer request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetDateTimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void restartSystem(com.mujeeb.mosquedashboard.grpc.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestartSystemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void hasDateChanged(com.mujeeb.mosquedashboard.grpc.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.StringContainer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHasDateChangedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Mosque Dashboard Service Definition.
   * </pre>
   */
  public static final class MosqueDashboardServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MosqueDashboardServiceBlockingStub> {
    private MosqueDashboardServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MosqueDashboardServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MosqueDashboardServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest getDataForMobileApp(com.mujeeb.mosquedashboard.grpc.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataForMobileAppMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mujeeb.mosquedashboard.grpc.GenericReply updateNamazTime(com.mujeeb.mosquedashboard.grpc.NamazTime request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNamazTimeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mujeeb.mosquedashboard.grpc.GenericReply changeHijriAdjustment(com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChangeHijriAdjustmentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mujeeb.mosquedashboard.grpc.GenericReply testAudio(com.mujeeb.mosquedashboard.grpc.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestAudioMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mujeeb.mosquedashboard.grpc.GenericReply changeScreenSaverState(com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChangeScreenSaverStateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mujeeb.mosquedashboard.grpc.GenericReply setDateTime(com.mujeeb.mosquedashboard.grpc.StringContainer request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetDateTimeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mujeeb.mosquedashboard.grpc.GenericReply restartSystem(com.mujeeb.mosquedashboard.grpc.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartSystemMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mujeeb.mosquedashboard.grpc.StringContainer hasDateChanged(com.mujeeb.mosquedashboard.grpc.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHasDateChangedMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Mosque Dashboard Service Definition.
   * </pre>
   */
  public static final class MosqueDashboardServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MosqueDashboardServiceFutureStub> {
    private MosqueDashboardServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MosqueDashboardServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MosqueDashboardServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest> getDataForMobileApp(
        com.mujeeb.mosquedashboard.grpc.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataForMobileAppMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mujeeb.mosquedashboard.grpc.GenericReply> updateNamazTime(
        com.mujeeb.mosquedashboard.grpc.NamazTime request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNamazTimeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mujeeb.mosquedashboard.grpc.GenericReply> changeHijriAdjustment(
        com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChangeHijriAdjustmentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mujeeb.mosquedashboard.grpc.GenericReply> testAudio(
        com.mujeeb.mosquedashboard.grpc.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestAudioMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mujeeb.mosquedashboard.grpc.GenericReply> changeScreenSaverState(
        com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChangeScreenSaverStateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mujeeb.mosquedashboard.grpc.GenericReply> setDateTime(
        com.mujeeb.mosquedashboard.grpc.StringContainer request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetDateTimeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mujeeb.mosquedashboard.grpc.GenericReply> restartSystem(
        com.mujeeb.mosquedashboard.grpc.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestartSystemMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mujeeb.mosquedashboard.grpc.StringContainer> hasDateChanged(
        com.mujeeb.mosquedashboard.grpc.EmptyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHasDateChangedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DATA_FOR_MOBILE_APP = 0;
  private static final int METHODID_UPDATE_NAMAZ_TIME = 1;
  private static final int METHODID_CHANGE_HIJRI_ADJUSTMENT = 2;
  private static final int METHODID_TEST_AUDIO = 3;
  private static final int METHODID_CHANGE_SCREEN_SAVER_STATE = 4;
  private static final int METHODID_SET_DATE_TIME = 5;
  private static final int METHODID_RESTART_SYSTEM = 6;
  private static final int METHODID_HAS_DATE_CHANGED = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MosqueDashboardServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MosqueDashboardServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DATA_FOR_MOBILE_APP:
          serviceImpl.getDataForMobileApp((com.mujeeb.mosquedashboard.grpc.EmptyRequest) request,
              (io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GetDataForMobileAppRequest>) responseObserver);
          break;
        case METHODID_UPDATE_NAMAZ_TIME:
          serviceImpl.updateNamazTime((com.mujeeb.mosquedashboard.grpc.NamazTime) request,
              (io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply>) responseObserver);
          break;
        case METHODID_CHANGE_HIJRI_ADJUSTMENT:
          serviceImpl.changeHijriAdjustment((com.mujeeb.mosquedashboard.grpc.HijriAdjustmentUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply>) responseObserver);
          break;
        case METHODID_TEST_AUDIO:
          serviceImpl.testAudio((com.mujeeb.mosquedashboard.grpc.EmptyRequest) request,
              (io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply>) responseObserver);
          break;
        case METHODID_CHANGE_SCREEN_SAVER_STATE:
          serviceImpl.changeScreenSaverState((com.mujeeb.mosquedashboard.grpc.ScreenSaverStateUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply>) responseObserver);
          break;
        case METHODID_SET_DATE_TIME:
          serviceImpl.setDateTime((com.mujeeb.mosquedashboard.grpc.StringContainer) request,
              (io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply>) responseObserver);
          break;
        case METHODID_RESTART_SYSTEM:
          serviceImpl.restartSystem((com.mujeeb.mosquedashboard.grpc.EmptyRequest) request,
              (io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.GenericReply>) responseObserver);
          break;
        case METHODID_HAS_DATE_CHANGED:
          serviceImpl.hasDateChanged((com.mujeeb.mosquedashboard.grpc.EmptyRequest) request,
              (io.grpc.stub.StreamObserver<com.mujeeb.mosquedashboard.grpc.StringContainer>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MosqueDashboardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MosqueDashboardServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mujeeb.mosquedashboard.grpc.MosqueDashboardProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MosqueDashboardService");
    }
  }

  private static final class MosqueDashboardServiceFileDescriptorSupplier
      extends MosqueDashboardServiceBaseDescriptorSupplier {
    MosqueDashboardServiceFileDescriptorSupplier() {}
  }

  private static final class MosqueDashboardServiceMethodDescriptorSupplier
      extends MosqueDashboardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MosqueDashboardServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MosqueDashboardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MosqueDashboardServiceFileDescriptorSupplier())
              .addMethod(getGetDataForMobileAppMethod())
              .addMethod(getUpdateNamazTimeMethod())
              .addMethod(getChangeHijriAdjustmentMethod())
              .addMethod(getTestAudioMethod())
              .addMethod(getChangeScreenSaverStateMethod())
              .addMethod(getSetDateTimeMethod())
              .addMethod(getRestartSystemMethod())
              .addMethod(getHasDateChangedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
