package com.employeemgt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemgt.dto.UserDTO;

public interface UserDAO extends JpaRepository<UserDTO, Long> {
	
	public UserDTO findByEmail(String email);
	public UserDTO findByEmpNumber(int empNumber);
	public UserDTO findById(long id);

	public List<UserDTO> findAllByOrderByFirstName();
	
	public List<UserDTO> findByFirstName(String firstName);
	public List<UserDTO> findByLastName(String searchBy);
	public List<UserDTO> findByPhoneNumber(String searchBy);
	
}
