package com.employeemgt.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tomail")
public class MailDTO extends BaseDTO {


	
	@NotNull(message = "Email is required")
	private String toEmail;
}
