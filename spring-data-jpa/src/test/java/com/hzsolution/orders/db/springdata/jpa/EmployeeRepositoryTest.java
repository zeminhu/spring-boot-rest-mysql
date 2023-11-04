package com.hzsolution.orders.db.springdata.jpa;

import com.hzsolution.orders.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    int employeeId = 0;

    @Test
    @Order(1)
    public void whenEmployeesInDatabase_shouldReturnEmployeeList() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        assert employees != null : "no employee from database";
        assert employees.size() > 0 : "empty employee list";
        log.info("number of employees: " + employees.size());
    }

}
