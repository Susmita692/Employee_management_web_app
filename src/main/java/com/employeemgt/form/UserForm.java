package com.employeemgt.form;

import java.util.Date;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.employeemgt.dto.UserDTO;
import com.employeemgt.utility.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
	
	protected long id;
	
	@NotNull(message = "Employee Number is required")
	private int empNumber;
	
	@NotEmpty(message = "First name is required")
	private String firstName;

	@NotEmpty(message = "Last name is required")
	private String lastName;

	
	@NotEmpty(message = "email is required")
	private String email;
	
	@NotEmpty(message = "position is required")
	private String position;
	
	@NotEmpty(message = "phoneNumber is required")
	private String phoneNumber;
	
    

	
	public UserDTO getDTO() {
		UserDTO bean=new UserDTO();
		bean.setId(id);
		bean.setEmpNumber(empNumber);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setEmail(email);
		bean.setPosition(position);
		bean.setPhoneNumber(phoneNumber);


		return bean;
	}

	public void populate(UserDTO bean) {
		id = bean.getId();
		empNumber=bean.getEmpNumber();
		firstName=bean.getFirstName();
		lastName=bean.getLastName();
		email = bean.getEmail();
		position = bean.getPosition();
		phoneNumber = bean.getPhoneNumber();


	}

	@Override
	public String toString() {
		return "UserForm [empNumber=" + empNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", position=" + position + ", phoneNumber=" + phoneNumber + "]";
	}


	
	
	

	
	

}
