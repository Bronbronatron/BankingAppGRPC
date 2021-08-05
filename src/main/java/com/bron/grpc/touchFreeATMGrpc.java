package com.bron.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: touchFreeAtm.proto")
public final class touchFreeATMGrpc {

  private touchFreeATMGrpc() {}

  public static final String SERVICE_NAME = "touchFreeATM";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.bron.grpc.inputPin,
      com.bron.grpc.authenticationMessage> getAuthenticateCardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "authenticateCard",
      requestType = com.bron.grpc.inputPin.class,
      responseType = com.bron.grpc.authenticationMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.bron.grpc.inputPin,
      com.bron.grpc.authenticationMessage> getAuthenticateCardMethod() {
    io.grpc.MethodDescriptor<com.bron.grpc.inputPin, com.bron.grpc.authenticationMessage> getAuthenticateCardMethod;
    if ((getAuthenticateCardMethod = touchFreeATMGrpc.getAuthenticateCardMethod) == null) {
      synchronized (touchFreeATMGrpc.class) {
        if ((getAuthenticateCardMethod = touchFreeATMGrpc.getAuthenticateCardMethod) == null) {
          touchFreeATMGrpc.getAuthenticateCardMethod = getAuthenticateCardMethod = 
              io.grpc.MethodDescriptor.<com.bron.grpc.inputPin, com.bron.grpc.authenticationMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "touchFreeATM", "authenticateCard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bron.grpc.inputPin.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bron.grpc.authenticationMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new touchFreeATMMethodDescriptorSupplier("authenticateCard"))
                  .build();
          }
        }
     }
     return getAuthenticateCardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bron.grpc.searchATM,
      com.bron.grpc.availableMachines> getFindNearByATMMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findNearByATM",
      requestType = com.bron.grpc.searchATM.class,
      responseType = com.bron.grpc.availableMachines.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.bron.grpc.searchATM,
      com.bron.grpc.availableMachines> getFindNearByATMMethod() {
    io.grpc.MethodDescriptor<com.bron.grpc.searchATM, com.bron.grpc.availableMachines> getFindNearByATMMethod;
    if ((getFindNearByATMMethod = touchFreeATMGrpc.getFindNearByATMMethod) == null) {
      synchronized (touchFreeATMGrpc.class) {
        if ((getFindNearByATMMethod = touchFreeATMGrpc.getFindNearByATMMethod) == null) {
          touchFreeATMGrpc.getFindNearByATMMethod = getFindNearByATMMethod = 
              io.grpc.MethodDescriptor.<com.bron.grpc.searchATM, com.bron.grpc.availableMachines>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "touchFreeATM", "findNearByATM"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bron.grpc.searchATM.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bron.grpc.availableMachines.getDefaultInstance()))
                  .setSchemaDescriptor(new touchFreeATMMethodDescriptorSupplier("findNearByATM"))
                  .build();
          }
        }
     }
     return getFindNearByATMMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static touchFreeATMStub newStub(io.grpc.Channel channel) {
    return new touchFreeATMStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static touchFreeATMBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new touchFreeATMBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static touchFreeATMFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new touchFreeATMFutureStub(channel);
  }

  /**
   */
  public static abstract class touchFreeATMImplBase implements io.grpc.BindableService {

    /**
     */
    public void authenticateCard(com.bron.grpc.inputPin request,
        io.grpc.stub.StreamObserver<com.bron.grpc.authenticationMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getAuthenticateCardMethod(), responseObserver);
    }

    /**
     */
    public void findNearByATM(com.bron.grpc.searchATM request,
        io.grpc.stub.StreamObserver<com.bron.grpc.availableMachines> responseObserver) {
      asyncUnimplementedUnaryCall(getFindNearByATMMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAuthenticateCardMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.bron.grpc.inputPin,
                com.bron.grpc.authenticationMessage>(
                  this, METHODID_AUTHENTICATE_CARD)))
          .addMethod(
            getFindNearByATMMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.bron.grpc.searchATM,
                com.bron.grpc.availableMachines>(
                  this, METHODID_FIND_NEAR_BY_ATM)))
          .build();
    }
  }

  /**
   */
  public static final class touchFreeATMStub extends io.grpc.stub.AbstractStub<touchFreeATMStub> {
    private touchFreeATMStub(io.grpc.Channel channel) {
      super(channel);
    }

    private touchFreeATMStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected touchFreeATMStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new touchFreeATMStub(channel, callOptions);
    }

    /**
     */
    public void authenticateCard(com.bron.grpc.inputPin request,
        io.grpc.stub.StreamObserver<com.bron.grpc.authenticationMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAuthenticateCardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findNearByATM(com.bron.grpc.searchATM request,
        io.grpc.stub.StreamObserver<com.bron.grpc.availableMachines> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getFindNearByATMMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class touchFreeATMBlockingStub extends io.grpc.stub.AbstractStub<touchFreeATMBlockingStub> {
    private touchFreeATMBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private touchFreeATMBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected touchFreeATMBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new touchFreeATMBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.bron.grpc.authenticationMessage authenticateCard(com.bron.grpc.inputPin request) {
      return blockingUnaryCall(
          getChannel(), getAuthenticateCardMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.bron.grpc.availableMachines> findNearByATM(
        com.bron.grpc.searchATM request) {
      return blockingServerStreamingCall(
          getChannel(), getFindNearByATMMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class touchFreeATMFutureStub extends io.grpc.stub.AbstractStub<touchFreeATMFutureStub> {
    private touchFreeATMFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private touchFreeATMFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected touchFreeATMFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new touchFreeATMFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.bron.grpc.authenticationMessage> authenticateCard(
        com.bron.grpc.inputPin request) {
      return futureUnaryCall(
          getChannel().newCall(getAuthenticateCardMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUTHENTICATE_CARD = 0;
  private static final int METHODID_FIND_NEAR_BY_ATM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final touchFreeATMImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(touchFreeATMImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTHENTICATE_CARD:
          serviceImpl.authenticateCard((com.bron.grpc.inputPin) request,
              (io.grpc.stub.StreamObserver<com.bron.grpc.authenticationMessage>) responseObserver);
          break;
        case METHODID_FIND_NEAR_BY_ATM:
          serviceImpl.findNearByATM((com.bron.grpc.searchATM) request,
              (io.grpc.stub.StreamObserver<com.bron.grpc.availableMachines>) responseObserver);
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

  private static abstract class touchFreeATMBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    touchFreeATMBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.bron.grpc.TouchFreeAtm.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("touchFreeATM");
    }
  }

  private static final class touchFreeATMFileDescriptorSupplier
      extends touchFreeATMBaseDescriptorSupplier {
    touchFreeATMFileDescriptorSupplier() {}
  }

  private static final class touchFreeATMMethodDescriptorSupplier
      extends touchFreeATMBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    touchFreeATMMethodDescriptorSupplier(String methodName) {
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
      synchronized (touchFreeATMGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new touchFreeATMFileDescriptorSupplier())
              .addMethod(getAuthenticateCardMethod())
              .addMethod(getFindNearByATMMethod())
              .build();
        }
      }
    }
    return result;
  }
}
