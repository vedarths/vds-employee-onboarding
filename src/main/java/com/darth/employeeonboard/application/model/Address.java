package com.darth.employeeonboard.application.model;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Address {

  private final String line1;
  private final String line2;
  private final String line3;
  private final String streetName;
  private final String postCode;
  private final String county;
  private final String country;

  @JsonCreator
  private Address(@JsonProperty("line1") String line1,
      @JsonProperty("line2") String line2,
      @JsonProperty("line3") String line3,
      @JsonProperty("streetName") String streetName,
      @JsonProperty("postCode") String postCode,
      @JsonProperty("county") String county,
      @JsonProperty("country") String country) {
    this.line1 = line1;
    this.line2 = line2;
    this.line3 = line3;
    this.streetName = streetName;
    this.postCode = postCode;
    this.county = county;
    this.country = country;
  }

  public String getLine1() {
    return line1;
  }

  public String getLine2() {
    return line2;
  }

  public String getLine3() {
    return line3;
  }

  public String getStreetName() {
    return streetName;
  }

  public String getPostCode() {
    return postCode;
  }

  public String getCounty() {
    return county;
  }

  public String getCountry() {
    return country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Address address = (Address) o;

    return new EqualsBuilder().append(line1, address.line1)
                              .append(line2, address.line2)
                              .append(line3, address.line3)
                              .append(streetName, address.streetName)
                              .append(postCode, address.postCode)
                              .append(county, address.county)
                              .append(country, address.country)
                              .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(line1)
                                .append(line2)
                                .append(line3)
                                .append(streetName)
                                .append(postCode)
                                .append(county)
                                .append(country)
                                .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, SHORT_PREFIX_STYLE).append("line1", line1)
                                                        .append("line2", line2)
                                                        .append("line3", line3)
                                                        .append("streetName", streetName)
                                                        .append("postCode", postCode)
                                                        .append("county", county)
                                                        .append("country", country)
                                                        .toString();
  }


  public static final class Builder {

    private String line1;
    private String line2;
    private String line3;
    private String streetName;
    private String postCode;
    private String county;
    private String country;

    private Builder() {
    }

    public static Builder anAddress() {
      return new Builder();
    }

    public Builder withLine1(String line1) {
      this.line1 = line1;
      return this;
    }

    public Builder withLine2(String line2) {
      this.line2 = line2;
      return this;
    }

    public Builder withLine3(String line3) {
      this.line3 = line3;
      return this;
    }

    public Builder withStreetName(String streetName) {
      this.streetName = streetName;
      return this;
    }

    public Builder withPostCode(String postCode) {
      this.postCode = postCode;
      return this;
    }

    public Builder withCounty(String county) {
      this.county = county;
      return this;
    }

    public Builder withCountry(String country) {
      this.country = country;
      return this;
    }

    public Address build() {
      return new Address(line1, line2, line3, streetName, postCode, county, country);
    }
  }
}
