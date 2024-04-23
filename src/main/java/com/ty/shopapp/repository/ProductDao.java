package com.ty.shopapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.shopapp.dto.AppProducts;
import com.ty.shopapp.exception.CompanyNotFoundException;
import com.ty.shopapp.exception.NoProductfoundException;
import com.ty.shopapp.exception.ProductIdNotFoundException;


@Repository
public class ProductDao {
	
	
	@Autowired
	private AppProductsRepository repository;
	
	
	public AppProducts createProducts(AppProducts appProducts) {
		return repository.save(appProducts);
	}

	public List<AppProducts> findAllAppProducts() {
		List<AppProducts> list =repository.findAll();
		if (list.isEmpty()) {
			throw new NoProductfoundException("No product available");
		}
		return list;
	}

	public AppProducts findByIdAppProducts(int appProdId) {
		Optional<AppProducts> product = repository.findById(appProdId);
		if (product.isPresent()) {
			return product.get();
		}
		throw new ProductIdNotFoundException("Product Id Not found");
	}

	public AppProducts updateAppProducts(AppProducts appProducts) {
		Optional<AppProducts> products = repository.findById(appProducts.getAppProdId());
		if (products.isPresent()) {
			return repository.save(appProducts);
		}
		throw new ProductIdNotFoundException("Product Id Not found");
	}

	
	public AppProducts updatePartAppProducts(int appProdId, int curQty, int prodPrice) {
		Optional<AppProducts> products = repository.findById(appProdId);
		if(products.isPresent()) {
			AppProducts appProducts =products.get();
			appProducts.setCurQty(curQty);
			appProducts.setProdPrice(prodPrice);
			return repository.save(appProducts);
		}
		throw new ProductIdNotFoundException("Product Id Not found");
	}

	public void deleteByIdAppProducts(int appProdId) {
		Optional<AppProducts> products = repository.findById(appProdId);
		if (products.isPresent()) {
			 repository.deleteById(appProdId);
		}
	}

	public List<AppProducts> findByCompanyName(String companyName) {
		List<AppProducts> companylist = repository.findByCompanyName(companyName);
		if (companylist.isEmpty()) {
			throw new CompanyNotFoundException("Company Not Found");
		}
		return companylist;
	}

	public int  updateQuantity(int id, int qnty) {
		int n = repository.updateQuantity(id, qnty);
		if (n>0) {
			return n;
		}
		throw new ProductIdNotFoundException("product id not found");
		
	}

	public int deleteProd(int id) {
		int x=repository.deleteProd(id);
		if (x>0) {
			return x;
		}
		throw new ProductIdNotFoundException("product id not found");
	}
}
