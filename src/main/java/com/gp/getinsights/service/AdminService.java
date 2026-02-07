package com.gp.getinsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.getinsights.entity.Admin;
import com.gp.getinsights.repository.AdminRepository;

@Service
public class AdminService
{
	@Autowired
	private AdminRepository adminRepo;
	
	public String login(String username, String password)
	{
		Admin admin = adminRepo.findByUsername(username);
		if(admin != null && admin.getPassword().equals(password))
		{
			return"Admin login successful";
		}
		return "Invalid admin credentials";
	}
	
}
