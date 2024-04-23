package com.ty.shopapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.shopapp.dto.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
