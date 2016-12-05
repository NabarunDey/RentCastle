package com.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class RetypePasswordValidator extends FieldValidatorSupport  {

	public void validate(Object object) throws ValidationException {
	//	String fieldName = getFieldName();
		String password = (String)this.getFieldValue("password", object);
		String cnfPassword = (String)this.getFieldValue("cnfPassword", object);
		if (!password.equals(cnfPassword)) {
			addFieldError("cnfPassword", object);
		}
	}
}
