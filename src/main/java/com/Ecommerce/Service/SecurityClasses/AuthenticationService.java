package com.Ecommerce.Service.SecurityClasses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Ecommerce.DAO.UserRespository;
import com.Ecommerce.Entity.User;
import com.Ecommerce.ExceptionHandling.UserNotFoundException;
import com.Ecommerce.Service.CartServiceImplementation;
import com.Ecommerce.Service.OrderServiceImplementation;
import com.Ecommerce.Util.AppConstant;

import java.time.LocalDate;
import java.util.List;


@Service
public class AuthenticationService {

    private final UserRespository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    private final AuthenticationManager authenticationManager;

    @Autowired
    CartServiceImplementation cartServiceImplementation;
    
    @Autowired
    OrderServiceImplementation orderServiceImplementation;
    
    @Autowired
    LoginDetails loginDetails;

    

    public AuthenticationService(UserRespository repository, PasswordEncoder passwordEncoder, JwtService jwtService,
			 AuthenticationManager authenticationManager) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	public String register(User request) {

        // check if user already exist. if exist than authenticate the user
		UserDetails userCheck = repository.findBycustomerEmailId(request.getCustomerEmailId());
		   if (userCheck != null) {
	            return "User already exists";
	        }

        User user = new User();
        user.setCustomerName(request.getCustomerName());
        user.setCustomerEmailId(request.getCustomerEmailId());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCustomerPhoneNumber(request.getCustomerPhoneNumber());
        user.setSeller(request.isSeller());
        user.setRole(request.getRole());
        user.setCreatedAt(LocalDate.now());
        user = repository.save(user);
        cartServiceImplementation.addCartDetails(user);
        orderServiceImplementation.generateOrderId(user);

        String jwt = jwtService.generateToken(user);
//
//        saveUserToken(jwt, user);

        return  "User registration was successful";

    }

	

    
    
    public LoginDetails authenticate(User request) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getCustomerEmailId(),
                            request.getPassword()
                    )
            );

            // Retrieve user details
            UserDetails user = repository.findBycustomerEmailId(request.getCustomerEmailId());;
            if (user == null) {
                
            	throw new UserNotFoundException(AppConstant.userLoginWrongCredentialsInfo);
            }

;            // Compare encoded passwords
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                
            	throw new UsernameNotFoundException(AppConstant.userLoginInfo);
            }
	
            User userDetails = repository.findByCustomerEmailId(request.getCustomerEmailId());
          
            if (userDetails == null) {
              
          	throw new UserNotFoundException(AppConstant.userLoginWrongCredentialsInfo);
          	
          }
            
           
            // Generate JWT
            String jwt = jwtService.generateToken(user);
            
            LoginDetails loginDetails = new LoginDetails();
            
            loginDetails.setCustomerId(userDetails.getCustomerId());
            
            loginDetails.setCustomerName(userDetails.getCustomerName());
            
            loginDetails.setSellerOrNot(userDetails.isSeller());
            
            loginDetails.setToken(jwt);
            
            
            return loginDetails;
            
        
    }

//    
//    private void saveUserToken(String jwt, User user) {
//        Token token = new Token();
//        token.setToken(jwt);
//        token.setLoggedOut(false);
//        token.setUser(user);
//        tokenRepository.save(token);
//    }
}
