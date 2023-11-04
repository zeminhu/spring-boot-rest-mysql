package com.hzsolution.orders.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
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
