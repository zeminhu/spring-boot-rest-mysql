package com.hzsolution.orders.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Office {
	private String officeCode;
	private String city;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String country;
	private String postalCode;
	private String territory;

}
