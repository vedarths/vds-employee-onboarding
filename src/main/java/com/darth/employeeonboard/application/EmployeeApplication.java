package com.darth.employeeonboard.application;

import static org.springframework.util.Assert.notNull;

import com.darth.employeeonboard.application.model.Employee;
import com.darth.employeeonboard.application.model.EmployeeApi;
import com.darth.employeeonboard.repository.EmployeeDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeApplication implements EmployeeApi {

  private EmployeeDao employeeDao;

  @Autowired
  public EmployeeApplication(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }

  @Override
  public Integer create(Employee employee) {
    notNull(employee, "employee cannot be null");
    notNull(employee.getAddress(), "address cannot be null");

    Integer addressId = employeeDao.createAddress(employee.getAddress());
    employeeDao.createEmployee(employee);
    return null;
  }

  @Override
  public void update(Employee employee) {

  }

  @Override
  public List<Employee> getAll() {
    return null;
  }

  @Override
  public Employee get(int id) {
    return null;
  }

  @Override
  public void delete(int id) {

  }
}
