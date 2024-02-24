package com.Ecommerce.Service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.DAO.CartItemRespository;
import com.Ecommerce.DAO.CartRepository;
import com.Ecommerce.DAO.ProductRepository;
import com.Ecommerce.DAO.UserRespository;
//import com.Ecommerce.DAO.UserRespository;
import com.Ecommerce.Entity.Cart;
import com.Ecommerce.Entity.CartItem;
import com.Ecommerce.Entity.ProductName;
import com.Ecommerce.ExceptionHandling.CartIdNotFoundException;
import com.Ecommerce.ExceptionHandling.CartItemEmptyException;
import com.Ecommerce.ExceptionHandling.ProductNotFoundException;
import com.Ecommerce.ExceptionHandling.UserNotFoundException;
import com.Ecommerce.Util.AppConstant;
//import com.Ecommerce.Entity.User;



@Service
public class CartItemImplementation implements CartItemInterface{
	
	@Autowired
	CartRepository cartRepository;

	@Autowired
	CartItemRespository cartItemRespository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRespository userRespository;
	
	
	
	@Override
	public String addProductsToCart(Long ProductId,Long cartId,CartItem cartItem) {
//		
//		User userDetails = userRespository.findByCustomerId(userId);
		System.out.println("productId is $" + ProductId);

		
		if(productRepository.existsById(ProductId)) {

			ProductName product = productRepository.findByProductId(ProductId);
			
			if(productRepository.existsById(cartId)) {
				
				Cart cartDetails = cartRepository.findByCartId(cartId);
				
				CartItem cartItemdetails = new CartItem();
				
				cartItemdetails.setProduct(product);
				//cartItemdetails.setUser(userDetails);
				cartItemdetails.setProductQuantity(cartItem.getProductQuantity());
				cartItemdetails.setCart(cartDetails);
				//System.out.println(product.getProductCost());
				cartItemdetails.setTotalPurchasePrice((cartItem.getProductQuantity()) * (product.getProductCost()));
				cartItemdetails.setCreatedAt(LocalDate.now());
				
				cartItemRespository.save(cartItemdetails);
				
				return "Product added successfully to the User Cart";
				
			}
			else {
				throw new CartIdNotFoundException(AppConstant.CartIdNotFound);
				
			}
			
		}
		else {
			
			throw new ProductNotFoundException(AppConstant.productIdNotFound);
		}
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


	@Override
	public List<CartItem> getAllCartItemBasedOnCustomerId(Long customerId) {
		
		if(userRespository.existsById(customerId)) {

			UserDetails userDetails =  userRespository.findByCustomerId(customerId);
			
			Cart cartDetails = cartRepository.findByCustomer(userDetails);
			
			if(cartDetails != null) {
				if(cartRepository.existsById(cartDetails.getCartId())) {
					
					List<CartItem> cartItemDetails = cartItemRespository.findByCart(cartDetails);
					
					if(cartItemDetails.isEmpty()) {
						
						throw new CartItemEmptyException(AppConstant.CartItemIsEmpty);
						
					}
					else {

						return cartItemDetails;
						
					}
					
					
				}
					else {
						throw new CartIdNotFoundException(AppConstant.CartIdNotFound);
					}
				
			}
			else {
				throw new CartIdNotFoundException(AppConstant.CartIdNotFound);
			}
			
			
		}
		else {
			throw new UserNotFoundException(AppConstant.userLoginWrongCredentialsInfo);
		}
		
	}
	
	
		

}
