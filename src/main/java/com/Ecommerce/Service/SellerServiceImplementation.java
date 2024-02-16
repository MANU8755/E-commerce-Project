package com.Ecommerce.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.DAO.SellerRepository;
import com.Ecommerce.DAO.UserRespository;
import com.Ecommerce.Entity.Seller;
import com.Ecommerce.Entity.User;


@Service
public class SellerServiceImplementation implements SellerServiceInterface{
	
	
	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
	UserRespository userRespository;
//	
//	@Autowired
//	Seller seller;
	
	@Override
	public String sellerRegistration(Long customerId , Seller sellerRequest) {
		
		User userDetails = userRespository.findByCustomerId(customerId);
//		
		Seller seller = new Seller();
		

		seller.setSellerName(sellerRequest.getSellerName());
		seller.setGstNo(sellerRequest.getGstNo());
		seller.setSellerPhoneNumber(sellerRequest.getSellerPhoneNumber());
		seller.setCreatedAt(LocalDate.now());
		seller.setUser(userDetails);
		userDetails.setSeller(true);
		
		sellerRepository.save(seller);

		return  "Seller registration successful";
		
		
	}

	@Override
	public List<Seller> getAllseller() {
		// TODO Auto-generated method stub
		return sellerRepository.findAll();
	}
	
	
	
	

}
