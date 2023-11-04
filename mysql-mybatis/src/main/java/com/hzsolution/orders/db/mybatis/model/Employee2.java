package com.hzsolution.orders.db.mybatis.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee2 {
	private Integer id;
	private String employeeId;
	private String firstName;
	private String lastName;
	private String phone;
	private String extension;
	private String email;
	private int salary;
	private String officeCode;
	private Integer reportsTo;
	private String jobTitle;
}
