/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.khalanirek.stockmarket.avro.investor;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class InvestorRegisteredEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5559207482961408948L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"InvestorRegisteredEvent\",\"namespace\":\"com.khalanirek.stockmarket.avro.investor\",\"fields\":[{\"name\":\"investorId\",\"type\":\"string\"},{\"name\":\"accountId\",\"type\":\"string\"},{\"name\":\"investmentPortfolioId\",\"type\":\"string\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"surname\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<InvestorRegisteredEvent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<InvestorRegisteredEvent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<InvestorRegisteredEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<InvestorRegisteredEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<InvestorRegisteredEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this InvestorRegisteredEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a InvestorRegisteredEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a InvestorRegisteredEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static InvestorRegisteredEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence investorId;
  private java.lang.CharSequence accountId;
  private java.lang.CharSequence investmentPortfolioId;
  private java.lang.CharSequence name;
  private java.lang.CharSequence surname;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public InvestorRegisteredEvent() {}

  /**
   * All-args constructor.
   * @param investorId The new value for investorId
   * @param accountId The new value for accountId
   * @param investmentPortfolioId The new value for investmentPortfolioId
   * @param name The new value for name
   * @param surname The new value for surname
   */
  public InvestorRegisteredEvent(java.lang.CharSequence investorId, java.lang.CharSequence accountId, java.lang.CharSequence investmentPortfolioId, java.lang.CharSequence name, java.lang.CharSequence surname) {
    this.investorId = investorId;
    this.accountId = accountId;
    this.investmentPortfolioId = investmentPortfolioId;
    this.name = name;
    this.surname = surname;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return investorId;
    case 1: return accountId;
    case 2: return investmentPortfolioId;
    case 3: return name;
    case 4: return surname;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: investorId = (java.lang.CharSequence)value$; break;
    case 1: accountId = (java.lang.CharSequence)value$; break;
    case 2: investmentPortfolioId = (java.lang.CharSequence)value$; break;
    case 3: name = (java.lang.CharSequence)value$; break;
    case 4: surname = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
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
   * Gets the value of the 'investmentPortfolioId' field.
   * @return The value of the 'investmentPortfolioId' field.
   */
  public java.lang.CharSequence getInvestmentPortfolioId() {
    return investmentPortfolioId;
  }


  /**
   * Sets the value of the 'investmentPortfolioId' field.
   * @param value the value to set.
   */
  public void setInvestmentPortfolioId(java.lang.CharSequence value) {
    this.investmentPortfolioId = value;
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
   * Gets the value of the 'surname' field.
   * @return The value of the 'surname' field.
   */
  public java.lang.CharSequence getSurname() {
    return surname;
  }


  /**
   * Sets the value of the 'surname' field.
   * @param value the value to set.
   */
  public void setSurname(java.lang.CharSequence value) {
    this.surname = value;
  }

  /**
   * Creates a new InvestorRegisteredEvent RecordBuilder.
   * @return A new InvestorRegisteredEvent RecordBuilder
   */
  public static com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder newBuilder() {
    return new com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder();
  }

  /**
   * Creates a new InvestorRegisteredEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new InvestorRegisteredEvent RecordBuilder
   */
  public static com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder newBuilder(com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder other) {
    if (other == null) {
      return new com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder();
    } else {
      return new com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder(other);
    }
  }

  /**
   * Creates a new InvestorRegisteredEvent RecordBuilder by copying an existing InvestorRegisteredEvent instance.
   * @param other The existing instance to copy.
   * @return A new InvestorRegisteredEvent RecordBuilder
   */
  public static com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder newBuilder(com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent other) {
    if (other == null) {
      return new com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder();
    } else {
      return new com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for InvestorRegisteredEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<InvestorRegisteredEvent>
    implements org.apache.avro.data.RecordBuilder<InvestorRegisteredEvent> {

    private java.lang.CharSequence investorId;
    private java.lang.CharSequence accountId;
    private java.lang.CharSequence investmentPortfolioId;
    private java.lang.CharSequence name;
    private java.lang.CharSequence surname;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.investorId)) {
        this.investorId = data().deepCopy(fields()[0].schema(), other.investorId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.accountId)) {
        this.accountId = data().deepCopy(fields()[1].schema(), other.accountId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.investmentPortfolioId)) {
        this.investmentPortfolioId = data().deepCopy(fields()[2].schema(), other.investmentPortfolioId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.name)) {
        this.name = data().deepCopy(fields()[3].schema(), other.name);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.surname)) {
        this.surname = data().deepCopy(fields()[4].schema(), other.surname);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing InvestorRegisteredEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.investorId)) {
        this.investorId = data().deepCopy(fields()[0].schema(), other.investorId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.accountId)) {
        this.accountId = data().deepCopy(fields()[1].schema(), other.accountId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.investmentPortfolioId)) {
        this.investmentPortfolioId = data().deepCopy(fields()[2].schema(), other.investmentPortfolioId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.name)) {
        this.name = data().deepCopy(fields()[3].schema(), other.name);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.surname)) {
        this.surname = data().deepCopy(fields()[4].schema(), other.surname);
        fieldSetFlags()[4] = true;
      }
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
    public com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder setInvestorId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.investorId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'investorId' field has been set.
      * @return True if the 'investorId' field has been set, false otherwise.
      */
    public boolean hasInvestorId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'investorId' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder clearInvestorId() {
      investorId = null;
      fieldSetFlags()[0] = false;
      return this;
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
    public com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder setAccountId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.accountId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'accountId' field has been set.
      * @return True if the 'accountId' field has been set, false otherwise.
      */
    public boolean hasAccountId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'accountId' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder clearAccountId() {
      accountId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'investmentPortfolioId' field.
      * @return The value.
      */
    public java.lang.CharSequence getInvestmentPortfolioId() {
      return investmentPortfolioId;
    }


    /**
      * Sets the value of the 'investmentPortfolioId' field.
      * @param value The value of 'investmentPortfolioId'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder setInvestmentPortfolioId(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.investmentPortfolioId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'investmentPortfolioId' field has been set.
      * @return True if the 'investmentPortfolioId' field has been set, false otherwise.
      */
    public boolean hasInvestmentPortfolioId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'investmentPortfolioId' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder clearInvestmentPortfolioId() {
      investmentPortfolioId = null;
      fieldSetFlags()[2] = false;
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
    public com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder setName(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.name = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder clearName() {
      name = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'surname' field.
      * @return The value.
      */
    public java.lang.CharSequence getSurname() {
      return surname;
    }


    /**
      * Sets the value of the 'surname' field.
      * @param value The value of 'surname'.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder setSurname(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.surname = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'surname' field has been set.
      * @return True if the 'surname' field has been set, false otherwise.
      */
    public boolean hasSurname() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'surname' field.
      * @return This builder.
      */
    public com.khalanirek.stockmarket.avro.investor.InvestorRegisteredEvent.Builder clearSurname() {
      surname = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public InvestorRegisteredEvent build() {
      try {
        InvestorRegisteredEvent record = new InvestorRegisteredEvent();
        record.investorId = fieldSetFlags()[0] ? this.investorId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.accountId = fieldSetFlags()[1] ? this.accountId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.investmentPortfolioId = fieldSetFlags()[2] ? this.investmentPortfolioId : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.name = fieldSetFlags()[3] ? this.name : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.surname = fieldSetFlags()[4] ? this.surname : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<InvestorRegisteredEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<InvestorRegisteredEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<InvestorRegisteredEvent>
    READER$ = (org.apache.avro.io.DatumReader<InvestorRegisteredEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.investorId);

    out.writeString(this.accountId);

    out.writeString(this.investmentPortfolioId);

    out.writeString(this.name);

    out.writeString(this.surname);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.investorId = in.readString(this.investorId instanceof Utf8 ? (Utf8)this.investorId : null);

      this.accountId = in.readString(this.accountId instanceof Utf8 ? (Utf8)this.accountId : null);

      this.investmentPortfolioId = in.readString(this.investmentPortfolioId instanceof Utf8 ? (Utf8)this.investmentPortfolioId : null);

      this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);

      this.surname = in.readString(this.surname instanceof Utf8 ? (Utf8)this.surname : null);

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.investorId = in.readString(this.investorId instanceof Utf8 ? (Utf8)this.investorId : null);
          break;

        case 1:
          this.accountId = in.readString(this.accountId instanceof Utf8 ? (Utf8)this.accountId : null);
          break;

        case 2:
          this.investmentPortfolioId = in.readString(this.investmentPortfolioId instanceof Utf8 ? (Utf8)this.investmentPortfolioId : null);
          break;

        case 3:
          this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          break;

        case 4:
          this.surname = in.readString(this.surname instanceof Utf8 ? (Utf8)this.surname : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










