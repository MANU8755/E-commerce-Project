package com.Ecommerce.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.DAO.ProductRepository;
import com.Ecommerce.DAO.SellerRepository;
import com.Ecommerce.DAO.UserRespository;
import com.Ecommerce.DTO.MessageInfo;
import com.Ecommerce.Entity.ProductName;
import com.Ecommerce.Entity.Seller;
import com.Ecommerce.Entity.User;
import com.Ecommerce.ExceptionHandling.ProductNotFoundException;
import com.Ecommerce.ExceptionHandling.UserNotFoundException;
import com.Ecommerce.Util.AppConstant;


@Service
public class SellerServiceImplementation implements SellerServiceInterface{
	
	
	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
	UserRespository userRespository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public MessageInfo sellerRegistration(Long customerId , Seller sellerRequest) {
		
		User userDetails = userRespository.findByCustomerId(customerId);
		if(userRespository.existsById(customerId)) {
			
			if(userDetails.isSeller()) {
				
				return new MessageInfo(AppConstant.SellerAlreadyRegistered);
			}
			else {
				
				Seller seller = new Seller();
				
				seller.setSellerName(sellerRequest.getSellerName());
				seller.setGstNo(sellerRequest.getGstNo());
				seller.setSellerPhoneNumber(sellerRequest.getSellerPhoneNumber());
				seller.setCreatedAt(LocalDate.now());
				seller.setUser(userDetails);
				userDetails.setSeller(true);
				
				sellerRepository.save(seller);
				

				return  new MessageInfo(AppConstant.SellerRegistrationStatus);				
			}
		}
		else {
			
			throw new UserNotFoundException(AppConstant.UserIdNotFound);
		}
		
		
	}

	@Override
	public List<Seller> getAllseller() {
		// TODO Auto-generated method stub
		return sellerRepository.findAll();
	}

	@Override
	public MessageInfo updateProductAddedBySeller(ProductName product, Long customerId) {
		
		if(productRepository.existsById(product.getProductId())) {
			
			ProductName productName = productRepository.findByProductId(customerId);
			
			if(userRespository.existsById(customerId)) {
				
				User userDetails = userRespository.findByCustomerId(customerId);
				
				if(userDetails.isSeller()) {

					productName.setProductName(product.getProductName());
					productName.setProductImage1(product.getProductImage1());
					productName.setProductCost(product.getProductCost());
					productName.setUpdatedAt(LocalDate.now());
					productName.setDescription(product.getDescription());
					
					productRepository.save(productName);
					
				}
				
				
			}
			else {
				
				throw new UserNotFoundException(AppConstant.UserIdNotFound);
			}
			
		}
		else {
			throw new ProductNotFoundException(AppConstant.productIdNotFound);
		}
		
		
		return null;
	}
	
	
	
	
	

}
