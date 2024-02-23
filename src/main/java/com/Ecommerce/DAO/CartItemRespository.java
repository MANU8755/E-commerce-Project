
package com.Ecommerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.Ecommerce.Entity.CartItem;

import jakarta.transaction.Transactional;


public interface CartItemRespository extends JpaRepository<CartItem, Long> {

	 
    @Transactional
    @Modifying
    @Query("DELETE FROM CartItem ci WHERE ci.product.productId = :productId")
    public void deleteByProductId(Long productId);

	 
	 
}
