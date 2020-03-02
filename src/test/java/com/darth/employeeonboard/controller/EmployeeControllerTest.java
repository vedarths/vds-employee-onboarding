package com.darth.employeeonboard.controller;

import static com.darth.employeeonboard.application.model.Employee.Builder.anEmployee;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.darth.employeeonboard.application.model.Employee;
import com.darth.employeeonboard.application.model.EmployeeApi;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest extends AbstractEmployeeControllerTest {

  public static final String EMPLOYEE = "employee";

  private String createEmployeeUri = createServicePath(EMPLOYEE);

  private MockMvc mockMvc;

  @Mock
  private EmployeeApi employeeApi;

  private Employee employee;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeController(employeeApi)).build();
  }

  @Test
  public void testWhenCreateHappyPath() throws Exception {
    givenWeHaveAnEmployeeToCreate();
    whenWeCallCreateEmployeeController(status().isOk());
    thenACreateEmployeeApplicationCallIsMade();
  }

  //given
  private void givenWeHaveAnEmployeeToCreate() {
    employee = anEmployee().withId(0)
                           .build();
  }

  //when
  private void whenWeCallCreateEmployeeController(ResultMatcher resultMatcher) throws Exception {
    mockMvc.perform(post(createEmployeeUri).contentType(MediaType.APPLICATION_JSON)
                                           .content("{}")
                                           .accept(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(resultMatcher)
           .andReturn();

  }

  //then
  private void thenACreateEmployeeApplicationCallIsMade() {
    verify(employeeApi, times(1)).create(eq(employee));
  }



}