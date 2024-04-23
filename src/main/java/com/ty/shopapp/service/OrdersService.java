package com.ty.shopapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.shopapp.dto.Orders;
import com.ty.shopapp.repository.OrdersDao;
import com.ty.shopapp.response.ResponseStructure;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersDao dao;

	public ResponseStructure<?> createOrder(Orders orders) {
		Orders order = dao.createOrder(orders);
		ResponseStructure<Orders> responseStructure = new ResponseStructure<>();
		responseStructure.setData(order);
		responseStructure.setStatus(HttpStatus.CREATED);
		return responseStructure;
	}

}
