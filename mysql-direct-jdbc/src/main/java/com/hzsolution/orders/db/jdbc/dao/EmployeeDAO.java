package com.hzsolution.orders.db.jdbc.dao;



import com.hzsolution.orders.model.Employee;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EmployeeDAO {
    String sqlSelectAllPersons = "SELECT * FROM employees";
    String connectionUrl = "jdbc:mysql://localhost:3306/southern-parts?autoReconnect=true&useSSL=false";

    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<Employee>();
        try (
            Connection conn = DriverManager.getConnection(connectionUrl, "user", "admin@2019");
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
            ResultSet rs = ps.executeQuery()) {
/*
            Employee employee1 = new Employee(100, "empId100", "Howard", "Newman", "123-456-789", "278",null, 100,"office-10",10100,"manager");
            Employee employee2 =  new Employee(101, "empId101", "Jeniffer", "Muller", "123-456-789", "279",null, 100,"office-10",10100,"manager");
            employees.add(employee1);
            employees.add(employee2);
*/
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setJobTitle(rs.getString("jobTitle"));
                employee.setOfficeCode(rs.getString("officeCode"));
                employee.setExtension(rs.getString("extension"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            log.error("DAO SQL exception: " + e.getMessage());
            return null;
        }
    }

}
