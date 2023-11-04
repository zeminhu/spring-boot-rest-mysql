package com.hzsolution.orders.db.mybatis.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzsolution.orders.db.mybatis.mappers.EmployeeMapper;

import com.hzsolution.orders.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class EmployeeService {
	@Autowired
	EmployeeMapper employeeMapper;

    public void insert(String body) throws JsonParseException, JsonMappingException, IOException {
    	ObjectMapper mapper = new ObjectMapper();
		Employee employee = mapper.readValue(body, Employee.class);

    	employeeMapper.insert(employee);
    }
	public void insert(Employee employee) throws IOException {
		employeeMapper.insert(employee);
	}

    public Employee getById(int id) {
    	return employeeMapper.getById(id);
    }
    
    public List<Employee> getAll() {
    	return employeeMapper.getAll();
    }

    public void update(String body) throws JsonParseException, JsonMappingException, IOException {
    	ObjectMapper mapper = new ObjectMapper();
		Employee employee = mapper.readValue(body, Employee.class);
		
    	employeeMapper.update(employee);
    }

	public void update(Employee employee) throws IOException {
		employeeMapper.update(employee);
	}

    public void deleteById(int id) {
    	employeeMapper.deleteById(id);
    }
}
