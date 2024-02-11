package com.Ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Entity.User;
import com.Ecommerce.Service.UserServiceImplementation;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImplementation serviceImplementation;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> usersList(){
		return new ResponseEntity<List<User>>(serviceImplementation.getAllUsers(),HttpStatus.ACCEPTED);
	}
	
    @GetMapping("/demo")
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok("Hello from secured url");
    }

    @GetMapping("/admin_only")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Hello from admin only url");
    }

	

}
