package com.ty.shopapp.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.shopapp.dto.Customer;
import com.ty.shopapp.exception.CustomerEmailIdNotFoundException;
import com.ty.shopapp.exception.CustomerIdNotFoundException;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository repository;

	public Customer insertCustomer(Customer customer) {
		return repository.save(customer);
	}

	public Customer updatePassword(String password, int id) {
		Optional<Customer> customer = repository.findById(id);
		if (customer.isPresent()) {
			Customer cust = customer.get();
			cust.setPassword(password);
			return repository.save(cust);
		}
		throw new CustomerIdNotFoundException("Customer ID Not Found");
	}

	public Customer updateEmail(String email, int id) {
		Optional<Customer> customer = repository.findById(id);
		if (customer.isPresent()) {
			Customer cust = customer.get();
			cust.setEmail(email);
			return repository.save(cust);
		}
		throw new CustomerIdNotFoundException("Customer ID Not Found");
	}

	public Customer updatePhone(long phone, int id) {
		Optional<Customer> customer = repository.findById(id);
		if (customer.isPresent()) {
			Customer cust = customer.get();
			cust.setPhone(phone);
			return repository.save(cust);
		}
		throw new CustomerIdNotFoundException("Customer ID Not Found");
	}

	public void deleteByEmail(String email) {
		Optional<Customer> findByEmail = repository.findByEmail(email);
		if (findByEmail.isPresent()) {
			repository.deleteByEmail(email);
		} else {
			throw new CustomerEmailIdNotFoundException("Customer email ID Not Found");
		}
	}

}
