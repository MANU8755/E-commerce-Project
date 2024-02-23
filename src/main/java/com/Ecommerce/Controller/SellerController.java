package com.Ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Entity.Seller;
import com.Ecommerce.Service.SellerServiceImplementation;

@RestController
public class SellerController {
	
	@Autowired
	SellerServiceImplementation sellerServiceImplementation;
	
	
	@PostMapping("/sellerRegister/{customerId}")
	public ResponseEntity<String> RegisterSellerDetails(@PathVariable Long customerId,@RequestBody Seller sellerRequest){
		return new ResponseEntity<String>(sellerServiceImplementation.sellerRegistration(customerId,sellerRequest),HttpStatus.OK);
		
	}
	
	@GetMapping("/getsellerdetails")
	public ResponseEntity<List<Seller>> getAllUsers(){
		return new ResponseEntity<List<Seller>>(sellerServiceImplementation.getAllseller(), HttpStatus.OK);
	}

}