package com.hzsolution.orders.db.jdbc;

import com.hzsolution.orders.db.jdbc.dao.EmployeeDAO;

import com.hzsolution.orders.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class EmployeeDAOTest {

    @Test
    public void testGetAllEmployees() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employeeList = employeeDAO.getAll();
        assert employeeList != null;
        log.info("" + employeeList.size());
        for(Employee e : employeeList) {
            log.info(e.toString());
        }

    }
}
