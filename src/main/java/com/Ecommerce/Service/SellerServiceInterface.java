package com.Ecommerce.Service;

import java.util.List;

import com.Ecommerce.Entity.Seller;

public interface SellerServiceInterface {
	
	
	public String sellerRegistration(Long customerId,Seller seller);
	
	public List<Seller> getAllseller();
	
	

}
