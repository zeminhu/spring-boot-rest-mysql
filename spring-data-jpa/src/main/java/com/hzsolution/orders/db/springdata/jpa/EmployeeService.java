package com.hzsolution.orders.db.springdata.jpa;

import com.hzsolution.orders.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
        return employeeList;
    }
}
