package com.hzsolution.orders.repository;

import com.hzsolution.orders.model.Employee;
import com.hzsolution.orders.service.EmployeeService;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private static Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
    /*
      private DatabaseConfig databaseConfig;
      @Autowired
      public void setDatabaseConfig(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
      }
    */
    List<Employee> employees;
    Employee employee1, employee2;

    @PostConstruct
    public void initEmployees() {
        employees = new ArrayList<Employee>();
        employee1 = new Employee(100, "empId100", "Howard", "Newman", "123-456-789", "278",null, 100,"office-10",10100,"manager");
        employee2 =  new Employee(101, "empId101", "Jeniffer", "Muller", "123-456-789", "279",null, 100,"office-10",10100,"manager");
        employees.add(employee1);
        employees.add(employee2);
    }

    public Employee getById(String employeeId) throws JSONException {
        return employee1;
/*    SqlSession sqlSession = null;
    try {
      sqlSession = databaseConfig.initializeDBSFactory().openSession();
      employee = sqlSession.selectOne("Employee.selectById", new Integer(1165));
    } catch (Exception e) {
      logger.severe("getById exception: " + e.getMessage());
    } finally {
      if (sqlSession != null) {
        sqlSession.close();
      }
      return employee;
    }*/
    }

    public List<Employee> getAll() {
        return employees;
/*    SqlSession sqlSession = null;
    try {
      sqlSession = databaseConfig.initializeDBSFactory().openSession();
      employees = sqlSession.selectList("Employee.selectAll");
    } catch (Exception e) {
      logger.severe("getById exception: " + e.getMessage());
    } finally {
      if (sqlSession != null) {
        sqlSession.close();
      }
      return employees;
    }*/
    }

  public void insert(Employee employee) {
        employees.add(employee);
        // logger.error("Not implemented");
  }

  public void update(String datasetId) {
      logger.error("Not implemented");
  }
}
