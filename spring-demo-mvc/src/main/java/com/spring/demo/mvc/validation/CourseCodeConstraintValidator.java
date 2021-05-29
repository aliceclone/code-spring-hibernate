package com.spring.demo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	public static final String DEFAULT_PREFIX = "WEB";

	private String coursePrefix;

	@Override
	public void initialize(CourseCode constraintAnnotation) {
		coursePrefix = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String input, ConstraintValidatorContext validator) {

		if (input != null) {
			return input.startsWith(coursePrefix, 0);
		}

		return true;
	}

}
