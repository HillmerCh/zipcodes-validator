package co.hillmerch.validations.validators;

import org.hibernate.validator.internal.util.annotation.ConstraintAnnotationDescriptor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeValidatorTest {
	private final static String US_VALID_ZIPCODE = "94103";
	private final static String CANADA_VALID_ZIPCODE = "H4B 1W3";
	private final static String CANADA_VALID_LOWERCASE_ZIPCODE = "h4B 1w3";
	private final static String INVALID_ZIPCODE = "IS_NOT_A_ZIPCODE";

	private static ZipCodeValidator zipCodeValidator;

	@BeforeAll
	public static void setUpValidator(){
		zipCodeValidator = new ZipCodeValidator();
	}

	@Test
	public void when_a_US_valid_zipocode_is_validated_THE_validation_must_be_true() {
		zipCodeValidator.initialize( initializeAnnotation() );
		assertTrue( zipCodeValidator.isValid( US_VALID_ZIPCODE, null ) );
	}

	@Test
	public void when_a_Canada_valid_zipocode_is_validated_THE_validation_must_be_true() {
		zipCodeValidator.initialize( initializeAnnotation() );
		assertTrue( zipCodeValidator.isValid( CANADA_VALID_ZIPCODE, null ) );
	}


	@Test
	public void when_a_Canada_lower_cased_valid_zipocode_is_validated_THE_validation_must_be_true() {
		zipCodeValidator.initialize( initializeAnnotation() );
		assertTrue( zipCodeValidator.isValid( CANADA_VALID_LOWERCASE_ZIPCODE, null ) );
	}

	@Test
	public void when_a_invalid_zipocode_is_validated_THE_validation_must_be_false() {
		zipCodeValidator.initialize( initializeAnnotation() );
		assertFalse( zipCodeValidator.isValid( INVALID_ZIPCODE, null ) );
	}

	private ZipCode initializeAnnotation() {
		return new ConstraintAnnotationDescriptor.Builder<>(ZipCode.class)
				.build()
				.getAnnotation();
	}


}
