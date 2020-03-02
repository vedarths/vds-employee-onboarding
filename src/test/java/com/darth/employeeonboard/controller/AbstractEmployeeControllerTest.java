package com.darth.employeeonboard.controller;

public class AbstractEmployeeControllerTest {

  protected String createServicePath(String... pathParts) {
    StringBuilder servicePath = new StringBuilder("/vds-employee-manager/employee-onboarding");
    for(String pathPart: pathParts) {
      servicePath.append("/")
                 .append(pathPart);
    }
    return servicePath.toString();
  }
}
