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
    comments = "Source: budgetApp.proto")
public final class BudgetGrpc {

  private BudgetGrpc() {}

  public static final String SERVICE_NAME = "Budget";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.bron.grpc.moneySpent,
      com.bron.grpc.lowBudgetAlert> getGetBudgetWarningMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getBudgetWarning",
      requestType = com.bron.grpc.moneySpent.class,
      responseType = com.bron.grpc.lowBudgetAlert.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.bron.grpc.moneySpent,
      com.bron.grpc.lowBudgetAlert> getGetBudgetWarningMethod() {
    io.grpc.MethodDescriptor<com.bron.grpc.moneySpent, com.bron.grpc.lowBudgetAlert> getGetBudgetWarningMethod;
    if ((getGetBudgetWarningMethod = BudgetGrpc.getGetBudgetWarningMethod) == null) {
      synchronized (BudgetGrpc.class) {
        if ((getGetBudgetWarningMethod = BudgetGrpc.getGetBudgetWarningMethod) == null) {
          BudgetGrpc.getGetBudgetWarningMethod = getGetBudgetWarningMethod = 
              io.grpc.MethodDescriptor.<com.bron.grpc.moneySpent, com.bron.grpc.lowBudgetAlert>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Budget", "getBudgetWarning"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bron.grpc.moneySpent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bron.grpc.lowBudgetAlert.getDefaultInstance()))
                  .setSchemaDescriptor(new BudgetMethodDescriptorSupplier("getBudgetWarning"))
                  .build();
          }
        }
     }
     return getGetBudgetWarningMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bron.grpc.requestRemainingbudget,
      com.bron.grpc.remainingBudgetStream> getGetRemainingBudgetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRemainingBudget",
      requestType = com.bron.grpc.requestRemainingbudget.class,
      responseType = com.bron.grpc.remainingBudgetStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.bron.grpc.requestRemainingbudget,
      com.bron.grpc.remainingBudgetStream> getGetRemainingBudgetMethod() {
    io.grpc.MethodDescriptor<com.bron.grpc.requestRemainingbudget, com.bron.grpc.remainingBudgetStream> getGetRemainingBudgetMethod;
    if ((getGetRemainingBudgetMethod = BudgetGrpc.getGetRemainingBudgetMethod) == null) {
      synchronized (BudgetGrpc.class) {
        if ((getGetRemainingBudgetMethod = BudgetGrpc.getGetRemainingBudgetMethod) == null) {
          BudgetGrpc.getGetRemainingBudgetMethod = getGetRemainingBudgetMethod = 
              io.grpc.MethodDescriptor.<com.bron.grpc.requestRemainingbudget, com.bron.grpc.remainingBudgetStream>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Budget", "getRemainingBudget"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bron.grpc.requestRemainingbudget.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bron.grpc.remainingBudgetStream.getDefaultInstance()))
                  .setSchemaDescriptor(new BudgetMethodDescriptorSupplier("getRemainingBudget"))
                  .build();
          }
        }
     }
     return getGetRemainingBudgetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bron.grpc.updatedBudget,
      com.bron.grpc.updatedBudgetConfirmation> getUpdateBugdetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateBugdet",
      requestType = com.bron.grpc.updatedBudget.class,
      responseType = com.bron.grpc.updatedBudgetConfirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.bron.grpc.updatedBudget,
      com.bron.grpc.updatedBudgetConfirmation> getUpdateBugdetMethod() {
    io.grpc.MethodDescriptor<com.bron.grpc.updatedBudget, com.bron.grpc.updatedBudgetConfirmation> getUpdateBugdetMethod;
    if ((getUpdateBugdetMethod = BudgetGrpc.getUpdateBugdetMethod) == null) {
      synchronized (BudgetGrpc.class) {
        if ((getUpdateBugdetMethod = BudgetGrpc.getUpdateBugdetMethod) == null) {
          BudgetGrpc.getUpdateBugdetMethod = getUpdateBugdetMethod = 
              io.grpc.MethodDescriptor.<com.bron.grpc.updatedBudget, com.bron.grpc.updatedBudgetConfirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Budget", "updateBugdet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bron.grpc.updatedBudget.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bron.grpc.updatedBudgetConfirmation.getDefaultInstance()))
                  .setSchemaDescriptor(new BudgetMethodDescriptorSupplier("updateBugdet"))
                  .build();
          }
        }
     }
     return getUpdateBugdetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bron.grpc.setBudget,
      com.bron.grpc.setBudget> getSetBudgetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetBudget",
      requestType = com.bron.grpc.setBudget.class,
      responseType = com.bron.grpc.setBudget.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.bron.grpc.setBudget,
      com.bron.grpc.setBudget> getSetBudgetMethod() {
    io.grpc.MethodDescriptor<com.bron.grpc.setBudget, com.bron.grpc.setBudget> getSetBudgetMethod;
    if ((getSetBudgetMethod = BudgetGrpc.getSetBudgetMethod) == null) {
      synchronized (BudgetGrpc.class) {
        if ((getSetBudgetMethod = BudgetGrpc.getSetBudgetMethod) == null) {
          BudgetGrpc.getSetBudgetMethod = getSetBudgetMethod = 
              io.grpc.MethodDescriptor.<com.bron.grpc.setBudget, com.bron.grpc.setBudget>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Budget", "SetBudget"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bron.grpc.setBudget.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bron.grpc.setBudget.getDefaultInstance()))
                  .setSchemaDescriptor(new BudgetMethodDescriptorSupplier("SetBudget"))
                  .build();
          }
        }
     }
     return getSetBudgetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BudgetStub newStub(io.grpc.Channel channel) {
    return new BudgetStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BudgetBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BudgetBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BudgetFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BudgetFutureStub(channel);
  }

  /**
   */
  public static abstract class BudgetImplBase implements io.grpc.BindableService {

    /**
     */
    public void getBudgetWarning(com.bron.grpc.moneySpent request,
        io.grpc.stub.StreamObserver<com.bron.grpc.lowBudgetAlert> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBudgetWarningMethod(), responseObserver);
    }

    /**
     */
    public void getRemainingBudget(com.bron.grpc.requestRemainingbudget request,
        io.grpc.stub.StreamObserver<com.bron.grpc.remainingBudgetStream> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRemainingBudgetMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.bron.grpc.updatedBudget> updateBugdet(
        io.grpc.stub.StreamObserver<com.bron.grpc.updatedBudgetConfirmation> responseObserver) {
      return asyncUnimplementedStreamingCall(getUpdateBugdetMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.bron.grpc.setBudget> setBudget(
        io.grpc.stub.StreamObserver<com.bron.grpc.setBudget> responseObserver) {
      return asyncUnimplementedStreamingCall(getSetBudgetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetBudgetWarningMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.bron.grpc.moneySpent,
                com.bron.grpc.lowBudgetAlert>(
                  this, METHODID_GET_BUDGET_WARNING)))
          .addMethod(
            getGetRemainingBudgetMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.bron.grpc.requestRemainingbudget,
                com.bron.grpc.remainingBudgetStream>(
                  this, METHODID_GET_REMAINING_BUDGET)))
          .addMethod(
            getUpdateBugdetMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.bron.grpc.updatedBudget,
                com.bron.grpc.updatedBudgetConfirmation>(
                  this, METHODID_UPDATE_BUGDET)))
          .addMethod(
            getSetBudgetMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.bron.grpc.setBudget,
                com.bron.grpc.setBudget>(
                  this, METHODID_SET_BUDGET)))
          .build();
    }
  }

