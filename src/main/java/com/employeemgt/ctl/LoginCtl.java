package com.employeemgt.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.employeemgt.dto.AdminDTO;
import com.employeemgt.dto.UserDTO;
import com.employeemgt.service.UserService;

@Controller
public class LoginCtl {
	
	@Autowired
	public UserService service;
	
	@GetMapping("/loginView")
	public String LoginPage() {
		return "login";
	}
	
	@PostMapping("/auth")
	public String Login(@ModelAttribute("form") AdminDTO dto, Model model, HttpSession session) {
		
	AdminDTO user =	service.Login(dto.getUsername(), dto.getPassword());
	if(user == null) {
		model.addAttribute("error", "Invalid UserName or Password");
		return "login";
	}else {
		session.setAttribute("user", user);
		return "home";
	}
	
		
	}

}
