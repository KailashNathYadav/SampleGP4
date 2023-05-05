package com.glearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.glearning.dao.UserRepository;
import com.glearning.entities.User;
import com.glearning.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
		@Autowired
		private UserRepository userRepository;
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userRepository.findByUsername(username);
			if(user == null)
				throw new UsernameNotFoundException("Could not find user");
			return new UserDetailsImpl(user);
		}
}
