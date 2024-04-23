package com.ty.shopapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ty.shopapp.dto.AppProducts;

public interface AppProductsRepository extends JpaRepository<AppProducts, Integer> {
	
	public List<AppProducts> findByCompanyName(String companyName);
	
	@Transactional
	@Modifying
	@Query
	(value = "update app_products set cur_qty=?1 where app_prod_id=?2", nativeQuery = true)
	public int updateQuantity(int quantity, int appProdId);
	
	@Transactional
	@Modifying
	@Query
	(value = "delete from app_products where app_prod_id=?1", nativeQuery = true)
	public int deleteProd(int appProdId);
}
