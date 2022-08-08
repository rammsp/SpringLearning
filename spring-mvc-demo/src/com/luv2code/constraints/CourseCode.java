package com.luv2code.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidation.class)
@Target ({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	public String value() default "LUV";
	
	public String message() default "Code must start with LUV";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default{};
	


}
