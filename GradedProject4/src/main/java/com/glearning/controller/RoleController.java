package com.glearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.dao.RoleRepository;
import com.glearning.entities.Role;

@RestController
@RequestMapping("/api")
public class RoleController {
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/role")
	public List<Role> getRole(){
		return this.roleRepository.findAll();
	}
	
	@PostMapping("/role")
	public void addRole(@RequestBody Role role) {
		roleRepository.save(role);
	}
}
