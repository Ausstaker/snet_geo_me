// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: geo-me.proto

package au.com.ausstaker.snet.server;

/**
 * Protobuf service {@code ServiceDefinition}
 */
public  abstract class ServiceDefinition
    implements com.google.protobuf.Service {
  protected ServiceDefinition() {}

  public interface Interface {
    /**
     * <code>rpc geoFixMe(.GeoRequest) returns (.GeolocationResult);</code>
     */
    public abstract void geoFixMe(
        com.google.protobuf.RpcController controller,
        au.com.ausstaker.snet.server.GeoRequest request,
        com.google.protobuf.RpcCallback<au.com.ausstaker.snet.server.GeolocationResult> done);

  }

  public static com.google.protobuf.Service newReflectiveService(
      final Interface impl) {
    return new ServiceDefinition() {
      @java.lang.Override
      public  void geoFixMe(
          com.google.protobuf.RpcController controller,
          au.com.ausstaker.snet.server.GeoRequest request,
          com.google.protobuf.RpcCallback<au.com.ausstaker.snet.server.GeolocationResult> done) {
        impl.geoFixMe(controller, request, done);
      }

    };
  }

  public static com.google.protobuf.BlockingService
      newReflectiveBlockingService(final BlockingInterface impl) {
    return new com.google.protobuf.BlockingService() {
      public final com.google.protobuf.Descriptors.ServiceDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }

      public final com.google.protobuf.Message callBlockingMethod(
          com.google.protobuf.Descriptors.MethodDescriptor method,
          com.google.protobuf.RpcController controller,
          com.google.protobuf.Message request)
          throws com.google.protobuf.ServiceException {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.callBlockingMethod() given method descriptor for " +
            "wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return impl.geoFixMe(controller, (au.com.ausstaker.snet.server.GeoRequest)request);
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

      public final com.google.protobuf.Message
          getRequestPrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getRequestPrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return au.com.ausstaker.snet.server.GeoRequest.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

      public final com.google.protobuf.Message
          getResponsePrototype(
          com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "Service.getResponsePrototype() given method " +
            "descriptor for wrong service type.");
        }
        switch(method.getIndex()) {
          case 0:
            return au.com.ausstaker.snet.server.GeolocationResult.getDefaultInstance();
          default:
            throw new java.lang.AssertionError("Can't get here.");
        }
      }

    };
  }

  /**
   * <code>rpc geoFixMe(.GeoRequest) returns (.GeolocationResult);</code>
   */
  public abstract void geoFixMe(
      com.google.protobuf.RpcController controller,
      au.com.ausstaker.snet.server.GeoRequest request,
      com.google.protobuf.RpcCallback<au.com.ausstaker.snet.server.GeolocationResult> done);

  public static final
      com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptor() {
    return au.com.ausstaker.snet.server.GeoMe.getDescriptor().getServices().get(0);
  }
  public final com.google.protobuf.Descriptors.ServiceDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }

  public final void callMethod(
      com.google.protobuf.Descriptors.MethodDescriptor method,
      com.google.protobuf.RpcController controller,
      com.google.protobuf.Message request,
      com.google.protobuf.RpcCallback<
        com.google.protobuf.Message> done) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.callMethod() given method descriptor for wrong " +
        "service type.");
    }
    switch(method.getIndex()) {
      case 0:
        this.geoFixMe(controller, (au.com.ausstaker.snet.server.GeoRequest)request,
          com.google.protobuf.RpcUtil.<au.com.ausstaker.snet.server.GeolocationResult>specializeCallback(
            done));
        return;
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public final com.google.protobuf.Message
      getRequestPrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getRequestPrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return au.com.ausstaker.snet.server.GeoRequest.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public final com.google.protobuf.Message
      getResponsePrototype(
      com.google.protobuf.Descriptors.MethodDescriptor method) {
    if (method.getService() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "Service.getResponsePrototype() given method " +
        "descriptor for wrong service type.");
    }
    switch(method.getIndex()) {
      case 0:
        return au.com.ausstaker.snet.server.GeolocationResult.getDefaultInstance();
      default:
        throw new java.lang.AssertionError("Can't get here.");
    }
  }

  public static Stub newStub(
      com.google.protobuf.RpcChannel channel) {
    return new Stub(channel);
  }

  public static final class Stub extends au.com.ausstaker.snet.server.ServiceDefinition implements Interface {
    private Stub(com.google.protobuf.RpcChannel channel) {
      this.channel = channel;
    }

    private final com.google.protobuf.RpcChannel channel;

    public com.google.protobuf.RpcChannel getChannel() {
      return channel;
    }

    public  void geoFixMe(
        com.google.protobuf.RpcController controller,
        au.com.ausstaker.snet.server.GeoRequest request,
        com.google.protobuf.RpcCallback<au.com.ausstaker.snet.server.GeolocationResult> done) {
      channel.callMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        au.com.ausstaker.snet.server.GeolocationResult.getDefaultInstance(),
        com.google.protobuf.RpcUtil.generalizeCallback(
          done,
          au.com.ausstaker.snet.server.GeolocationResult.class,
          au.com.ausstaker.snet.server.GeolocationResult.getDefaultInstance()));
    }
  }

  public static BlockingInterface newBlockingStub(
      com.google.protobuf.BlockingRpcChannel channel) {
    return new BlockingStub(channel);
  }

  public interface BlockingInterface {
    public au.com.ausstaker.snet.server.GeolocationResult geoFixMe(
        com.google.protobuf.RpcController controller,
        au.com.ausstaker.snet.server.GeoRequest request)
        throws com.google.protobuf.ServiceException;
  }

  private static final class BlockingStub implements BlockingInterface {
    private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
      this.channel = channel;
    }

    private final com.google.protobuf.BlockingRpcChannel channel;

    public au.com.ausstaker.snet.server.GeolocationResult geoFixMe(
        com.google.protobuf.RpcController controller,
        au.com.ausstaker.snet.server.GeoRequest request)
        throws com.google.protobuf.ServiceException {
      return (au.com.ausstaker.snet.server.GeolocationResult) channel.callBlockingMethod(
        getDescriptor().getMethods().get(0),
        controller,
        request,
        au.com.ausstaker.snet.server.GeolocationResult.getDefaultInstance());
    }

  }

  // @@protoc_insertion_point(class_scope:ServiceDefinition)
}
