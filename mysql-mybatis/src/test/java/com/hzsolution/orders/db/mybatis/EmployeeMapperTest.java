package com.hzsolution.orders.db.mybatis;

import com.hzsolution.orders.db.mybatis.mappers.EmployeeMapper;
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
public class EmployeeMapperTest {
	@Autowired
	EmployeeMapper employeeMapper;

	int employeeId = 0;
	
	@Test
	@Order(1) 
	public void insertANewEmployeesIntoDatabase() {
		Employee employee = new Employee(0,"e123-557","Mike","Trent","407-432-4466","x4858", "big-bird@disney.com", 55000, "2", 1088, "Senior Sale Rep");
		employeeMapper.insert(employee);
		assert employee != null : "inserted failure";
		employeeId = employee.getId();
		Employee employee1 =employeeMapper.getById(employeeId);
		assert employee1 != null : "newly inserted employee not found";
		assert employee1.getFirstName().equals("Mike") : "no matching: FirstName";
	}
	
	@Test
	@Order(2) 
	public void whenEmployeesInDatabase_shouldReturnEmployeeWithGivenId() {
		Employee employee = employeeMapper.getById(1002);
		assert employee != null : "no employee from database";
		assert employee.getFirstName().equals("Diane") : "employee: employee id is not correct";
		log.info("" + employee);
	}
	
	@Test
	@Order(3) 
	public void whenEmployeesInDatabase_shouldReturnEmployeeList() {
		List<Employee> employees = employeeMapper.getAll();
		assert employees != null : "no employee from database";
		assert employees.size() > 0 : "empty employee list";
		log.info("number of employees: " + employees.size());
	}
	
	@Test
	@Order(4) 
	public void deleteNewlyInsertedById() {
		employeeMapper.deleteById(employeeId);
		Employee employee = employeeMapper.getById(employeeId);
		assert employee == null : "employee should be deleted";
	}		
}
