/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.khalanirek.stockmarket.avro.account;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class FundsWithdrewEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2013139765960278155L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FundsWithdrewEvent\",\"namespace\":\"com.khalanirek.stockmarket.avro.account\",\"fields\":[{\"name\":\"accountId\",\"type\":\"string\"},{\"name\":\"amount\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<FundsWithdrewEvent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<FundsWithdrewEvent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<FundsWithdrewEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<FundsWithdrewEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<FundsWithdrewEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this FundsWithdrewEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a FundsWithdrewEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a FundsWithdrewEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static FundsWithdrewEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence accountId;
  private java.lang.CharSequence amount;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public FundsWithdrewEvent() {}

  /**
   * All-args constructor.
   * @param accountId The new value for accountId
   * @param amount The new value for amount
   */
  public FundsWithdrewEvent(java.lang.CharSequence accountId, java.lang.CharSequence amount) {
    this.accountId = accountId;
    this.amount = amount;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return accountId;
    case 1: return amount;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: accountId = (java.lang.CharSequence)value$; break;
    case 1: amount = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'accountId' field.
   * @return The value of the 'accountId' field.
   */
  public java.lang.CharSequence getAccountId() {
    return accountId;
  }


  /**
   * Sets the value of the 'accountId' field.
   * @param value the value to set.
   */
  public void setAccountId(java.lang.CharSequence value) {
    this.accountId = value;
  }

  /**
   * Gets the value of the 'amount' field.
   * @return The value of the 'amount' field.
   */
  public java.lang.CharSequence getAmount() {
    return amount;
  }


  /**
   * Sets the value of the 'amount' field.
   * @param value the value to set.
   */
  public void setAmount(java.lang.CharSequence value) {
    this.amount = value;
  }

  /**
   * Creates a new FundsWithdrewEvent RecordBuilder.
   * @return A new FundsWithdrewEvent RecordBuilder
   */
  public static com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder newBuilder() {
    return new com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder();
  }

  /**
   * Creates a new FundsWithdrewEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new FundsWithdrewEvent RecordBuilder
   */
  public static com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder newBuilder(com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder other) {
    if (other == null) {
      return new com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder();
    } else {
      return new com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder(other);
    }
  }

  /**
   * Creates a new FundsWithdrewEvent RecordBuilder by copying an existing FundsWithdrewEvent instance.
   * @param other The existing instance to copy.
   * @return A new FundsWithdrewEvent RecordBuilder
   */
  public static com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder newBuilder(com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent other) {
    if (other == null) {
      return new com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder();
    } else {
      return new com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for FundsWithdrewEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FundsWithdrewEvent>
    implements org.apache.avro.data.RecordBuilder<FundsWithdrewEvent> {

    private java.lang.CharSequence accountId;
    private java.lang.CharSequence amount;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.accountId)) {
        this.accountId = data().deepCopy(fields()[0].schema(), other.accountId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.amount)) {
        this.amount = data().deepCopy(fields()[1].schema(), other.amount);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing FundsWithdrewEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.accountId)) {
        this.accountId = data().deepCopy(fields()[0].schema(), other.accountId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.amount)) {
        this.amount = data().deepCopy(fields()[1].schema(), other.amount);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'accountId' field.
      * @return The value.
      */
    public java.lang.CharSequence getAccountId() {
      return accountId;
    }


    /**
      * Sets the value of the 'accountId' field.
      * @param value The value of 'accountId'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder setAccountId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.accountId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'accountId' field has been set.
      * @return True if the 'accountId' field has been set, false otherwise.
      */
    public boolean hasAccountId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'accountId' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder clearAccountId() {
      accountId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'amount' field.
      * @return The value.
      */
    public java.lang.CharSequence getAmount() {
      return amount;
    }


    /**
      * Sets the value of the 'amount' field.
      * @param value The value of 'amount'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder setAmount(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.amount = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'amount' field has been set.
      * @return True if the 'amount' field has been set, false otherwise.
      */
    public boolean hasAmount() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'amount' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.account.FundsWithdrewEvent.Builder clearAmount() {
      amount = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public FundsWithdrewEvent build() {
      try {
        FundsWithdrewEvent record = new FundsWithdrewEvent();
        record.accountId = fieldSetFlags()[0] ? this.accountId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.amount = fieldSetFlags()[1] ? this.amount : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<FundsWithdrewEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<FundsWithdrewEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<FundsWithdrewEvent>
    READER$ = (org.apache.avro.io.DatumReader<FundsWithdrewEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.accountId);

    out.writeString(this.amount);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.accountId = in.readString(this.accountId instanceof Utf8 ? (Utf8)this.accountId : null);

      this.amount = in.readString(this.amount instanceof Utf8 ? (Utf8)this.amount : null);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.accountId = in.readString(this.accountId instanceof Utf8 ? (Utf8)this.accountId : null);
          break;

        case 1:
          this.amount = in.readString(this.amount instanceof Utf8 ? (Utf8)this.amount : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










