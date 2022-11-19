package com.employeemgt.form;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailForm {

	protected long id;
	
	@NotNull(message = "Email is required")
	private String toEmail;
}
