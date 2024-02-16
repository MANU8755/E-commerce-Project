package com.Ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Entity.CategoryType;
import com.Ecommerce.Service.CategoryServiceImplementation;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryServiceImplementation categoryServiceImplementation;
	
	@PostMapping("/category")
	public ResponseEntity<String> addCategory(@RequestBody CategoryType categoryType){
		return new ResponseEntity<String>(categoryServiceImplementation.addCategoryItems(categoryType), HttpStatus.OK);
	}

}
