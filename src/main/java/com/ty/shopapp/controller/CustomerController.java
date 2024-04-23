 package com.ty.shopapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.shopapp.dto.Customer;
import com.ty.shopapp.response.ResponseStructure;
import com.ty.shopapp.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	@PostMapping(path = "/insertCustomer")
	public ResponseEntity<?> insertCustomer(@RequestBody Customer customer){
		ResponseStructure<?> responseStructure = service.insertCustomer(customer);
		return new ResponseEntity<>(responseStructure,responseStructure.getStatus());
	}
	
	@PatchMapping(path = "/password")
	public ResponseEntity<?> updatePassword(@RequestParam String password, @RequestParam int id){
		ResponseStructure<?> responseStructure = service.updatePassword(password,id);
		return new ResponseEntity<>(responseStructure,responseStructure.getStatus());
	}
	
	@PatchMapping(path = "/email")
	public ResponseEntity<?> updateEmail(@RequestParam String email,@RequestParam int id){
		ResponseStructure<?> responseStructure = service.updateEmail(email,id);
		return new ResponseEntity<>(responseStructure,responseStructure.getStatus());
	}
	
	@PatchMapping(path = "/phone")
	public ResponseEntity<?> updatePhone(@RequestParam long phone,@RequestParam int id){
		ResponseStructure<?> responseStructure = service.updatePhone(phone,id);
		return new ResponseEntity<>(responseStructure,responseStructure.getStatus());
	}

	@DeleteMapping(path = "/deleteByEmail")
	public ResponseEntity<?> deleteByEmail(@RequestParam String email){
		ResponseStructure<?> responseStructure = service.deleteByEmail(email);
		return new ResponseEntity<>(responseStructure,responseStructure.getStatus());
	}
	
	@GetMapping(path = "/fetchCustomer")
	public ResponseEntity<?> fetchCustomer(@RequestParam String email, @RequestParam String password){
		return null;
	}
}