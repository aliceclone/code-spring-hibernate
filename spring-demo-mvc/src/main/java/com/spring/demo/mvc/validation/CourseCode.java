package com.spring.demo.mvc.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface CourseCode {

	public String value() default CourseCodeConstraintValidator.DEFAULT_PREFIX;

	public String message() default "Must start with WEB";

	// default group
	public Class<?>[] groups() default {};

	// default payload
	public Class<? extends Payload>[] payload() default {};

}
