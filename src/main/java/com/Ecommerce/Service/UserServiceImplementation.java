package com.Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.Ecommerce.DAO.UserRespository;
import com.Ecommerce.Entity.User;


@Service
public class UserServiceImplementation implements UserServiceInterface{
	
	
	@Autowired
	UserRespository respository;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Override
	public List<User> getAllUsers() {
		
		return respository.findAll();
	}


}
