package com.hzsolution.orders.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	// private Integer id;
	private String code;
	private String name;
	private String lineCode;
	private String scale;
	private String vendor;
	private String description;
	private int quantityInStock;
	private double buyPrice;
	private double MSRP;

}
