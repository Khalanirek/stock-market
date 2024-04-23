/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.khalanirek.stockmarket.avro.order;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class OrderSubmittedEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5027172378753695550L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OrderSubmittedEvent\",\"namespace\":\"com.khalanirek.stockmarket.avro.order\",\"fields\":[{\"name\":\"orderId\",\"type\":\"string\"},{\"name\":\"investorId\",\"type\":\"string\"},{\"name\":\"orderType\",\"type\":\"string\"},{\"name\":\"share\",\"type\":{\"type\":\"record\",\"name\":\"Share\",\"fields\":[{\"name\":\"companyId\",\"type\":\"string\"},{\"name\":\"quantity\",\"type\":\"long\"},{\"name\":\"price\",\"type\":\"string\"}]}},{\"name\":\"expirationTime\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<OrderSubmittedEvent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OrderSubmittedEvent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<OrderSubmittedEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<OrderSubmittedEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<OrderSubmittedEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this OrderSubmittedEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a OrderSubmittedEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a OrderSubmittedEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static OrderSubmittedEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence orderId;
  private java.lang.CharSequence investorId;
  private java.lang.CharSequence orderType;
  private com.khalanirek.stockmarket.avro.order.Share share;
  private java.lang.CharSequence expirationTime;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OrderSubmittedEvent() {}

  /**
   * All-args constructor.
   * @param orderId The new value for orderId
   * @param investorId The new value for investorId
   * @param orderType The new value for orderType
   * @param share The new value for share
   * @param expirationTime The new value for expirationTime
   */
  public OrderSubmittedEvent(java.lang.CharSequence orderId, java.lang.CharSequence investorId, java.lang.CharSequence orderType, com.khalanirek.stockmarket.avro.order.Share share, java.lang.CharSequence expirationTime) {
    this.orderId = orderId;
    this.investorId = investorId;
    this.orderType = orderType;
    this.share = share;
    this.expirationTime = expirationTime;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return orderId;
    case 1: return investorId;
    case 2: return orderType;
    case 3: return share;
    case 4: return expirationTime;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: orderId = (java.lang.CharSequence)value$; break;
    case 1: investorId = (java.lang.CharSequence)value$; break;
    case 2: orderType = (java.lang.CharSequence)value$; break;
    case 3: share = (com.khalanirek.stockmarket.avro.order.Share)value$; break;
    case 4: expirationTime = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'orderId' field.
   * @return The value of the 'orderId' field.
   */
  public java.lang.CharSequence getOrderId() {
    return orderId;
  }


  /**
   * Sets the value of the 'orderId' field.
   * @param value the value to set.
   */
  public void setOrderId(java.lang.CharSequence value) {
    this.orderId = value;
  }

  /**
   * Gets the value of the 'investorId' field.
   * @return The value of the 'investorId' field.
   */
  public java.lang.CharSequence getInvestorId() {
    return investorId;
  }


  /**
   * Sets the value of the 'investorId' field.
   * @param value the value to set.
   */
  public void setInvestorId(java.lang.CharSequence value) {
    this.investorId = value;
  }

  /**
   * Gets the value of the 'orderType' field.
   * @return The value of the 'orderType' field.
   */
  public java.lang.CharSequence getOrderType() {
    return orderType;
  }


  /**
   * Sets the value of the 'orderType' field.
   * @param value the value to set.
   */
  public void setOrderType(java.lang.CharSequence value) {
    this.orderType = value;
  }

  /**
   * Gets the value of the 'share' field.
   * @return The value of the 'share' field.
   */
  public com.khalanirek.stockmarket.avro.order.Share getShare() {
    return share;
  }


  /**
   * Sets the value of the 'share' field.
   * @param value the value to set.
   */
  public void setShare(com.khalanirek.stockmarket.avro.order.Share value) {
    this.share = value;
  }

  /**
   * Gets the value of the 'expirationTime' field.
   * @return The value of the 'expirationTime' field.
   */
  public java.lang.CharSequence getExpirationTime() {
    return expirationTime;
  }


  /**
   * Sets the value of the 'expirationTime' field.
   * @param value the value to set.
   */
  public void setExpirationTime(java.lang.CharSequence value) {
    this.expirationTime = value;
  }

  /**
   * Creates a new OrderSubmittedEvent RecordBuilder.
   * @return A new OrderSubmittedEvent RecordBuilder
   */
  public static com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder newBuilder() {
    return new com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder();
  }

  /**
   * Creates a new OrderSubmittedEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OrderSubmittedEvent RecordBuilder
   */
  public static com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder newBuilder(com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder other) {
    if (other == null) {
      return new com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder();
    } else {
      return new com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder(other);
    }
  }

  /**
   * Creates a new OrderSubmittedEvent RecordBuilder by copying an existing OrderSubmittedEvent instance.
   * @param other The existing instance to copy.
   * @return A new OrderSubmittedEvent RecordBuilder
   */
  public static com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder newBuilder(com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent other) {
    if (other == null) {
      return new com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder();
    } else {
      return new com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for OrderSubmittedEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OrderSubmittedEvent>
    implements org.apache.avro.data.RecordBuilder<OrderSubmittedEvent> {

    private java.lang.CharSequence orderId;
    private java.lang.CharSequence investorId;
    private java.lang.CharSequence orderType;
    private com.khalanirek.stockmarket.avro.order.Share share;
    private com.khalanirek.stockmarket.avro.order.Share.Builder shareBuilder;
    private java.lang.CharSequence expirationTime;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.orderId)) {
        this.orderId = data().deepCopy(fields()[0].schema(), other.orderId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.investorId)) {
        this.investorId = data().deepCopy(fields()[1].schema(), other.investorId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.orderType)) {
        this.orderType = data().deepCopy(fields()[2].schema(), other.orderType);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.share)) {
        this.share = data().deepCopy(fields()[3].schema(), other.share);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (other.hasShareBuilder()) {
        this.shareBuilder = com.khalanirek.stockmarket.avro.order.Share.newBuilder(other.getShareBuilder());
      }
      if (isValidValue(fields()[4], other.expirationTime)) {
        this.expirationTime = data().deepCopy(fields()[4].schema(), other.expirationTime);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing OrderSubmittedEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.orderId)) {
        this.orderId = data().deepCopy(fields()[0].schema(), other.orderId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.investorId)) {
        this.investorId = data().deepCopy(fields()[1].schema(), other.investorId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.orderType)) {
        this.orderType = data().deepCopy(fields()[2].schema(), other.orderType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.share)) {
        this.share = data().deepCopy(fields()[3].schema(), other.share);
        fieldSetFlags()[3] = true;
      }
      this.shareBuilder = null;
      if (isValidValue(fields()[4], other.expirationTime)) {
        this.expirationTime = data().deepCopy(fields()[4].schema(), other.expirationTime);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'orderId' field.
      * @return The value.
      */
    public java.lang.CharSequence getOrderId() {
      return orderId;
    }


    /**
      * Sets the value of the 'orderId' field.
      * @param value The value of 'orderId'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder setOrderId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.orderId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'orderId' field has been set.
      * @return True if the 'orderId' field has been set, false otherwise.
      */
    public boolean hasOrderId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'orderId' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder clearOrderId() {
      orderId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'investorId' field.
      * @return The value.
      */
    public java.lang.CharSequence getInvestorId() {
      return investorId;
    }


    /**
      * Sets the value of the 'investorId' field.
      * @param value The value of 'investorId'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder setInvestorId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.investorId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'investorId' field has been set.
      * @return True if the 'investorId' field has been set, false otherwise.
      */
    public boolean hasInvestorId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'investorId' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder clearInvestorId() {
      investorId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'orderType' field.
      * @return The value.
      */
    public java.lang.CharSequence getOrderType() {
      return orderType;
    }


    /**
      * Sets the value of the 'orderType' field.
      * @param value The value of 'orderType'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder setOrderType(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.orderType = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'orderType' field has been set.
      * @return True if the 'orderType' field has been set, false otherwise.
      */
    public boolean hasOrderType() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'orderType' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder clearOrderType() {
      orderType = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'share' field.
      * @return The value.
      */
    public com.khalanirek.stockmarket.avro.order.Share getShare() {
      return share;
    }


    /**
      * Sets the value of the 'share' field.
      * @param value The value of 'share'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder setShare(com.khalanirek.stockmarket.avro.order.Share value) {
      validate(fields()[3], value);
      this.shareBuilder = null;
      this.share = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'share' field has been set.
      * @return True if the 'share' field has been set, false otherwise.
      */
    public boolean hasShare() {
      return fieldSetFlags()[3];
    }

    /**
     * Gets the Builder instance for the 'share' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.khalanirek.stockmarket.avro.order.Share.Builder getShareBuilder() {
      if (shareBuilder == null) {
        if (hasShare()) {
          setShareBuilder(com.khalanirek.stockmarket.avro.order.Share.newBuilder(share));
        } else {
          setShareBuilder(com.khalanirek.stockmarket.avro.order.Share.newBuilder());
        }
      }
      return shareBuilder;
    }

    /**
     * Sets the Builder instance for the 'share' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder setShareBuilder(com.khalanirek.stockmarket.avro.order.Share.Builder value) {
      clearShare();
      shareBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'share' field has an active Builder instance
     * @return True if the 'share' field has an active Builder instance
     */
    public boolean hasShareBuilder() {
      return shareBuilder != null;
    }

    /**
      * Clears the value of the 'share' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder clearShare() {
      share = null;
      shareBuilder = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'expirationTime' field.
      * @return The value.
      */
    public java.lang.CharSequence getExpirationTime() {
      return expirationTime;
    }


    /**
      * Sets the value of the 'expirationTime' field.
      * @param value The value of 'expirationTime'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder setExpirationTime(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.expirationTime = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'expirationTime' field has been set.
      * @return True if the 'expirationTime' field has been set, false otherwise.
      */
    public boolean hasExpirationTime() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'expirationTime' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.order.OrderSubmittedEvent.Builder clearExpirationTime() {
      expirationTime = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrderSubmittedEvent build() {
      try {
        OrderSubmittedEvent record = new OrderSubmittedEvent();
        record.orderId = fieldSetFlags()[0] ? this.orderId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.investorId = fieldSetFlags()[1] ? this.investorId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.orderType = fieldSetFlags()[2] ? this.orderType : (java.lang.CharSequence) defaultValue(fields()[2]);
        if (shareBuilder != null) {
          try {
            record.share = this.shareBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("share"));
            throw e;
          }
        } else {
          record.share = fieldSetFlags()[3] ? this.share : (com.khalanirek.stockmarket.avro.order.Share) defaultValue(fields()[3]);
        }
        record.expirationTime = fieldSetFlags()[4] ? this.expirationTime : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OrderSubmittedEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<OrderSubmittedEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OrderSubmittedEvent>
    READER$ = (org.apache.avro.io.DatumReader<OrderSubmittedEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.orderId);

    out.writeString(this.investorId);

    out.writeString(this.orderType);

    this.share.customEncode(out);

    out.writeString(this.expirationTime);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.orderId = in.readString(this.orderId instanceof Utf8 ? (Utf8)this.orderId : null);

      this.investorId = in.readString(this.investorId instanceof Utf8 ? (Utf8)this.investorId : null);

      this.orderType = in.readString(this.orderType instanceof Utf8 ? (Utf8)this.orderType : null);

      if (this.share == null) {
        this.share = new com.khalanirek.stockmarket.avro.order.Share();
      }
      this.share.customDecode(in);

      this.expirationTime = in.readString(this.expirationTime instanceof Utf8 ? (Utf8)this.expirationTime : null);

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.orderId = in.readString(this.orderId instanceof Utf8 ? (Utf8)this.orderId : null);
          break;

        case 1:
          this.investorId = in.readString(this.investorId instanceof Utf8 ? (Utf8)this.investorId : null);
          break;

        case 2:
          this.orderType = in.readString(this.orderType instanceof Utf8 ? (Utf8)this.orderType : null);
          break;

        case 3:
          if (this.share == null) {
            this.share = new com.khalanirek.stockmarket.avro.order.Share();
          }
          this.share.customDecode(in);
          break;

        case 4:
          this.expirationTime = in.readString(this.expirationTime instanceof Utf8 ? (Utf8)this.expirationTime : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









