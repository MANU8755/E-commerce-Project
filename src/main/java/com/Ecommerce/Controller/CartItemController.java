package com.Ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Entity.CartItem;
import com.Ecommerce.Service.CartItemImplementation;

@RestController
public class CartItemController {
	
	@Autowired
	CartItemImplementation cartItemImplementation;
	
	@PostMapping("/cart/{productId}/{cartId}")
	public ResponseEntity<String> addProductToCart(@PathVariable Long productId,@PathVariable Long cartId,@RequestBody CartItem cartItem){
		return new ResponseEntity<String>(cartItemImplementation.addProductsToCart(productId, cartId, cartItem), HttpStatus.OK);
		
	}
	
	@GetMapping("/cart")
	public ResponseEntity<List<CartItem>> getAllCartItems(){
		return new ResponseEntity<List<CartItem>>(cartItemImplementation.getAllCartItems(), HttpStatus.OK);
	}
	
	@DeleteMapping("/cart/{productId}/{cartId}")
	public ResponseEntity<String> deleteProdutFromCart(@PathVariable Long productId,@PathVariable Long cartId){
		return new ResponseEntity<String>(cartItemImplementation.deleteItemsFromCart(productId,cartId),HttpStatus.OK);
	}
	
	
}
 