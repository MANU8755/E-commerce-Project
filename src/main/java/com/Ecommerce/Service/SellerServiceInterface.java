package com.Ecommerce.Service;

import java.util.List;

import com.Ecommerce.DTO.MessageInfo;
import com.Ecommerce.Entity.ProductName;
import com.Ecommerce.Entity.Seller;

public interface SellerServiceInterface {
	
	
	public MessageInfo sellerRegistration(Long customerId,Seller seller);
	
	public List<Seller> getAllseller();
	
	public MessageInfo updateProductAddedBySeller(ProductName productName,Long customerId);
	
	public MessageInfo deleteProductAddedBySeller(Long productId,Long customerId);
	
	
}
