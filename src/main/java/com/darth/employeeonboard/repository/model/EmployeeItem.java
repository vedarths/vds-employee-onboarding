package com.darth.employeeonboard.repository.model;

import com.darth.employeeonboard.application.model.Address;

public class EmployeeItem {

  private final int id;
  private final String firstName;
  private final String lastName;
  private final String title;
  private final String role;
  private final Double salary;
  private final Integer addressId;

  public EmployeeItem(int id, String firstName, String lastName, String title, String role,
      Double salary, Integer addressId) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.title = title;
    this.role = role;
    this.salary = salary;
    this.addressId = addressId;
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

  public Integer getAddressId() {
    return addressId;
  }

}
