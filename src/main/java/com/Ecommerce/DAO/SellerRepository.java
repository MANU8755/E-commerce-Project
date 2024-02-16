package com.Ecommerce.DAO;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{
	
	
	public Seller findBySellerName(String sellerName);
	
	public Seller findBySellerId(Long sellerId);
	
	
	@Override
	default List<Seller> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

}
