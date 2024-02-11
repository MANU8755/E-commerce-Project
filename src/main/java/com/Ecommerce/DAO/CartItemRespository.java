
package com.Ecommerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Ecommerce.Entity.CartItem;

public interface CartItemRespository extends JpaRepository<CartItem, Long> {

//    @Query("SELECT CASE WHEN COUNT(ci) > 0 THEN true ELSE false END FROM CartItem ci WHERE ci.user.id = :userId AND ci.cart.id = :cartId AND ci.product.id = :productId")
//    public boolean existsByUserIdAndCartIdAndProductId(@Param("userId") Long userId, @Param("cartId") Long cartId, @Param("productId") Long productId);
//    
}
