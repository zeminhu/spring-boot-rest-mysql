package com.hzsolution.orders.service;

import com.hzsolution.orders.model.Employee;
import com.hzsolution.orders.repository.EmployeeRepository;
import com.hzsolution.orders.utils.RestResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
@Service
public class EmployeeService {
  private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

  @Autowired
  private EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public Employee getById(String employeeId) throws JSONException {
    return employeeRepository.getById(employeeId);
  }

  public List<Employee> getAll() {
    return employeeRepository.getAll();
  }

  public boolean insert(Employee employee) {
    employeeRepository.insert(employee);
    return true;
    // TODO business logic here
/*    String status = "NOTINGESTED"; // STALE FRESH
    Date date = new Date();
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("status", status);
    jsonObject.put("lastTimeStamp", date.toString());

    return RestResponseBuilder.buildSuccess(jsonObject, "serviceRefId");*/
  }

  public ResponseEntity update(String datasetId) throws JSONException {
    // TODO business logic here
    String status = "NOTINGESTED"; // STALE FRESH
    Date date = new Date();
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("status", status);
    jsonObject.put("lastTimeStamp", date.toString());

    return RestResponseBuilder.buildSuccess(jsonObject, "serviceRefId");
  }
}
