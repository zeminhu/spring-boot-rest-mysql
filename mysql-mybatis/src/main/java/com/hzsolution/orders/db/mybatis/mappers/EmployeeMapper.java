package com.hzsolution.orders.db.mybatis.mappers;


import com.hzsolution.orders.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    final String insert = "insert into employees(firstName,lastName,extension,email,officeCode,reportsTo,jobTitle)"
            + " values(#{firstName},#{lastName},#{extension},#{email},#{officeCode},#{reportsTo},#{jobTitle})";
    final String getById = "select id,firstName,lastName,extension,email,officeCode,reportsTo,jobTitle from employees where id=#{id}";
    //final String getByEmployeeId = "select id, employee_id, first_name,last_name,phone,email,salary from employees where employee_id=#{employeeId}";
    final String getAll = "select id,firstName,lastName,extension,email,officeCode,reportsTo,jobTitle from employees";
    final String update = "update employees set firstName=#{firstName}, lastName=#{lastName},"
            + "extension=#{extension},email=#{email},officeCode=#{officeCode}, reportsTo=#{reportsTo},jobTitle=#{jobTitle} where id=#{id}";
    final String deleteById = "delete from employees where id=#{id}";

    @Insert(insert)
    // @SelectKey(statement="call identity()", keyProperty="id", before=false, resultType=Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn="id")
    void insert(Employee employee);

    @Select(getById)
    @Results(id="EmployeeResult", value= {
            @Result(column="id", property="id", id=true),
            @Result(column="firstName", property="firstName"),
            @Result(column="lastName", property="lastName"),
            @Result(column="extension", property="extension"),
            @Result(column="email", property="email"),
            @Result(column="officeCode", property="officeCode"),
            @Result(column="reportsTo", property="reportsTo"),
            @Result(column="jobTitle", property="jobTitle")
    })
    Employee getById(int id);

//    @Select(getByEmployeeId)
//    @ResultMap("EmployeeResult")
//    Employee getByEmployeeId(String employeeId);

    @Select(getAll)
    @ResultMap("EmployeeResult")
    List<Employee> getAll();

    @Update(update)
    void update(Employee employee);

    @Delete(deleteById)
    void deleteById(int id);
}
