package com.employeemgt.ctl;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.employeemgt.dto.UserDTO;
import com.employeemgt.exception.RecordNotFoundException;
import com.employeemgt.form.UserForm;
import com.employeemgt.service.UserService;

@Controller
public class UserCtl {
	
	@Autowired
	public UserService service;
	
	@GetMapping("/registration")
	public String RegistrationPage(@ModelAttribute("form")UserForm form) {
		return "registration";
	}
	
	@PostMapping("/AddUser")
	public String Add(@Valid @ModelAttribute("form")UserForm form,  BindingResult bindingResult, Model model) {

		System.out.println("form: "+form);
	    long id = form.getId();
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "registration";
		}else {
			UserDTO bean = form.getDTO();
			if(id>0) {
				service.update(bean);
				model.addAttribute("success", "Employee Update successfully");
			}else {
				
				service.Add(bean);
				model.addAttribute("success", "Registration successfully");
					
			}
			return "registration";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "registration";
		}
			
	
	}

}
