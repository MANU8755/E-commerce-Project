package com.Ecommerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Entity.ProductName;

public interface ProductRepository extends JpaRepository<ProductName,Long>{
	
	public ProductName findByProductId(Long productId);
	


}
