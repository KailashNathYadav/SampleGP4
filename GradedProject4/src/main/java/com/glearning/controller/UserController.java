package com.glearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.dao.UserRepository;
import com.glearning.entities.User;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user")
	public List<User> getUser() {
		return this.userRepository.findAll();
	}
	
	@PostMapping("/user")
	public void saveUser(@RequestBody User user) {
		User userWithPlainPassword = user;
		userWithPlainPassword.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}
