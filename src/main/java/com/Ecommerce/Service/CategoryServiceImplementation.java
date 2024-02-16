package com.Ecommerce.Service;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.DAO.CategoryRepository;
import com.Ecommerce.Entity.CategoryType;

@Service
public class CategoryServiceImplementation implements CategoryServiceInterface{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	

	@Override
	public String addCategoryItems(CategoryType categoryType) {
		// TODO Auto-generated method stub
		
		CategoryType category = new CategoryType();
		
		category.setCategoryName(categoryType.getCategoryName());
		category.setCategoryImage(categoryType.getCategoryImage());
		category.setCreatedAt(LocalDate.now());
		
		categoryRepository.save(category);
		categoryRepository.findByCategoryId(1);
		
		return "Category added successfully";
	}

//	@Override
//	public String addCategoryItems(CategoryType categoryType) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getAllCategory() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	

}
