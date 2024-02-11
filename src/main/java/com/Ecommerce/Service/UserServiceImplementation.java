package com.Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

//	@Override
//	public List<User> getAllUsers() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public User getUserById(Long userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void createUser(User user) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void updateUser(Long userId, User updatedUser) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteUser(Long userId) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void changePassword(Long userId, String newPassword) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<User> searchUsers(String keyword) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void toggleUserStatus(Long userId, boolean enabled) {
//		// TODO Auto-generated method stub
//		
//	}
	
//	
//	public AuthenticationResponse register(RegisterRequest request) {
//
//        User user = new User();
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setUsername(request.getUsername());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//
//        user.setRole(request.getRole());
//
//        user = repository.save(user);
//
//        Map<String, Object> extraclaims = new HashMap<>();
//
//        System.err.println(user.getAuthorities());
//        user.getAuthorities().stream().forEach(authority -> {
//            extraclaims.put("authority", authority);
//        });
//
//        String jwtToken = jwtService.generateToken(extraclaims, user);
//
//        return new AuthenticationResponse(jwtToken);
//    }
//
//
//}

}
