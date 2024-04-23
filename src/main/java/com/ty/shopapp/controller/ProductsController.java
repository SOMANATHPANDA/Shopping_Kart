package com.ty.shopapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ty.shopapp.dto.AppProducts;
import com.ty.shopapp.response.ResponseStructure;
import com.ty.shopapp.service.ProductsService;

@RestController
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@PostMapping(path = "/prods")
	public ResponseEntity<?> createProducts(@RequestBody AppProducts appProducts){
		ResponseStructure<?> responseStructure = productsService.createProducts(appProducts);
		return new ResponseEntity<>(responseStructure, responseStructure.getStatus());
	}
	
	@GetMapping(path = "/prodfetch")
	public ResponseEntity<?> findAllAppProducts(){
		ResponseStructure<?> responseStructure = productsService.findAllAppProducts();
		return new ResponseEntity<>(responseStructure, responseStructure.getStatus());
	}
	
	
	@GetMapping(path = "/byid/{appProdId}")
	public ResponseEntity<?> findByIdAppProducts(@PathVariable int appProdId){
		ResponseStructure<?> responseStructure = productsService.findByIdAppProducts(appProdId);
		return new ResponseEntity<>(responseStructure, responseStructure.getStatus());
	}
	
	
	@PutMapping(path = "/update")
	public ResponseEntity<?> updateAppProducts(@RequestBody AppProducts appProducts){
		ResponseStructure<?> responseStructure = productsService. updateAppProducts(appProducts);
		return new ResponseEntity<>(responseStructure, responseStructure.getStatus());
	}
	
	
	@PatchMapping(path = "/partUpdate/{appProdId}/{curQty}/{prodPrice}")
	public ResponseEntity<?> updatePartAppProducts(@PathVariable int appProdId, @PathVariable int curQty, @PathVariable int prodPrice){
		ResponseStructure<?> responseStructure = productsService.updatePartAppProducts(appProdId, curQty, prodPrice);
		return new ResponseEntity<>(responseStructure, responseStructure.getStatus());
	}
	
	
	@DeleteMapping(path = "/deletion")
	public ResponseEntity<?> deleteByIdAppProducts(@RequestParam int appProdId){
		ResponseStructure<?> responseStructure = productsService.deleteByIdAppProducts(appProdId);
		return new ResponseEntity<>(responseStructure,responseStructure.getStatus());
	}
	
	@GetMapping(path = "/company")
	public ResponseEntity<?> findByCompanyName(@RequestParam String companyName){
		ResponseStructure<?> responseStructure = productsService.findByCompanyName(companyName);
		return new ResponseEntity<>(responseStructure,responseStructure.getStatus());
	}
	
	@PatchMapping(path = "/updateqty/{id}/{qnty}")
	public ResponseEntity<?> updateQuantity(@PathVariable int id, @PathVariable int qnty){
		ResponseStructure<?> responseStructure = productsService.updateQuantity(id, qnty);
		return new ResponseEntity<>(responseStructure,responseStructure.getStatus());
	}
	
	@DeleteMapping(path = "/delete")
	public ResponseEntity<?> deleteProd(@RequestParam int id){
		ResponseStructure<?> responseStructure = productsService.deleteProd(id);
		return new ResponseEntity<>(responseStructure,responseStructure.getStatus());
	}
	
	
	
	
	
	
}