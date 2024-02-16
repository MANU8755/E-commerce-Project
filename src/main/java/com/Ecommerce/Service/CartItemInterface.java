package com.Ecommerce.Service;

import java.util.List;

import com.Ecommerce.Entity.CartItem;

//import com.Ecommerce.Entity.CartItem;

public interface CartItemInterface {

      public String addProductsToCart(Long productId,Long CartId,CartItem cartItem);
      
      public List<CartItem> getAllCartItems();
	
	
}
