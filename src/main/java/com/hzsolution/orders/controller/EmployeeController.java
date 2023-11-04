package com.hzsolution.orders.controller;

import com.hzsolution.orders.model.Employee;
import com.hzsolution.orders.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RequestMapping(value = "/employees/v1")
@RestController
public class EmployeeController {
  private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

  @Autowired
  private EmployeeService employeeService;

  @RequestMapping(value = "/{id}/", method = RequestMethod.GET, produces = {
      MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
  public ResponseEntity<Employee> getById(@PathVariable(value = "id") String employeeId) throws JSONException {
    Employee employee = employeeService.getById(employeeId);
    return ResponseEntity.ok().body(employee);
  }

  @GetMapping(path = "", produces = "application/json")
  public List<Employee> getEmployees() {
    logger.info("hit getEmployees");
    return employeeService.getAll();
  }

  @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

    //add resource
    employeeService.insert(employee);

    //Create resource location
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(employee.getId())
            .toUri();

    //Send location in response
    return ResponseEntity.created(location).build();
  }
}
