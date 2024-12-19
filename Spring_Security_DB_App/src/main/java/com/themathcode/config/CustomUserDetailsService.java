package com.themathcode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.themathcode.entity.Employee;
import com.themathcode.repository.EmpRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	EmpRepo empRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee emp = empRepo.findByEmail(email);
		
		if(emp == null) {
			throw new UsernameNotFoundException("User name not found");
		}
		return new CustomUser(emp);	
	}

}
