package com.employeemgt.service;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.employeemgt.dao.AdminDAO;
import com.employeemgt.dao.UserDAO;
import com.employeemgt.dto.AdminDTO;
import com.employeemgt.dto.UserDTO;
import com.employeemgt.exception.RecordNotFoundException;
import com.employeemgt.utility.EmailBuilder;

@Service
public class UserService {

	@Autowired
	public UserDAO dao;
	
	@Autowired
	public AdminDAO Admindao;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public UserDTO Add(UserDTO dto) {
		
	UserDTO user = null;
	UserDTO userbyNumber = null;
	user = dao.findByEmail(dto.getEmail());
	userbyNumber = dao.findByEmpNumber(dto.getEmpNumber());
	System.out.println("user by email........: "+user);
	if(user != null || userbyNumber !=null) 
		throw new RecordNotFoundException("Email is already exists..");
	  //  System.out.println("dto Before Save: "+dto);
	    user = dao.save(dto);
	    return  user;
	}
	
	
	
	public UserDTO update(UserDTO user) {
		return dao.saveAndFlush(user);
	}
	
	public UserDTO editUser(long id) {
		return dao.findById(id);
	}
	
	public void delete(long id) {
		 dao.deleteById(id);
	}
	
	public List<UserDTO> search(String searchBy){
		List<UserDTO> list = dao.findByFirstName(searchBy);
		return list;
	}
	
	public List<UserDTO> list(){
		return dao.findAllByOrderByFirstName();
	}
	
	
	
	public  void sendMail(String toEmail, List<UserDTO> list) {
		
            
		
		
		
		try {
			
			String employeeData = EmailBuilder.getEmployeeData(list);
			MimeMessage createMimeMessage = javaMailSender.createMimeMessage();
			
			MimeMessageHelper helper= new MimeMessageHelper(createMimeMessage);
			helper.setTo(toEmail);
			helper.setSubject("Email List");
			helper.setText(employeeData,true);
			javaMailSender.send(createMimeMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	public AdminDTO Login(String username, String password) {
		AdminDTO user =	Admindao.findByUsernameAndPassword(username, password);
		return user;
	}
	

}
