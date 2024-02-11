package com.Ecommerce.Service.SecurityClasses;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Ecommerce.DAO.TokenRepository;
import com.Ecommerce.DAO.UserRespository;
import com.Ecommerce.Entity.Token;
import com.Ecommerce.Entity.User;


import java.util.List;


@Service
public class AuthenticationService {

    private final UserRespository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final TokenRepository tokenRepository;

    private final AuthenticationManager authenticationManager;


    

    public AuthenticationService(UserRespository repository, PasswordEncoder passwordEncoder, JwtService jwtService,
			TokenRepository tokenRepository, AuthenticationManager authenticationManager) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.tokenRepository = tokenRepository;
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
        user = repository.save(user);

        String jwt = jwtService.generateToken(user);

        saveUserToken(jwt, user);

        return  "User registration was successful";

    }

    public String authenticate1(User request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getCustomerEmailId(),
                        request.getPassword()
                )
        );

        UserDetails user = repository.findBycustomerEmailId(request.getCustomerEmailId());
        String jwt = jwtService.generateToken(user);

        List<Token> validTokens = tokenRepository.findAllTokensByUser(((User) user).getCustomerId());
        if(validTokens.isEmpty()) {
            return "Please enter a valid token";
        }

        validTokens.forEach(t-> {
            t.setLoggedOut(true);
        });

        tokenRepository.saveAll(validTokens);


        return "User login was successful";

    }
    public String authenticate(User request) {
        try {
            // Attempt authentication
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getCustomerEmailId(),
                            request.getPassword()
                    )
            );

            // Retrieve user details
            UserDetails user = repository.findBycustomerEmailId(request.getCustomerEmailId());
//            UserDetails userPassword = repository.findByPassword(request.getPassword());
//            String hashedPassword = passwordEncoder.encode(request.getPassword());
            if (user == null) {
                return "User not found";
            }

            // Compare encoded passwords
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return "Invalid password";
            }
	
           
            // Generate JWT
            String jwt = jwtService.generateToken(user);

            // Retrieve valid tokens for the user
            List<Token> validTokens = tokenRepository.findAllTokensByUser(((User) user).getCustomerId());
            if (validTokens.isEmpty()) {
                return "Please enter a valid token";
            }

            // Invalidate existing tokens
            validTokens.forEach(t -> {
                t.setLoggedOut(true);
            });

            tokenRepository.saveAll(validTokens);

            return jwt;
        } catch (AuthenticationException e) {
            // Authentication failed
            return "Authentication failed: " + e.getMessage();
        } catch (Exception e) {
            // Other unexpected errors
            return "An unexpected error occurred: " + e.getMessage();
        }
    }

    
    private void saveUserToken(String jwt, User user) {
        Token token = new Token();
        token.setToken(jwt);
        token.setLoggedOut(false);
        token.setUser(user);
        tokenRepository.save(token);
    }
}
