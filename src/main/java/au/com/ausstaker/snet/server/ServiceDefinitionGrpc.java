package au.com.ausstaker.snet.server;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: geo-me.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServiceDefinitionGrpc {

  private ServiceDefinitionGrpc() {}

  public static final String SERVICE_NAME = "ServiceDefinition";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<au.com.ausstaker.snet.server.GeoRequest,
      au.com.ausstaker.snet.server.GeolocationResult> getGeoFixMeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "geoFixMe",
      requestType = au.com.ausstaker.snet.server.GeoRequest.class,
      responseType = au.com.ausstaker.snet.server.GeolocationResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<au.com.ausstaker.snet.server.GeoRequest,
      au.com.ausstaker.snet.server.GeolocationResult> getGeoFixMeMethod() {
    io.grpc.MethodDescriptor<au.com.ausstaker.snet.server.GeoRequest, au.com.ausstaker.snet.server.GeolocationResult> getGeoFixMeMethod;
    if ((getGeoFixMeMethod = ServiceDefinitionGrpc.getGeoFixMeMethod) == null) {
      synchronized (ServiceDefinitionGrpc.class) {
        if ((getGeoFixMeMethod = ServiceDefinitionGrpc.getGeoFixMeMethod) == null) {
          ServiceDefinitionGrpc.getGeoFixMeMethod = getGeoFixMeMethod =
              io.grpc.MethodDescriptor.<au.com.ausstaker.snet.server.GeoRequest, au.com.ausstaker.snet.server.GeolocationResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "geoFixMe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  au.com.ausstaker.snet.server.GeoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  au.com.ausstaker.snet.server.GeolocationResult.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceDefinitionMethodDescriptorSupplier("geoFixMe"))
              .build();
        }
      }
    }
    return getGeoFixMeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceDefinitionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceDefinitionStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceDefinitionStub>() {
        @java.lang.Override
        public ServiceDefinitionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceDefinitionStub(channel, callOptions);
        }
      };
    return ServiceDefinitionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceDefinitionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceDefinitionBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceDefinitionBlockingStub>() {
        @java.lang.Override
        public ServiceDefinitionBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceDefinitionBlockingStub(channel, callOptions);
        }
      };
    return ServiceDefinitionBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceDefinitionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceDefinitionFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceDefinitionFutureStub>() {
        @java.lang.Override
        public ServiceDefinitionFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceDefinitionFutureStub(channel, callOptions);
        }
      };
    return ServiceDefinitionFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ServiceDefinitionImplBase implements io.grpc.BindableService {

    /**
     */
    public void geoFixMe(au.com.ausstaker.snet.server.GeoRequest request,
        io.grpc.stub.StreamObserver<au.com.ausstaker.snet.server.GeolocationResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGeoFixMeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGeoFixMeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                au.com.ausstaker.snet.server.GeoRequest,
                au.com.ausstaker.snet.server.GeolocationResult>(
                  this, METHODID_GEO_FIX_ME)))
          .build();
    }
  }

  /**
   */
  public static final class ServiceDefinitionStub extends io.grpc.stub.AbstractAsyncStub<ServiceDefinitionStub> {
    private ServiceDefinitionStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceDefinitionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceDefinitionStub(channel, callOptions);
    }

    /**
     */
    public void geoFixMe(au.com.ausstaker.snet.server.GeoRequest request,
        io.grpc.stub.StreamObserver<au.com.ausstaker.snet.server.GeolocationResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGeoFixMeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServiceDefinitionBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServiceDefinitionBlockingStub> {
    private ServiceDefinitionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceDefinitionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceDefinitionBlockingStub(channel, callOptions);
    }

    /**
     */
    public au.com.ausstaker.snet.server.GeolocationResult geoFixMe(au.com.ausstaker.snet.server.GeoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGeoFixMeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServiceDefinitionFutureStub extends io.grpc.stub.AbstractFutureStub<ServiceDefinitionFutureStub> {
    private ServiceDefinitionFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceDefinitionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceDefinitionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<au.com.ausstaker.snet.server.GeolocationResult> geoFixMe(
        au.com.ausstaker.snet.server.GeoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGeoFixMeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GEO_FIX_ME = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceDefinitionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceDefinitionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GEO_FIX_ME:
          serviceImpl.geoFixMe((au.com.ausstaker.snet.server.GeoRequest) request,
              (io.grpc.stub.StreamObserver<au.com.ausstaker.snet.server.GeolocationResult>) responseObserver);
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

  private static abstract class ServiceDefinitionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceDefinitionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return au.com.ausstaker.snet.server.GeoMe.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceDefinition");
    }
  }

  private static final class ServiceDefinitionFileDescriptorSupplier
      extends ServiceDefinitionBaseDescriptorSupplier {
    ServiceDefinitionFileDescriptorSupplier() {}
  }

  private static final class ServiceDefinitionMethodDescriptorSupplier
      extends ServiceDefinitionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceDefinitionMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServiceDefinitionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceDefinitionFileDescriptorSupplier())
              .addMethod(getGeoFixMeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
