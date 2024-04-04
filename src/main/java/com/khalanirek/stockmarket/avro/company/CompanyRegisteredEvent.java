/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.khalanirek.stockmarket.avro.company;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class CompanyRegisteredEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7492581028007940388L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CompanyRegisteredEvent\",\"namespace\":\"com.khalanirek.stockmarket.avro.company\",\"fields\":[{\"name\":\"companyId\",\"type\":\"string\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"symbol\",\"type\":\"string\"},{\"name\":\"shareCapital\",\"type\":\"string\"},{\"name\":\"sharesQuantity\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CompanyRegisteredEvent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CompanyRegisteredEvent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CompanyRegisteredEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CompanyRegisteredEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CompanyRegisteredEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CompanyRegisteredEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CompanyRegisteredEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CompanyRegisteredEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CompanyRegisteredEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence companyId;
  private java.lang.CharSequence name;
  private java.lang.CharSequence symbol;
  private java.lang.CharSequence shareCapital;
  private long sharesQuantity;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CompanyRegisteredEvent() {}

  /**
   * All-args constructor.
   * @param companyId The new value for companyId
   * @param name The new value for name
   * @param symbol The new value for symbol
   * @param shareCapital The new value for shareCapital
   * @param sharesQuantity The new value for sharesQuantity
   */
  public CompanyRegisteredEvent(java.lang.CharSequence companyId, java.lang.CharSequence name, java.lang.CharSequence symbol, java.lang.CharSequence shareCapital, java.lang.Long sharesQuantity) {
    this.companyId = companyId;
    this.name = name;
    this.symbol = symbol;
    this.shareCapital = shareCapital;
    this.sharesQuantity = sharesQuantity;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return companyId;
    case 1: return name;
    case 2: return symbol;
    case 3: return shareCapital;
    case 4: return sharesQuantity;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: companyId = (java.lang.CharSequence)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: symbol = (java.lang.CharSequence)value$; break;
    case 3: shareCapital = (java.lang.CharSequence)value$; break;
    case 4: sharesQuantity = (java.lang.Long)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'companyId' field.
   * @return The value of the 'companyId' field.
   */
  public java.lang.CharSequence getCompanyId() {
    return companyId;
  }


  /**
   * Sets the value of the 'companyId' field.
   * @param value the value to set.
   */
  public void setCompanyId(java.lang.CharSequence value) {
    this.companyId = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'symbol' field.
   * @return The value of the 'symbol' field.
   */
  public java.lang.CharSequence getSymbol() {
    return symbol;
  }


  /**
   * Sets the value of the 'symbol' field.
   * @param value the value to set.
   */
  public void setSymbol(java.lang.CharSequence value) {
    this.symbol = value;
  }

  /**
   * Gets the value of the 'shareCapital' field.
   * @return The value of the 'shareCapital' field.
   */
  public java.lang.CharSequence getShareCapital() {
    return shareCapital;
  }


  /**
   * Sets the value of the 'shareCapital' field.
   * @param value the value to set.
   */
  public void setShareCapital(java.lang.CharSequence value) {
    this.shareCapital = value;
  }

  /**
   * Gets the value of the 'sharesQuantity' field.
   * @return The value of the 'sharesQuantity' field.
   */
  public long getSharesQuantity() {
    return sharesQuantity;
  }


  /**
   * Sets the value of the 'sharesQuantity' field.
   * @param value the value to set.
   */
  public void setSharesQuantity(long value) {
    this.sharesQuantity = value;
  }

  /**
   * Creates a new CompanyRegisteredEvent RecordBuilder.
   * @return A new CompanyRegisteredEvent RecordBuilder
   */
  public static com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder newBuilder() {
    return new com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder();
  }

  /**
   * Creates a new CompanyRegisteredEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CompanyRegisteredEvent RecordBuilder
   */
  public static com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder newBuilder(com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder other) {
    if (other == null) {
      return new com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder();
    } else {
      return new com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder(other);
    }
  }

  /**
   * Creates a new CompanyRegisteredEvent RecordBuilder by copying an existing CompanyRegisteredEvent instance.
   * @param other The existing instance to copy.
   * @return A new CompanyRegisteredEvent RecordBuilder
   */
  public static com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder newBuilder(com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent other) {
    if (other == null) {
      return new com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder();
    } else {
      return new com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for CompanyRegisteredEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CompanyRegisteredEvent>
    implements org.apache.avro.data.RecordBuilder<CompanyRegisteredEvent> {

    private java.lang.CharSequence companyId;
    private java.lang.CharSequence name;
    private java.lang.CharSequence symbol;
    private java.lang.CharSequence shareCapital;
    private long sharesQuantity;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.companyId)) {
        this.companyId = data().deepCopy(fields()[0].schema(), other.companyId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.symbol)) {
        this.symbol = data().deepCopy(fields()[2].schema(), other.symbol);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.shareCapital)) {
        this.shareCapital = data().deepCopy(fields()[3].schema(), other.shareCapital);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.sharesQuantity)) {
        this.sharesQuantity = data().deepCopy(fields()[4].schema(), other.sharesQuantity);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing CompanyRegisteredEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.companyId)) {
        this.companyId = data().deepCopy(fields()[0].schema(), other.companyId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.symbol)) {
        this.symbol = data().deepCopy(fields()[2].schema(), other.symbol);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.shareCapital)) {
        this.shareCapital = data().deepCopy(fields()[3].schema(), other.shareCapital);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.sharesQuantity)) {
        this.sharesQuantity = data().deepCopy(fields()[4].schema(), other.sharesQuantity);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'companyId' field.
      * @return The value.
      */
    public java.lang.CharSequence getCompanyId() {
      return companyId;
    }


    /**
      * Sets the value of the 'companyId' field.
      * @param value The value of 'companyId'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder setCompanyId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.companyId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'companyId' field has been set.
      * @return True if the 'companyId' field has been set, false otherwise.
      */
    public boolean hasCompanyId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'companyId' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder clearCompanyId() {
      companyId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'symbol' field.
      * @return The value.
      */
    public java.lang.CharSequence getSymbol() {
      return symbol;
    }


    /**
      * Sets the value of the 'symbol' field.
      * @param value The value of 'symbol'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder setSymbol(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.symbol = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'symbol' field has been set.
      * @return True if the 'symbol' field has been set, false otherwise.
      */
    public boolean hasSymbol() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'symbol' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder clearSymbol() {
      symbol = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'shareCapital' field.
      * @return The value.
      */
    public java.lang.CharSequence getShareCapital() {
      return shareCapital;
    }


    /**
      * Sets the value of the 'shareCapital' field.
      * @param value The value of 'shareCapital'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder setShareCapital(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.shareCapital = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'shareCapital' field has been set.
      * @return True if the 'shareCapital' field has been set, false otherwise.
      */
    public boolean hasShareCapital() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'shareCapital' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder clearShareCapital() {
      shareCapital = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'sharesQuantity' field.
      * @return The value.
      */
    public long getSharesQuantity() {
      return sharesQuantity;
    }


    /**
      * Sets the value of the 'sharesQuantity' field.
      * @param value The value of 'sharesQuantity'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder setSharesQuantity(long value) {
      validate(fields()[4], value);
      this.sharesQuantity = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'sharesQuantity' field has been set.
      * @return True if the 'sharesQuantity' field has been set, false otherwise.
      */
    public boolean hasSharesQuantity() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'sharesQuantity' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.company.CompanyRegisteredEvent.Builder clearSharesQuantity() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CompanyRegisteredEvent build() {
      try {
        CompanyRegisteredEvent record = new CompanyRegisteredEvent();
        record.companyId = fieldSetFlags()[0] ? this.companyId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.symbol = fieldSetFlags()[2] ? this.symbol : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.shareCapital = fieldSetFlags()[3] ? this.shareCapital : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.sharesQuantity = fieldSetFlags()[4] ? this.sharesQuantity : (java.lang.Long) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CompanyRegisteredEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<CompanyRegisteredEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CompanyRegisteredEvent>
    READER$ = (org.apache.avro.io.DatumReader<CompanyRegisteredEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.companyId);

    out.writeString(this.name);

    out.writeString(this.symbol);

    out.writeString(this.shareCapital);

    out.writeLong(this.sharesQuantity);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.companyId = in.readString(this.companyId instanceof Utf8 ? (Utf8)this.companyId : null);

      this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);

      this.symbol = in.readString(this.symbol instanceof Utf8 ? (Utf8)this.symbol : null);

      this.shareCapital = in.readString(this.shareCapital instanceof Utf8 ? (Utf8)this.shareCapital : null);

      this.sharesQuantity = in.readLong();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.companyId = in.readString(this.companyId instanceof Utf8 ? (Utf8)this.companyId : null);
          break;

        case 1:
          this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          break;

        case 2:
          this.symbol = in.readString(this.symbol instanceof Utf8 ? (Utf8)this.symbol : null);
          break;

        case 3:
          this.shareCapital = in.readString(this.shareCapital instanceof Utf8 ? (Utf8)this.shareCapital : null);
          break;

        case 4:
          this.sharesQuantity = in.readLong();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










