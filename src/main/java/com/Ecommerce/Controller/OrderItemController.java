package com.Ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Entity.OrderItem;
import com.Ecommerce.Service.OrderItemImplementation;

@RestController
public class OrderItemController {
	
	@Autowired
	OrderItemImplementation orderItemImplementation;
	
	
	@PostMapping("/order/{orderId}/{productId}")
	public ResponseEntity<String> orderProducts(@PathVariable Long orderId,@PathVariable Long productId,@RequestBody OrderItem orderItem){
		
		return new ResponseEntity<String>(orderItemImplementation.OrderProducts(productId, orderId, orderItem), HttpStatus.OK);
	}
 	

}
