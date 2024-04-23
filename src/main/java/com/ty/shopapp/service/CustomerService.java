package com.ty.shopapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.shopapp.dto.Customer;
import com.ty.shopapp.repository.CustomerDao;
import com.ty.shopapp.response.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	
	public ResponseStructure<?> insertCustomer(Customer customer) {
		 Customer cust =dao.insertCustomer(customer);
		 ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		 responseStructure.setData(cust);
		 responseStructure.setStatus(HttpStatus.CREATED);
		return responseStructure;
	}

	public ResponseStructure<?> updatePassword(String password, int id) {
		Customer customer = dao.updatePassword(password,id);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(customer);
		responseStructure.setStatus(HttpStatus.OK);
		return responseStructure;
	}

	public ResponseStructure<?> updateEmail(String email, int id) {
		Customer customer = dao.updateEmail(email,id);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(customer);
		responseStructure.setStatus(HttpStatus.OK);
		return responseStructure;
	}

	public ResponseStructure<?> updatePhone(long phone, int id) {
		Customer customer = dao.updatePhone(phone,id);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(customer);
		responseStructure.setStatus(HttpStatus.OK);
		return responseStructure;
		
	}

	public ResponseStructure<?> deleteByEmail(String email) {
		dao.deleteByEmail(email);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setData("Deleted");
		responseStructure.setStatus(HttpStatus.OK);
		return responseStructure;
	}

}
