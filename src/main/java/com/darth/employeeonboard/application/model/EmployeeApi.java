package com.darth.employeeonboard.application.model;

import java.util.List;

public interface EmployeeApi {

  Integer create(Employee employee);

  void update(Employee employee);

  List<Employee> getAll();

  Employee get(int id);

  void delete(int id);

}
