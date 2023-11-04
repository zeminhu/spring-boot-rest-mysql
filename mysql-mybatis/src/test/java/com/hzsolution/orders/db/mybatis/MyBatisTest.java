package com.hzsolution.orders.db.mybatis;

import com.hzsolution.orders.db.mybatis.mappers.EmployeeMapper;

import com.hzsolution.orders.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
// @MybatisTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// @ActiveProfiles("test")
public class MyBatisTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testGetAllEmployees() {
        log.info("test");
        List<Employee> employeeList = employeeMapper.getAll();

        assert employeeList != null;
        log.info("" + employeeList.size());
        for(Employee e : employeeList) {
            log.info(e.toString());
        }

    }
}
