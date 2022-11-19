package com.employeemgt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.employeemgt.service.UserService;

@SpringBootApplication
public class EmployeemgtApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeemgtApplication.class, args);
	}
	
	
}
