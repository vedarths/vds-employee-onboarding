package com.darth.employeeonboard.controller;

import static com.darth.employeeonboard.controller.EmployeeController.REQUEST_MAPPING;

import com.darth.employeeonboard.application.model.Employee;
import com.darth.employeeonboard.application.model.EmployeeApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller("employeeController")
@RequestMapping(value = REQUEST_MAPPING)
public class EmployeeController extends AbstractController {

  static final String REQUEST_MAPPING = BASE_REQUEST_MAPPING + "/employee";

  private EmployeeApi employeeApi;

  EmployeeController(@Qualifier("employeeApplication") EmployeeApi employeeApi) {
    this.employeeApi = employeeApi;
  }

  @PostMapping
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public Integer create(@RequestBody Employee employee) {
    return employeeApi.create(employee);
  }


}
