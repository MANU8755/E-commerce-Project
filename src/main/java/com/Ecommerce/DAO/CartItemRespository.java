
package com.Ecommerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Ecommerce.Entity.CartItem;

public interface CartItemRespository extends JpaRepository<CartItem, Long> {

	

}