  /**
   */
  public static final class BudgetStub extends io.grpc.stub.AbstractStub<BudgetStub> {
    private BudgetStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BudgetStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BudgetStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BudgetStub(channel, callOptions);
    }

    /**
     */
    public void getBudgetWarning(com.bron.grpc.moneySpent request,
        io.grpc.stub.StreamObserver<com.bron.grpc.lowBudgetAlert> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBudgetWarningMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRemainingBudget(com.bron.grpc.requestRemainingbudget request,
        io.grpc.stub.StreamObserver<com.bron.grpc.remainingBudgetStream> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetRemainingBudgetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.bron.grpc.updatedBudget> updateBugdet(
        io.grpc.stub.StreamObserver<com.bron.grpc.updatedBudgetConfirmation> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getUpdateBugdetMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.bron.grpc.setBudget> setBudget(
        io.grpc.stub.StreamObserver<com.bron.grpc.setBudget> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSetBudgetMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class BudgetBlockingStub extends io.grpc.stub.AbstractStub<BudgetBlockingStub> {
    private BudgetBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BudgetBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BudgetBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BudgetBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.bron.grpc.lowBudgetAlert getBudgetWarning(com.bron.grpc.moneySpent request) {
      return blockingUnaryCall(
          getChannel(), getGetBudgetWarningMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.bron.grpc.remainingBudgetStream> getRemainingBudget(
        com.bron.grpc.requestRemainingbudget request) {
      return blockingServerStreamingCall(
          getChannel(), getGetRemainingBudgetMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BudgetFutureStub extends io.grpc.stub.AbstractStub<BudgetFutureStub> {
    private BudgetFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BudgetFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BudgetFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BudgetFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.bron.grpc.lowBudgetAlert> getBudgetWarning(
        com.bron.grpc.moneySpent request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBudgetWarningMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BUDGET_WARNING = 0;
  private static final int METHODID_GET_REMAINING_BUDGET = 1;
  private static final int METHODID_UPDATE_BUGDET = 2;
  private static final int METHODID_SET_BUDGET = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BudgetImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BudgetImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BUDGET_WARNING:
          serviceImpl.getBudgetWarning((com.bron.grpc.moneySpent) request,
              (io.grpc.stub.StreamObserver<com.bron.grpc.lowBudgetAlert>) responseObserver);
          break;
        case METHODID_GET_REMAINING_BUDGET:
          serviceImpl.getRemainingBudget((com.bron.grpc.requestRemainingbudget) request,
              (io.grpc.stub.StreamObserver<com.bron.grpc.remainingBudgetStream>) responseObserver);
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
        case METHODID_UPDATE_BUGDET:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.updateBugdet(
              (io.grpc.stub.StreamObserver<com.bron.grpc.updatedBudgetConfirmation>) responseObserver);
        case METHODID_SET_BUDGET:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.setBudget(
              (io.grpc.stub.StreamObserver<com.bron.grpc.setBudget>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BudgetBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BudgetBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.bron.grpc.BudgetApp.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Budget");
    }
  }

  private static final class BudgetFileDescriptorSupplier
      extends BudgetBaseDescriptorSupplier {
    BudgetFileDescriptorSupplier() {}
  }

  private static final class BudgetMethodDescriptorSupplier
      extends BudgetBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BudgetMethodDescriptorSupplier(String methodName) {
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
      synchronized (BudgetGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BudgetFileDescriptorSupplier())
              .addMethod(getGetBudgetWarningMethod())
              .addMethod(getGetRemainingBudgetMethod())
              .addMethod(getUpdateBugdetMethod())
              .addMethod(getSetBudgetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
