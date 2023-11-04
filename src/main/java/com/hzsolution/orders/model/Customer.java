package com.hzsolution.orders.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private Integer id;
    // private String userId;
    private String customerName;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    // private String street;
    private String city;
	private String state;
	private String country;
    private String postalCode;
    private String phone;
    private String email;
    private Integer salesRepId;
    private double creditLimit;
}
