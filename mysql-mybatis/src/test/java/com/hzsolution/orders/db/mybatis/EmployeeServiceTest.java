package com.hzsolution.orders.db.mybatis;


import com.hzsolution.orders.db.mybatis.service.EmployeeService;
import com.hzsolution.orders.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
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
public class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;

    Employee employee1, employee2;
    int id = 0;

    @Before
    public void setUp() {
        employee1 = new Employee(0,"e123-557","Mike","Trent","407-432-4466","x4858", "big-bird@disney.com", 55000, "2", 1088, "Senior Sale Rep");
        employee2 = new Employee(0,"e123-789","Clint","Wood","123-456-7890","x1230", "big-bird@disney.com", 55000, "2", 1088, "Senior Sale Rep");
    }

    @Test
    @Order(1)
    public void insertANewEmployeesIntoDatabase() throws Exception {
        employeeService.insert(employee1);
        assert employee1 != null : "inserted failure";
        id = employee1.getId();
        Employee employee =employeeService.getById(id);
        assert employee != null : "newly inserted employee not found";
        assert employee.getFirstName().equals("Mike") : "no matching: FirstName";
    }

    @Test
    @Order(2)
    public void whenEmployeesInDatabase_shouldReturnEmployeeWithGivenId() {
        Employee employee = employeeService.getById(1002);
        assert employee != null : "no employee from database";
        assert employee.getFirstName().equals("Diane") : "employee: employee id is not correct";
        log.info("" + employee);
    }

    @Test
    @Order(3)
    public void whenEmployeesInDatabase_shouldReturnEmployeeList() {
        List<Employee> employees = employeeService.getAll();
        assert employees != null : "no employee from database";
        assert employees.size() > 0 : "empty employee list";
        log.info("number of employees: " + employees.size());
    }

    @Test
    @Order(4)
    public void testUpdate() throws Exception {
        String employeeId = "e789-001";
        Employee employee =employeeService.getById(id);
        employee.setEmployeeId(employeeId);
        employeeService.update(employee);
        employee =employeeService.getById(id);
        assert employee.getEmployeeId() == employeeId;
    }

    @Test
    @Order(5)
    public void deleteNewlyInsertedById() {
        employeeService.deleteById(id);
        Employee employee = employeeService.getById(id);
        assert employee == null : "employee should be deleted";
    }



}
