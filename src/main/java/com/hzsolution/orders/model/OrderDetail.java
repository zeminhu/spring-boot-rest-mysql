package com.hzsolution.orders.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetail {
	private Integer id;
	private String productCode;
	private Integer quantity;
	private double unitPrice;
	private int orderLineNumber;

	private String status;
}
