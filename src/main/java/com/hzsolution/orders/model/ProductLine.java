package com.hzsolution.orders.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductLine {
	private String lineCode;
	private String description;
	private String html;
	private byte[] image;

}
