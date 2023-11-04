package com.hzsolution.orders.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
	private Integer id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
	private Date orderDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
	private Date requiredDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
	private Date shippedDate;
	
	private String status;
	private String comments;
	private Integer customerId;
	
	private List<OrderDetail> orderDetails;
	
}
