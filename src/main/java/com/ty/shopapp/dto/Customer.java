package com.ty.shopapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Customer name cannot be null/empty/blank")
	private String custName;
	@NotBlank(message = "Customer address cannot be null/empty/blank")
	private String address;
	
	@NotBlank(message = "Customer email cannot be null/empty/blank")
	@Email(message = "Email is not in valid format")
	private String email;
	
	@NotBlank(message = "Customer password cannot be null/empty/blank")
	@Size(min = 6,max = 10,message = "password must min 6 chars max 10 chars")
	private String password;
	
	@NotNull(message = "phone cannot be null")
	private Long phone;
	@NotBlank(message = "Customer state cannot be null/empty/blank")
	private String state;
	@NotNull(message = "phone cannot be null")
	private Integer pincode;
	
	
//	private Customer myProfile;
	
}