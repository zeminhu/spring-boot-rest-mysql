package com.hzsolution.orders.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment {
	private Integer customerId;
	private String checkNumber;
	private Date paymentDate;
	private double amount;

}
