package com.Ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Entity.OrderItem;
import com.Ecommerce.Service.OrderItemImplementation;

@CrossOrigin
@RestController
public class OrderItemController {
	
	@Autowired
	OrderItemImplementation orderItemImplementation;
	
	
	@PostMapping("/order/{orderId}/{productId}")
	public ResponseEntity<String> orderProducts(@PathVariable Long orderId,@PathVariable Long productId,@RequestBody OrderItem orderItem){
		
		return new ResponseEntity<String>(orderItemImplementation.OrderProducts(productId, orderId, orderItem), HttpStatus.OK);
	}
 	
	
	
	@GetMapping("/order/{customerId}")
	public ResponseEntity<List<OrderItem>> getAllOrderItemBasedOnCustomerId(@PathVariable Long customerId){
		
		return new ResponseEntity<List<OrderItem>>(orderItemImplementation.getAllOrderItemBasedOnCustomerId(customerId), HttpStatus.OK);
	}
	

}
