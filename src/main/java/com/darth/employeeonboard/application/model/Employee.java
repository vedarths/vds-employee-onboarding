package com.darth.employeeonboard.application.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Employee {

  private final int id;
  private final String firstName;
  private final String lastName;
  private final String title;
  private final String role;
  private final Double salary;
  private final Address address;

  @JsonCreator
  private Employee(@JsonProperty("id") int id,
      @JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName,
      @JsonProperty("title") String title,
      @JsonProperty("role") String role,
      @JsonProperty("salary") Double salary,
      @JsonProperty("address") Address address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.title = title;
    this.role = role;
    this.salary = salary;
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getTitle() {
    return title;
  }

  public String getRole() {
    return role;
  }

  public Double getSalary() {
    return salary;
  }

  public Address getAddress() {
    return address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Employee employee = (Employee) o;

    return new EqualsBuilder().append(id, employee.id)
                              .append(firstName, employee.firstName)
                              .append(lastName, employee.lastName)
                              .append(title, employee.title)
                              .append(role, employee.role)
                              .append(salary, employee.salary)
                              .append(address, employee.address)
                              .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(id)
                                .append(firstName)
                                .append(lastName)
                                .append(title)
                                .append(role)
                                .append(salary)
                                .append(address)
                                .toHashCode();
  }


  @Override
  public String toString() {
    return new ToStringBuilder(this).append("id", id)
                                    .append("firstName", firstName)
                                    .append("lastName", lastName)
                                    .append("title", title)
                                    .append("role", role)
                                    .append("salary", salary)
                                    .append("address", address)
                                    .toString();
  }


  public static final class Builder {

    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private String role;
    private Double salary;
    private Address address;

    private Builder() {
    }

    public static Builder anEmployee() {
      return new Builder();
    }

    public Builder withId(int id) {
      this.id = id;
      return this;
    }

    public Builder withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder withTitle(String title) {
      this.title = title;
      return this;
    }

    public Builder withRole(String role) {
      this.role = role;
      return this;
    }

    public Builder withSalary(Double salary) {
      this.salary = salary;
      return this;
    }

    public Builder withAddress(Address address) {
      this.address = address;
      return this;
    }

    public Employee build() {
      return new Employee(id, firstName, lastName, title, role, salary, address);
    }
  }
}
