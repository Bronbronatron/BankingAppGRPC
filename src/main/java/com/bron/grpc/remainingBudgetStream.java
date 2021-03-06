// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: budgetApp.proto

package com.bron.grpc;

/**
 * <pre>
 *it
 * </pre>
 *
 * Protobuf type {@code remainingBudgetStream}
 */
public  final class remainingBudgetStream extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:remainingBudgetStream)
    remainingBudgetStreamOrBuilder {
private static final long serialVersionUID = 0L;
  // Use remainingBudgetStream.newBuilder() to construct.
  private remainingBudgetStream(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private remainingBudgetStream() {
    budget_ = 0D;
    cat_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private remainingBudgetStream(
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
          case 9: {

            budget_ = input.readDouble();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            cat_ = s;
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
    return com.bron.grpc.BudgetApp.internal_static_remainingBudgetStream_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.bron.grpc.BudgetApp.internal_static_remainingBudgetStream_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.bron.grpc.remainingBudgetStream.class, com.bron.grpc.remainingBudgetStream.Builder.class);
  }

  public static final int BUDGET_FIELD_NUMBER = 1;
  private double budget_;
  /**
   * <code>double Budget = 1;</code>
   */
  public double getBudget() {
    return budget_;
  }

  public static final int CAT_FIELD_NUMBER = 2;
  private volatile java.lang.Object cat_;
  /**
   * <code>string Cat = 2;</code>
   */
  public java.lang.String getCat() {
    java.lang.Object ref = cat_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      cat_ = s;
      return s;
    }
  }
  /**
   * <code>string Cat = 2;</code>
   */
  public com.google.protobuf.ByteString
      getCatBytes() {
    java.lang.Object ref = cat_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      cat_ = b;
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
    if (budget_ != 0D) {
      output.writeDouble(1, budget_);
    }
    if (!getCatBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, cat_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (budget_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, budget_);
    }
    if (!getCatBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, cat_);
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
    if (!(obj instanceof com.bron.grpc.remainingBudgetStream)) {
      return super.equals(obj);
    }
    com.bron.grpc.remainingBudgetStream other = (com.bron.grpc.remainingBudgetStream) obj;

    boolean result = true;
    result = result && (
        java.lang.Double.doubleToLongBits(getBudget())
        == java.lang.Double.doubleToLongBits(
            other.getBudget()));
    result = result && getCat()
        .equals(other.getCat());
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
    hash = (37 * hash) + BUDGET_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getBudget()));
    hash = (37 * hash) + CAT_FIELD_NUMBER;
    hash = (53 * hash) + getCat().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.bron.grpc.remainingBudgetStream parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.bron.grpc.remainingBudgetStream parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.bron.grpc.remainingBudgetStream parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.bron.grpc.remainingBudgetStream parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.bron.grpc.remainingBudgetStream parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.bron.grpc.remainingBudgetStream parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.bron.grpc.remainingBudgetStream parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.bron.grpc.remainingBudgetStream parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.bron.grpc.remainingBudgetStream parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.bron.grpc.remainingBudgetStream parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.bron.grpc.remainingBudgetStream parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.bron.grpc.remainingBudgetStream parseFrom(
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
  public static Builder newBuilder(com.bron.grpc.remainingBudgetStream prototype) {
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
   *it
   * </pre>
   *
   * Protobuf type {@code remainingBudgetStream}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:remainingBudgetStream)
      com.bron.grpc.remainingBudgetStreamOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.bron.grpc.BudgetApp.internal_static_remainingBudgetStream_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.bron.grpc.BudgetApp.internal_static_remainingBudgetStream_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.bron.grpc.remainingBudgetStream.class, com.bron.grpc.remainingBudgetStream.Builder.class);
    }

    // Construct using com.bron.grpc.remainingBudgetStream.newBuilder()
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
      budget_ = 0D;

      cat_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.bron.grpc.BudgetApp.internal_static_remainingBudgetStream_descriptor;
    }

    @java.lang.Override
    public com.bron.grpc.remainingBudgetStream getDefaultInstanceForType() {
      return com.bron.grpc.remainingBudgetStream.getDefaultInstance();
    }

    @java.lang.Override
    public com.bron.grpc.remainingBudgetStream build() {
      com.bron.grpc.remainingBudgetStream result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.bron.grpc.remainingBudgetStream buildPartial() {
      com.bron.grpc.remainingBudgetStream result = new com.bron.grpc.remainingBudgetStream(this);
      result.budget_ = budget_;
      result.cat_ = cat_;
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
      if (other instanceof com.bron.grpc.remainingBudgetStream) {
        return mergeFrom((com.bron.grpc.remainingBudgetStream)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.bron.grpc.remainingBudgetStream other) {
      if (other == com.bron.grpc.remainingBudgetStream.getDefaultInstance()) return this;
      if (other.getBudget() != 0D) {
        setBudget(other.getBudget());
      }
      if (!other.getCat().isEmpty()) {
        cat_ = other.cat_;
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
      com.bron.grpc.remainingBudgetStream parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.bron.grpc.remainingBudgetStream) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private double budget_ ;
    /**
     * <code>double Budget = 1;</code>
     */
    public double getBudget() {
      return budget_;
    }
    /**
     * <code>double Budget = 1;</code>
     */
    public Builder setBudget(double value) {
      
      budget_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double Budget = 1;</code>
     */
    public Builder clearBudget() {
      
      budget_ = 0D;
      onChanged();
      return this;
    }

    private java.lang.Object cat_ = "";
    /**
     * <code>string Cat = 2;</code>
     */
    public java.lang.String getCat() {
      java.lang.Object ref = cat_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cat_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string Cat = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCatBytes() {
      java.lang.Object ref = cat_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        cat_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string Cat = 2;</code>
     */
    public Builder setCat(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      cat_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string Cat = 2;</code>
     */
    public Builder clearCat() {
      
      cat_ = getDefaultInstance().getCat();
      onChanged();
      return this;
    }
    /**
     * <code>string Cat = 2;</code>
     */
    public Builder setCatBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      cat_ = value;
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


    // @@protoc_insertion_point(builder_scope:remainingBudgetStream)
  }

  // @@protoc_insertion_point(class_scope:remainingBudgetStream)
  private static final com.bron.grpc.remainingBudgetStream DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.bron.grpc.remainingBudgetStream();
  }

  public static com.bron.grpc.remainingBudgetStream getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<remainingBudgetStream>
      PARSER = new com.google.protobuf.AbstractParser<remainingBudgetStream>() {
    @java.lang.Override
    public remainingBudgetStream parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new remainingBudgetStream(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<remainingBudgetStream> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<remainingBudgetStream> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.bron.grpc.remainingBudgetStream getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

