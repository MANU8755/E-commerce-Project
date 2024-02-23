package com.Ecommerce.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.DAO.CartItemRespository;
import com.Ecommerce.DAO.CartRepository;
import com.Ecommerce.DAO.ProductRepository;
//import com.Ecommerce.DAO.UserRespository;
import com.Ecommerce.Entity.Cart;
import com.Ecommerce.Entity.CartItem;
import com.Ecommerce.Entity.ProductName;
//import com.Ecommerce.Entity.User;



@Service
public class CartItemImplementation implements CartItemInterface{
	
	@Autowired
	CartRepository cartRepository;

	@Autowired
	CartItemRespository cartItemRespository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	
	@Override
	public String addProductsToCart(Long ProductId,Long cartId,CartItem cartItem) {
//		
//		User userDetails = userRespository.findByCustomerId(userId);
		System.out.println("productId is $" + ProductId);

		
		if(!productRepository.existsById(ProductId)) {
			return "Please enter a valid productID";
		}
		if(!productRepository.existsById(cartId)) {
			return "Please enter a valid cartID";
		}
		ProductName product = productRepository.findByProductId(ProductId);
		
		Cart cartDetails = cartRepository.findByCartId(cartId);
		
		CartItem cartItemdetails = new CartItem();
		
		cartItemdetails.setProduct(product);
		//cartItemdetails.setUser(userDetails);
		cartItemdetails.setProductQuantity(cartItem.getProductQuantity());
		cartItemdetails.setCart(cartDetails);
		cartItemdetails.setProductUnitPrice(cartItem.getProductUnitPrice());
		//System.out.println(product.getProductCost());
		cartItemdetails.setTotalPurchasePrice((cartItem.getProductQuantity()) * (cartItem.getProductUnitPrice()));
		cartItemdetails.setCreatedAt(LocalDate.now());
		
		cartItemRespository.save(cartItemdetails);
		
		return "Product added successfully to the User Cart";
	}


	@Override
	public List<CartItem> getAllCartItems() {
		// TODO Auto-generated method stub
		return cartItemRespository.findAll();
	}




	@Override
	public String deleteItemsFromCart(Long productId,Long cartId) {
		
	    System.out.println("Received cartId: " + cartId); 
	    
		if(cartRepository.existsById(cartId)) {
			cartItemRespository.deleteByProductId(productId);

			return "product removed from the cart";
			
		}
		else {
			return "cart id is not even existed";
		}
		
	}
	
	
		

}
