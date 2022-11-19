package com.employeemgt.ctl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employeemgt.service.UserService;

@Controller
public class HomeCtl {
	
	@Autowired
	private  UserService userService;

	
	@GetMapping("/")
	public String homePage() {
		
		return "home";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

}
