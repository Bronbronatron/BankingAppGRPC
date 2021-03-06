// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: budgetApp.proto

package com.bron.grpc;

/**
 * <pre>
 *rpc 1: getBudgetWarning
 * </pre>
 *
 * Protobuf type {@code moneySpent}
 */
public  final class moneySpent extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:moneySpent)
    moneySpentOrBuilder {
private static final long serialVersionUID = 0L;
  // Use moneySpent.newBuilder() to construct.
  private moneySpent(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private moneySpent() {
    catagoryName_ = "";
    cost_ = 0D;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private moneySpent(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            catagoryName_ = s;
            break;
          }
          case 17: {

            cost_ = input.readDouble();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
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
    return com.bron.grpc.BudgetApp.internal_static_moneySpent_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.bron.grpc.BudgetApp.internal_static_moneySpent_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.bron.grpc.moneySpent.class, com.bron.grpc.moneySpent.Builder.class);
  }

  public static final int CATAGORYNAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object catagoryName_;
  /**
   * <code>string catagoryName = 1;</code>
   */
  public java.lang.String getCatagoryName() {
    java.lang.Object ref = catagoryName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      catagoryName_ = s;
      return s;
    }
  }
  /**
   * <code>string catagoryName = 1;</code>
   */
  public com.google.protobuf.ByteString
      getCatagoryNameBytes() {
    java.lang.Object ref = catagoryName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      catagoryName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int COST_FIELD_NUMBER = 2;
  private double cost_;
  /**
   * <code>double cost = 2;</code>
   */
  public double getCost() {
    return cost_;
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
    if (!getCatagoryNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, catagoryName_);
    }
    if (cost_ != 0D) {
      output.writeDouble(2, cost_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getCatagoryNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, catagoryName_);
    }
    if (cost_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, cost_);
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
    if (!(obj instanceof com.bron.grpc.moneySpent)) {
      return super.equals(obj);
    }
    com.bron.grpc.moneySpent other = (com.bron.grpc.moneySpent) obj;

    boolean result = true;
    result = result && getCatagoryName()
        .equals(other.getCatagoryName());
    result = result && (
        java.lang.Double.doubleToLongBits(getCost())
        == java.lang.Double.doubleToLongBits(
            other.getCost()));
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CATAGORYNAME_FIELD_NUMBER;
    hash = (53 * hash) + getCatagoryName().hashCode();
    hash = (37 * hash) + COST_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getCost()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.bron.grpc.moneySpent parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.bron.grpc.moneySpent parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.bron.grpc.moneySpent parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.bron.grpc.moneySpent parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.bron.grpc.moneySpent parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.bron.grpc.moneySpent parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.bron.grpc.moneySpent parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.bron.grpc.moneySpent parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.bron.grpc.moneySpent parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.bron.grpc.moneySpent parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.bron.grpc.moneySpent parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.bron.grpc.moneySpent parseFrom(
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
  public static Builder newBuilder(com.bron.grpc.moneySpent prototype) {
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
   * <pre>
   *rpc 1: getBudgetWarning
   * </pre>
   *
   * Protobuf type {@code moneySpent}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:moneySpent)
      com.bron.grpc.moneySpentOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.bron.grpc.BudgetApp.internal_static_moneySpent_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.bron.grpc.BudgetApp.internal_static_moneySpent_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.bron.grpc.moneySpent.class, com.bron.grpc.moneySpent.Builder.class);
    }

    // Construct using com.bron.grpc.moneySpent.newBuilder()
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
      catagoryName_ = "";

      cost_ = 0D;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.bron.grpc.BudgetApp.internal_static_moneySpent_descriptor;
    }

    @java.lang.Override
    public com.bron.grpc.moneySpent getDefaultInstanceForType() {
      return com.bron.grpc.moneySpent.getDefaultInstance();
    }

    @java.lang.Override
    public com.bron.grpc.moneySpent build() {
      com.bron.grpc.moneySpent result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.bron.grpc.moneySpent buildPartial() {
      com.bron.grpc.moneySpent result = new com.bron.grpc.moneySpent(this);
      result.catagoryName_ = catagoryName_;
      result.cost_ = cost_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.bron.grpc.moneySpent) {
        return mergeFrom((com.bron.grpc.moneySpent)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.bron.grpc.moneySpent other) {
      if (other == com.bron.grpc.moneySpent.getDefaultInstance()) return this;
      if (!other.getCatagoryName().isEmpty()) {
        catagoryName_ = other.catagoryName_;
        onChanged();
      }
      if (other.getCost() != 0D) {
        setCost(other.getCost());
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
      com.bron.grpc.moneySpent parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.bron.grpc.moneySpent) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object catagoryName_ = "";
    /**
     * <code>string catagoryName = 1;</code>
     */
    public java.lang.String getCatagoryName() {
      java.lang.Object ref = catagoryName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        catagoryName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string catagoryName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getCatagoryNameBytes() {
      java.lang.Object ref = catagoryName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        catagoryName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string catagoryName = 1;</code>
     */
    public Builder setCatagoryName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      catagoryName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string catagoryName = 1;</code>
     */
    public Builder clearCatagoryName() {
      
      catagoryName_ = getDefaultInstance().getCatagoryName();
      onChanged();
      return this;
    }
    /**
     * <code>string catagoryName = 1;</code>
     */
    public Builder setCatagoryNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      catagoryName_ = value;
      onChanged();
      return this;
    }

    private double cost_ ;
    /**
     * <code>double cost = 2;</code>
     */
    public double getCost() {
      return cost_;
    }
    /**
     * <code>double cost = 2;</code>
     */
    public Builder setCost(double value) {
      
      cost_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double cost = 2;</code>
     */
    public Builder clearCost() {
      
      cost_ = 0D;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:moneySpent)
  }

  // @@protoc_insertion_point(class_scope:moneySpent)
  private static final com.bron.grpc.moneySpent DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.bron.grpc.moneySpent();
  }

  public static com.bron.grpc.moneySpent getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<moneySpent>
      PARSER = new com.google.protobuf.AbstractParser<moneySpent>() {
    @java.lang.Override
    public moneySpent parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new moneySpent(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<moneySpent> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<moneySpent> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.bron.grpc.moneySpent getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

