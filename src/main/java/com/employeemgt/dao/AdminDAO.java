package com.employeemgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemgt.dto.AdminDTO;


public interface AdminDAO extends JpaRepository<AdminDTO, Long> {
	
	public AdminDTO findByUsernameAndPassword(String username, String password);
	
}