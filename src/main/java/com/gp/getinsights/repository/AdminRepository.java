package com.gp.getinsights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.getinsights.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>
{
	Admin findByUsername(String username);
}
