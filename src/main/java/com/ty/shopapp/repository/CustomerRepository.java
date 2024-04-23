package com.ty.shopapp.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.shopapp.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Transactional
	public void deleteByEmail(String email);

	
	public Optional<Customer> findByEmail(String email);
	
	
}
