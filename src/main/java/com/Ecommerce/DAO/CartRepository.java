package com.Ecommerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>{
	
//	public List<ProductName> addProduct();
	
	
//	@Query("SELECT p.ProductName,p.productImage1,p.productCost FROM Cart c JOIN ProductName p ON p.productId = c.product.productId WHERE p.productId = :productId")
//	public ProductName findProductInCart(@Param("productId") Long productId);
//	
//	
//    //this query will find the quantity of each product based on the productid in the table
//	@Query("SELECT c.productQuantity FROM Cart c JOIN ProductName p ON p.productId = c.product.productId WHERE p.productId = :productId")
//	public int findProductQuantityBasedOnProductIdInCart(@Param("productId") Long productId);
//
//	

	

}
