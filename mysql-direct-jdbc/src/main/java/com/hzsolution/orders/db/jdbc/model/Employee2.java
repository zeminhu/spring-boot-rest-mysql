package com.hzsolution.orders.db.jdbc.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
