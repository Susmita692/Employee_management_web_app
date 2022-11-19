package com.employeemgt.form;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentForm {

	@NotEmpty(message = "Department name is required")
	private String deptName;
}
