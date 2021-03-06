// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: geo-me.proto

package au.com.ausstaker.snet.server;

/**
 * Protobuf type {@code GeolocationResult}
 */
public final class GeolocationResult extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GeolocationResult)
    GeolocationResultOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GeolocationResult.newBuilder() to construct.
  private GeolocationResult(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GeolocationResult() {
    kmlOutput_ = "";
    status_ = "";
    statusMessage_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GeolocationResult();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GeolocationResult(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 9: {

            residual_ = input.readDouble();
            break;
          }
          case 17: {

            residualRk_ = input.readDouble();
            break;
          }
          case 25: {

            lat_ = input.readDouble();
            break;
          }
          case 33: {

            lon_ = input.readDouble();
            break;
          }
          case 41: {

            elpLong_ = input.readDouble();
            break;
          }
          case 49: {

            elpShort_ = input.readDouble();
            break;
          }
          case 57: {

            elpRot_ = input.readDouble();
            break;
          }
          case 66: {
            java.lang.String s = input.readStringRequireUtf8();

            kmlOutput_ = s;
            break;
          }
          case 74: {
            java.lang.String s = input.readStringRequireUtf8();

            status_ = s;
            break;
          }
          case 82: {
            java.lang.String s = input.readStringRequireUtf8();

            statusMessage_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return au.com.ausstaker.snet.server.GeoMe.internal_static_GeolocationResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return au.com.ausstaker.snet.server.GeoMe.internal_static_GeolocationResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            au.com.ausstaker.snet.server.GeolocationResult.class, au.com.ausstaker.snet.server.GeolocationResult.Builder.class);
  }

  public static final int RESIDUAL_FIELD_NUMBER = 1;
  private double residual_;
  /**
   * <code>double residual = 1;</code>
   * @return The residual.
   */
  @java.lang.Override
  public double getResidual() {
    return residual_;
  }

  public static final int RESIDUAL_RK_FIELD_NUMBER = 2;
  private double residualRk_;
  /**
   * <code>double residual_rk = 2;</code>
   * @return The residualRk.
   */
  @java.lang.Override
  public double getResidualRk() {
    return residualRk_;
  }

  public static final int LAT_FIELD_NUMBER = 3;
  private double lat_;
  /**
   * <code>double lat = 3;</code>
   * @return The lat.
   */
  @java.lang.Override
  public double getLat() {
    return lat_;
  }

  public static final int LON_FIELD_NUMBER = 4;
  private double lon_;
  /**
   * <code>double lon = 4;</code>
   * @return The lon.
   */
  @java.lang.Override
  public double getLon() {
    return lon_;
  }

  public static final int ELP_LONG_FIELD_NUMBER = 5;
  private double elpLong_;
  /**
   * <code>double elp_long = 5;</code>
   * @return The elpLong.
   */
  @java.lang.Override
  public double getElpLong() {
    return elpLong_;
  }

  public static final int ELP_SHORT_FIELD_NUMBER = 6;
  private double elpShort_;
  /**
   * <code>double elp_short = 6;</code>
   * @return The elpShort.
   */
  @java.lang.Override
  public double getElpShort() {
    return elpShort_;
  }

  public static final int ELP_ROT_FIELD_NUMBER = 7;
  private double elpRot_;
  /**
   * <code>double elp_rot = 7;</code>
   * @return The elpRot.
   */
  @java.lang.Override
  public double getElpRot() {
    return elpRot_;
  }

  public static final int KML_OUTPUT_FIELD_NUMBER = 8;
  private volatile java.lang.Object kmlOutput_;
  /**
   * <code>string kml_output = 8;</code>
   * @return The kmlOutput.
   */
  @java.lang.Override
  public java.lang.String getKmlOutput() {
    java.lang.Object ref = kmlOutput_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      kmlOutput_ = s;
      return s;
    }
  }
  /**
   * <code>string kml_output = 8;</code>
   * @return The bytes for kmlOutput.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getKmlOutputBytes() {
    java.lang.Object ref = kmlOutput_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      kmlOutput_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STATUS_FIELD_NUMBER = 9;
  private volatile java.lang.Object status_;
  /**
   * <code>string status = 9;</code>
   * @return The status.
   */
  @java.lang.Override
  public java.lang.String getStatus() {
    java.lang.Object ref = status_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      status_ = s;
      return s;
    }
  }
  /**
   * <code>string status = 9;</code>
   * @return The bytes for status.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getStatusBytes() {
    java.lang.Object ref = status_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      status_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STATUSMESSAGE_FIELD_NUMBER = 10;
  private volatile java.lang.Object statusMessage_;
  /**
   * <code>string statusMessage = 10;</code>
   * @return The statusMessage.
   */
  @java.lang.Override
  public java.lang.String getStatusMessage() {
    java.lang.Object ref = statusMessage_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      statusMessage_ = s;
      return s;
    }
  }
  /**
   * <code>string statusMessage = 10;</code>
   * @return The bytes for statusMessage.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getStatusMessageBytes() {
    java.lang.Object ref = statusMessage_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      statusMessage_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (java.lang.Double.doubleToRawLongBits(residual_) != 0) {
      output.writeDouble(1, residual_);
    }
    if (java.lang.Double.doubleToRawLongBits(residualRk_) != 0) {
      output.writeDouble(2, residualRk_);
    }
    if (java.lang.Double.doubleToRawLongBits(lat_) != 0) {
      output.writeDouble(3, lat_);
    }
    if (java.lang.Double.doubleToRawLongBits(lon_) != 0) {
      output.writeDouble(4, lon_);
    }
    if (java.lang.Double.doubleToRawLongBits(elpLong_) != 0) {
      output.writeDouble(5, elpLong_);
    }
    if (java.lang.Double.doubleToRawLongBits(elpShort_) != 0) {
      output.writeDouble(6, elpShort_);
    }
    if (java.lang.Double.doubleToRawLongBits(elpRot_) != 0) {
      output.writeDouble(7, elpRot_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(kmlOutput_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 8, kmlOutput_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(status_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 9, status_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(statusMessage_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 10, statusMessage_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (java.lang.Double.doubleToRawLongBits(residual_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, residual_);
    }
    if (java.lang.Double.doubleToRawLongBits(residualRk_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, residualRk_);
    }
    if (java.lang.Double.doubleToRawLongBits(lat_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, lat_);
    }
    if (java.lang.Double.doubleToRawLongBits(lon_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(4, lon_);
    }
    if (java.lang.Double.doubleToRawLongBits(elpLong_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(5, elpLong_);
    }
    if (java.lang.Double.doubleToRawLongBits(elpShort_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(6, elpShort_);
    }
    if (java.lang.Double.doubleToRawLongBits(elpRot_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(7, elpRot_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(kmlOutput_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, kmlOutput_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(status_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, status_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(statusMessage_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, statusMessage_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof au.com.ausstaker.snet.server.GeolocationResult)) {
      return super.equals(obj);
    }
    au.com.ausstaker.snet.server.GeolocationResult other = (au.com.ausstaker.snet.server.GeolocationResult) obj;

    if (java.lang.Double.doubleToLongBits(getResidual())
        != java.lang.Double.doubleToLongBits(
            other.getResidual())) return false;
    if (java.lang.Double.doubleToLongBits(getResidualRk())
        != java.lang.Double.doubleToLongBits(
            other.getResidualRk())) return false;
    if (java.lang.Double.doubleToLongBits(getLat())
        != java.lang.Double.doubleToLongBits(
            other.getLat())) return false;
    if (java.lang.Double.doubleToLongBits(getLon())
        != java.lang.Double.doubleToLongBits(
            other.getLon())) return false;
    if (java.lang.Double.doubleToLongBits(getElpLong())
        != java.lang.Double.doubleToLongBits(
            other.getElpLong())) return false;
    if (java.lang.Double.doubleToLongBits(getElpShort())
        != java.lang.Double.doubleToLongBits(
            other.getElpShort())) return false;
    if (java.lang.Double.doubleToLongBits(getElpRot())
        != java.lang.Double.doubleToLongBits(
            other.getElpRot())) return false;
    if (!getKmlOutput()
        .equals(other.getKmlOutput())) return false;
    if (!getStatus()
        .equals(other.getStatus())) return false;
    if (!getStatusMessage()
        .equals(other.getStatusMessage())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + RESIDUAL_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getResidual()));
    hash = (37 * hash) + RESIDUAL_RK_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getResidualRk()));
    hash = (37 * hash) + LAT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getLat()));
    hash = (37 * hash) + LON_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getLon()));
    hash = (37 * hash) + ELP_LONG_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getElpLong()));
    hash = (37 * hash) + ELP_SHORT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getElpShort()));
    hash = (37 * hash) + ELP_ROT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getElpRot()));
    hash = (37 * hash) + KML_OUTPUT_FIELD_NUMBER;
    hash = (53 * hash) + getKmlOutput().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + getStatus().hashCode();
    hash = (37 * hash) + STATUSMESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getStatusMessage().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static au.com.ausstaker.snet.server.GeolocationResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static au.com.ausstaker.snet.server.GeolocationResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static au.com.ausstaker.snet.server.GeolocationResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static au.com.ausstaker.snet.server.GeolocationResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static au.com.ausstaker.snet.server.GeolocationResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static au.com.ausstaker.snet.server.GeolocationResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static au.com.ausstaker.snet.server.GeolocationResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static au.com.ausstaker.snet.server.GeolocationResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static au.com.ausstaker.snet.server.GeolocationResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static au.com.ausstaker.snet.server.GeolocationResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static au.com.ausstaker.snet.server.GeolocationResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static au.com.ausstaker.snet.server.GeolocationResult parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(au.com.ausstaker.snet.server.GeolocationResult prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code GeolocationResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GeolocationResult)
      au.com.ausstaker.snet.server.GeolocationResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return au.com.ausstaker.snet.server.GeoMe.internal_static_GeolocationResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return au.com.ausstaker.snet.server.GeoMe.internal_static_GeolocationResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              au.com.ausstaker.snet.server.GeolocationResult.class, au.com.ausstaker.snet.server.GeolocationResult.Builder.class);
    }

    // Construct using au.com.ausstaker.snet.server.GeolocationResult.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      residual_ = 0D;

      residualRk_ = 0D;

      lat_ = 0D;

      lon_ = 0D;

      elpLong_ = 0D;

      elpShort_ = 0D;

      elpRot_ = 0D;

      kmlOutput_ = "";

      status_ = "";

      statusMessage_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return au.com.ausstaker.snet.server.GeoMe.internal_static_GeolocationResult_descriptor;
    }

    @java.lang.Override
    public au.com.ausstaker.snet.server.GeolocationResult getDefaultInstanceForType() {
      return au.com.ausstaker.snet.server.GeolocationResult.getDefaultInstance();
    }

    @java.lang.Override
    public au.com.ausstaker.snet.server.GeolocationResult build() {
      au.com.ausstaker.snet.server.GeolocationResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public au.com.ausstaker.snet.server.GeolocationResult buildPartial() {
      au.com.ausstaker.snet.server.GeolocationResult result = new au.com.ausstaker.snet.server.GeolocationResult(this);
      result.residual_ = residual_;
      result.residualRk_ = residualRk_;
      result.lat_ = lat_;
      result.lon_ = lon_;
      result.elpLong_ = elpLong_;
      result.elpShort_ = elpShort_;
      result.elpRot_ = elpRot_;
      result.kmlOutput_ = kmlOutput_;
      result.status_ = status_;
      result.statusMessage_ = statusMessage_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof au.com.ausstaker.snet.server.GeolocationResult) {
        return mergeFrom((au.com.ausstaker.snet.server.GeolocationResult)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(au.com.ausstaker.snet.server.GeolocationResult other) {
      if (other == au.com.ausstaker.snet.server.GeolocationResult.getDefaultInstance()) return this;
      if (other.getResidual() != 0D) {
        setResidual(other.getResidual());
      }
      if (other.getResidualRk() != 0D) {
        setResidualRk(other.getResidualRk());
      }
      if (other.getLat() != 0D) {
        setLat(other.getLat());
      }
      if (other.getLon() != 0D) {
        setLon(other.getLon());
      }
      if (other.getElpLong() != 0D) {
        setElpLong(other.getElpLong());
      }
      if (other.getElpShort() != 0D) {
        setElpShort(other.getElpShort());
      }
      if (other.getElpRot() != 0D) {
        setElpRot(other.getElpRot());
      }
      if (!other.getKmlOutput().isEmpty()) {
        kmlOutput_ = other.kmlOutput_;
        onChanged();
      }
      if (!other.getStatus().isEmpty()) {
        status_ = other.status_;
        onChanged();
      }
      if (!other.getStatusMessage().isEmpty()) {
        statusMessage_ = other.statusMessage_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      au.com.ausstaker.snet.server.GeolocationResult parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (au.com.ausstaker.snet.server.GeolocationResult) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private double residual_ ;
    /**
     * <code>double residual = 1;</code>
     * @return The residual.
     */
    @java.lang.Override
    public double getResidual() {
      return residual_;
    }
    /**
     * <code>double residual = 1;</code>
     * @param value The residual to set.
     * @return This builder for chaining.
     */
    public Builder setResidual(double value) {
      
      residual_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double residual = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearResidual() {
      
      residual_ = 0D;
      onChanged();
      return this;
    }

    private double residualRk_ ;
    /**
     * <code>double residual_rk = 2;</code>
     * @return The residualRk.
     */
    @java.lang.Override
    public double getResidualRk() {
      return residualRk_;
    }
    /**
     * <code>double residual_rk = 2;</code>
     * @param value The residualRk to set.
     * @return This builder for chaining.
     */
    public Builder setResidualRk(double value) {
      
      residualRk_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double residual_rk = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearResidualRk() {
      
      residualRk_ = 0D;
      onChanged();
      return this;
    }

    private double lat_ ;
    /**
     * <code>double lat = 3;</code>
     * @return The lat.
     */
    @java.lang.Override
    public double getLat() {
      return lat_;
    }
    /**
     * <code>double lat = 3;</code>
     * @param value The lat to set.
     * @return This builder for chaining.
     */
    public Builder setLat(double value) {
      
      lat_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double lat = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearLat() {
      
      lat_ = 0D;
      onChanged();
      return this;
    }

    private double lon_ ;
    /**
     * <code>double lon = 4;</code>
     * @return The lon.
     */
    @java.lang.Override
    public double getLon() {
      return lon_;
    }
    /**
     * <code>double lon = 4;</code>
     * @param value The lon to set.
     * @return This builder for chaining.
     */
    public Builder setLon(double value) {
      
      lon_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double lon = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearLon() {
      
      lon_ = 0D;
      onChanged();
      return this;
    }

    private double elpLong_ ;
    /**
     * <code>double elp_long = 5;</code>
     * @return The elpLong.
     */
    @java.lang.Override
    public double getElpLong() {
      return elpLong_;
    }
    /**
     * <code>double elp_long = 5;</code>
     * @param value The elpLong to set.
     * @return This builder for chaining.
     */
    public Builder setElpLong(double value) {
      
      elpLong_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double elp_long = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearElpLong() {
      
      elpLong_ = 0D;
      onChanged();
      return this;
    }

    private double elpShort_ ;
    /**
     * <code>double elp_short = 6;</code>
     * @return The elpShort.
     */
    @java.lang.Override
    public double getElpShort() {
      return elpShort_;
    }
    /**
     * <code>double elp_short = 6;</code>
     * @param value The elpShort to set.
     * @return This builder for chaining.
     */
    public Builder setElpShort(double value) {
      
      elpShort_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double elp_short = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearElpShort() {
      
      elpShort_ = 0D;
      onChanged();
      return this;
    }

    private double elpRot_ ;
    /**
     * <code>double elp_rot = 7;</code>
     * @return The elpRot.
     */
    @java.lang.Override
    public double getElpRot() {
      return elpRot_;
    }
    /**
     * <code>double elp_rot = 7;</code>
     * @param value The elpRot to set.
     * @return This builder for chaining.
     */
    public Builder setElpRot(double value) {
      
      elpRot_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double elp_rot = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearElpRot() {
      
      elpRot_ = 0D;
      onChanged();
      return this;
    }

    private java.lang.Object kmlOutput_ = "";
    /**
     * <code>string kml_output = 8;</code>
     * @return The kmlOutput.
     */
    public java.lang.String getKmlOutput() {
      java.lang.Object ref = kmlOutput_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        kmlOutput_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string kml_output = 8;</code>
     * @return The bytes for kmlOutput.
     */
    public com.google.protobuf.ByteString
        getKmlOutputBytes() {
      java.lang.Object ref = kmlOutput_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        kmlOutput_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string kml_output = 8;</code>
     * @param value The kmlOutput to set.
     * @return This builder for chaining.
     */
    public Builder setKmlOutput(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      kmlOutput_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string kml_output = 8;</code>
     * @return This builder for chaining.
     */
    public Builder clearKmlOutput() {
      
      kmlOutput_ = getDefaultInstance().getKmlOutput();
      onChanged();
      return this;
    }
    /**
     * <code>string kml_output = 8;</code>
     * @param value The bytes for kmlOutput to set.
     * @return This builder for chaining.
     */
    public Builder setKmlOutputBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      kmlOutput_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object status_ = "";
    /**
     * <code>string status = 9;</code>
     * @return The status.
     */
    public java.lang.String getStatus() {
      java.lang.Object ref = status_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        status_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string status = 9;</code>
     * @return The bytes for status.
     */
    public com.google.protobuf.ByteString
        getStatusBytes() {
      java.lang.Object ref = status_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        status_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string status = 9;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string status = 9;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      
      status_ = getDefaultInstance().getStatus();
      onChanged();
      return this;
    }
    /**
     * <code>string status = 9;</code>
     * @param value The bytes for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      status_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object statusMessage_ = "";
    /**
     * <code>string statusMessage = 10;</code>
     * @return The statusMessage.
     */
    public java.lang.String getStatusMessage() {
      java.lang.Object ref = statusMessage_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        statusMessage_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string statusMessage = 10;</code>
     * @return The bytes for statusMessage.
     */
    public com.google.protobuf.ByteString
        getStatusMessageBytes() {
      java.lang.Object ref = statusMessage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        statusMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string statusMessage = 10;</code>
     * @param value The statusMessage to set.
     * @return This builder for chaining.
     */
    public Builder setStatusMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      statusMessage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string statusMessage = 10;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatusMessage() {
      
      statusMessage_ = getDefaultInstance().getStatusMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string statusMessage = 10;</code>
     * @param value The bytes for statusMessage to set.
     * @return This builder for chaining.
     */
    public Builder setStatusMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      statusMessage_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:GeolocationResult)
  }

  // @@protoc_insertion_point(class_scope:GeolocationResult)
  private static final au.com.ausstaker.snet.server.GeolocationResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new au.com.ausstaker.snet.server.GeolocationResult();
  }

  public static au.com.ausstaker.snet.server.GeolocationResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GeolocationResult>
      PARSER = new com.google.protobuf.AbstractParser<GeolocationResult>() {
    @java.lang.Override
    public GeolocationResult parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GeolocationResult(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GeolocationResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GeolocationResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public au.com.ausstaker.snet.server.GeolocationResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

