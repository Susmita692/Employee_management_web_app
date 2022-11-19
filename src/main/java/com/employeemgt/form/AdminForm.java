package com.employeemgt.form;

import javax.validation.constraints.NotEmpty;

import com.employeemgt.dto.AdminDTO;
import com.employeemgt.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminForm {

	@NotEmpty(message = "User name is required")
	private String username;

	@NotEmpty(message = "Password is required")
	private String password;
	
	
	public AdminDTO getDTO() {
		AdminDTO bean=new AdminDTO();
		bean.setUsername(username);
        bean.setPassword(password);

		return bean;
	}

	public void populate(AdminDTO bean) {
		username=bean.getUsername();
		password = bean.getPassword();
		

	}

}
