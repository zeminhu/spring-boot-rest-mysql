package com.hzsolution.orders;

import com.hzsolution.orders.controller.EmployeeController;
import com.hzsolution.orders.model.Employee;
import com.hzsolution.orders.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeService employeeService;

    @Test
    public void testAddEmployee()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(employeeService.insert(any(Employee.class))).thenReturn(true);

        Employee employee = new Employee(1001, "empId100", "Howard", "Newman", "123-456-789", "278",null, 100,"office-10",10100,"manager");
        ResponseEntity<Object> responseEntity = employeeController.addEmployee(employee);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1001");
    }

    @Test
    public void testFindAll()
    {
        // given
        Employee employee1 = new Employee(100, "empId100", "Howard", "Newman", "123-456-789", "278",null, 100,"office-10",10100,"manager");
        Employee employee2 =  new Employee(101, "empId101", "Jeniffer", "Muller", "123-456-789", "279",null, 100,"office-10",10100,"manager");
        List<Employee> employees = Arrays.asList(employee1, employee2);

        when(employeeService.getAll()).thenReturn(employees);

        // when
        List<Employee> employeeList = employeeController.getEmployees();

        // then
        assertThat(employeeList.size()).isEqualTo(2);

        assertThat(employeeList.get(0).getFirstName()).isEqualTo(employee1.getFirstName());

        assertThat(employeeList.get(1).getFirstName()).isEqualTo(employee2.getFirstName());
    }
}
