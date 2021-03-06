package co.hillmerch.validations.validators;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = ZipCodeValidator.class)
@Documented
public @interface ZipCode {

	String message() default "{co.hillmerch.validations.validators.ZipCode.message}";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
