package com.hzsolution.orders.db.springdata.jpa;

import com.hzsolution.orders.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
