package com.ty.shopapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ty.shopapp.dto.AppProducts;
import com.ty.shopapp.repository.ProductDao;
import com.ty.shopapp.response.ResponseStructure;

@Service
public class ProductsService {

	@Autowired
	private ProductDao productsDao;

	public ResponseStructure<?> createProducts(AppProducts appProducts) {
		AppProducts products = productsDao.createProducts(appProducts);
		ResponseStructure<AppProducts> responseStructure = new ResponseStructure<>();
		responseStructure.setData(products);
		responseStructure.setStatus(HttpStatus.CREATED);
		return responseStructure;
	}

	public ResponseStructure<?> findAllAppProducts() {
		List<AppProducts> appProducts = productsDao.findAllAppProducts();
		ResponseStructure<List<AppProducts>> responseStructure = new ResponseStructure<>();
		responseStructure.setData(appProducts);
		responseStructure.setStatus(HttpStatus.OK);
		return responseStructure;
	}

	public ResponseStructure<?> findByIdAppProducts(int appProdId) {
		AppProducts product = productsDao.findByIdAppProducts(appProdId);
		ResponseStructure<AppProducts> responseStructure = new ResponseStructure<>();
		responseStructure.setData(product);
		responseStructure.setStatus(HttpStatus.FOUND);
		return responseStructure;
	}

	public ResponseStructure<?> updateAppProducts(AppProducts appProducts) {
		AppProducts products = productsDao.updateAppProducts(appProducts);
		ResponseStructure<AppProducts> responseStructure = new ResponseStructure<>();
		responseStructure.setData(products);
		responseStructure.setStatus(HttpStatus.OK);
		return responseStructure;
	}

	public ResponseStructure<?> updatePartAppProducts(int appProdId, int curQty, int prodPrice) {
		AppProducts products = productsDao.updatePartAppProducts(appProdId,curQty, prodPrice);
		ResponseStructure<AppProducts> responseStructure = new ResponseStructure<>();
		responseStructure.setData(products);
		responseStructure.setStatus(HttpStatus.OK);
		return responseStructure;
	}

	public ResponseStructure<?> deleteByIdAppProducts(int appProdId) {
		productsDao.deleteByIdAppProducts(appProdId);
		ResponseStructure<AppProducts> responseStructure = new ResponseStructure<>();
		responseStructure.setData(null);
		responseStructure.setStatus(HttpStatus.OK);
		return responseStructure;
	}

	public ResponseStructure<?> findByCompanyName(String companyName) {
		List<AppProducts> companylist=productsDao.findByCompanyName(companyName);
		ResponseStructure<List<AppProducts>> responseStructure = new ResponseStructure<>();
		responseStructure.setData(companylist);
		responseStructure.setStatus(HttpStatus.FOUND);
		return responseStructure;
	}

	public ResponseStructure<?> updateQuantity(int id, int qnty) {
		productsDao.updateQuantity(id,qnty);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setData("Updated");
		responseStructure.setStatus(HttpStatus.OK);
		return responseStructure;
	}

	public ResponseStructure<?> deleteProd(int id) {
		productsDao.deleteProd(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setData("Deleted");
		responseStructure.setStatus(HttpStatus.OK);
		return responseStructure;
	}
}