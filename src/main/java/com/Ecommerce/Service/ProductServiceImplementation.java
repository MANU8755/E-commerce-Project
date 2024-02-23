package com.Ecommerce.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.DAO.CategoryRepository;
import com.Ecommerce.DAO.ProductRepository;
import com.Ecommerce.DAO.SellerRepository;
import com.Ecommerce.Entity.CategoryType;
import com.Ecommerce.Entity.ProductName;
import com.Ecommerce.Entity.Seller;

@Service
public class ProductServiceImplementation implements  ProductServiceInterface{
	
	
	
	@Autowired
	ProductRepository  productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	SellerRepository sellerRepository;

	@Override
	public List<ProductName> getProductsInCart(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addProducts(Long categoryId,Long sellerId,ProductName productRequest) {
		
		CategoryType categoryType = categoryRepository.findByCategoryId(categoryId);
		
		Seller seller = sellerRepository.findBySellerId(sellerId);
		
		ProductName  product =  new ProductName();
		
		product.setProductName(productRequest.getProductName());
		product.setProductImage1(productRequest.getProductImage1());
		product.setProductImage2(productRequest.getProductImage2());
		product.setProductImage3(productRequest.getProductImage3());
		product.setProductImage4(productRequest.getProductImage4());
        product.setCategoryType(categoryType);
        product.setSeller(seller);
        product.setCreatedAt(LocalDate.now());
        product.setDescription(productRequest.getDescription());
        product.setProductQuantity(productRequest.getProductQuantity());
        
        productRepository.save(product);
        
       
		return "Prodcuct Added successfully";
	}

	@Override
	public List<ProductName> getAllProducts() {
		
		
		return productRepository.findAll();
	}

	@Override
	public List<ProductName> categoryWiseProductsList(Long categoryId) {
		
		if(categoryRepository.existsById(categoryId)) {
			
			List<ProductName> categoryWiseProducts = productRepository.findByCategoryId(categoryId);
			
			return categoryWiseProducts;
		}

		return null;
	}

	
}
