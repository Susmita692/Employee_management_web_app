package com.employeemgt.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class UserDTO extends BaseDTO {
	
	@Column(name = "empNumber")
	private int empNumber;
	
	@Column(name = "firstName", length = 755)
	private String firstName;

	@Column(name = "lastName", length = 755)
	private String lastName;
	
	@Column(name = "email", length = 755)
	private String email;
	
	@Column(name = "position", length = 755)
	private String position;
	
	@Column(name = "phoneNumber", length = 755)
	private String phoneNumber;

	@Override
	public String toString() {
		return "UserDTO [empNumber=" + empNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", position=" + position + ", phoneNumber=" + phoneNumber + "]";
	}



	
	
	
}
