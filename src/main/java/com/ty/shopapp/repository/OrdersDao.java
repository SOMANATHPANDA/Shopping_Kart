package com.ty.shopapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.shopapp.dto.Orders;

@Repository
public class OrdersDao {
	
	@Autowired
	private OrdersRepository repository;

	public Orders createOrder(Orders orders) {
		return repository.save(orders);
	}

}
