package com.employeemgt.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employeemgt.dto.UserDTO;
import com.employeemgt.form.MailForm;
import com.employeemgt.form.UserForm;
import com.employeemgt.service.UserService;

@Controller
public class EmpListCtl {
	
	@Autowired
	UserService service;
	
	@GetMapping("/empListPage")
	public String EmployeeListPage(@ModelAttribute("form")UserForm form, Model model) {
		List<UserDTO> list =  service.list();
		System.out.println("List: "+list);
		model.addAttribute("emplist", list);
		return "empList";
	}
	
	@GetMapping("/empEdit")
	public String EditEmployee(@ModelAttribute("form")UserForm form,@RequestParam("id") long id, Model model) {		
	UserDTO user =	service.editUser(id);	
	form.populate(user);
	model.addAttribute("user", user);
	return "registration";
	}
	
	@GetMapping("/empDelete")
	public String DeleteEmployee(@ModelAttribute("form")UserForm form, @RequestParam("id") long id, Model model) {
		System.out.println("id: "+id);
		service.delete(id);
		model.addAttribute("success","Employee Deleted Successfully");
		List<UserDTO> list =  service.list();
		System.out.println("List: "+list);
		model.addAttribute("emplist", list);
		return "empList";
	}
	
	@PostMapping("/search")
	public String search(@ModelAttribute("form")UserForm form,  Model model) {
		//System.out.println("id: "+id);
		List<UserDTO> list = service.search(form.getFirstName());		
		System.out.println("List: "+list);
		model.addAttribute("emplist", list);
		return "empList";
	}
	
	@GetMapping("/sendMailPage")
	public String navtomail(@ModelAttribute("form")MailForm form) {
		return "mailpage";
	}
	
	@PostMapping("/sendMail")
	public String sendMail(@ModelAttribute("form")MailForm form, Model model) {
		List<UserDTO> list =  service.list();
		
		service.sendMail(form.getToEmail(), list);
		model.addAttribute("success", "Message Sent Successfully");
		
		return "mailpage";
	}
	
	
	

}
