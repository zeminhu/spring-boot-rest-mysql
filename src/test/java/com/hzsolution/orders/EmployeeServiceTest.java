package com.hzsolution.orders;

import com.hzsolution.orders.model.Employee;
import com.hzsolution.orders.repository.EmployeeRepository;
import com.hzsolution.orders.service.EmployeeService;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    Employee employee;

    @InjectMocks
    EmployeeService employeeService;

    @BeforeEach
    public void init() {
        employee = new Employee(1001, "empId1001", "Howard", "Newman", "123-456-789", "278",null, 100,"office-10",10100,"manager");
    }

    @Test
    public void noParam_whenInitialized_returnAllEmployees() throws Exception {
        when(employeeRepository.getAll()).thenReturn(new ArrayList<Employee>());
        List<Employee> employees = employeeService.getAll();
        verify(employeeRepository, times(1)).getAll();
        assert employees != null;
        assert employees.isEmpty();
    }

    @Test
    public void noParam_whenInitialized_getEmployeeByID() throws Exception {
        when(employeeRepository.getById("1001")).thenReturn(employee);
        Employee employee2 = employeeService.getById("1001");
        verify(employeeRepository, times(1)).getById("1001");
        assert employee2 != null;
        assert employee2.getEmployeeId().equals("empId1001");


    }
}
