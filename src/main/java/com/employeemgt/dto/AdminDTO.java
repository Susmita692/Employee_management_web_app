package com.employeemgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="admin")
@Getter
@Setter
public class AdminDTO extends BaseDTO {
	
	
	@Column(name = "username", length = 755)
	private String username;

	@Column(name = "password", length = 755)
	private String password;
	

}
