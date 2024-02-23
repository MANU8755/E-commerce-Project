package com.Ecommerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>{

	public Cart findByCartId(Long cartId);
	
	
	

}
