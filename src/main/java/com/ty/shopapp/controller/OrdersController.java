package com.ty.shopapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.shopapp.dto.Orders;
import com.ty.shopapp.response.ResponseStructure;
import com.ty.shopapp.service.OrdersService;

@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService service;
	
	
	@PostMapping(path = "/createOrder")
	public ResponseEntity<?> createOrder(@RequestBody Orders orders){
		ResponseStructure<?> responseStructure = service.createOrder(orders);
		return new ResponseEntity<>(responseStructure,responseStructure.getStatus());
	}
	
	

}