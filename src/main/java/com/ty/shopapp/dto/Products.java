package com.ty.shopapp.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prodId;
	
	private String prodName;
	private Integer prodPrice;
	private Integer prodQnty;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Orders orders;
	
}
