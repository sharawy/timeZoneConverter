package com.timeZone.validators.annotations;


import com.timeZone.validators.StringTimeDateValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = StringTimeDateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StringTimeDate {

	
	String message() default "{date format should be yyyy-MM-dd HH:mm}";
	String format () default "yyyy-MM-dd HH:mm";
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	 
}