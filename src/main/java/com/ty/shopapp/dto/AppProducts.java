package com.ty.shopapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class AppProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appProdId;
	@NotBlank(message = "product name can't be null")
	private String appProdName;
	@NotBlank(message = "company name can't be null")
	private String companyName;
	@NotNull(message = "price cant be null")
	private Integer prodPrice;
	@NotBlank(message = "product type can't be null")
	private String prodType;
	@NotNull(message = "product quantity can't be null")
	private Integer curQty;
}