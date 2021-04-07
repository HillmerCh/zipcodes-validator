package co.hillmerch.validations;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.*;

class ShipmentTest {

	private final static String US_VALID_ZIPCODE = "94103";
	private final static String CANADA_VALID_ZIPCODE = "H4B 1W3";

	private final static String CANADA_VALID_LOWERCASE_ZIPCODE = "h4B 1w3";

	private final static String INVALID_ZIPCODE = "IS_NOT_A_ZIPCODE";

	private static Validator validator;

	@BeforeAll
	public static void setUpValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void when_OriginAndDestinationZipcode_AreNotValid_TWO_constraints_violations_are_returned(){
		Shipment shipment = new Shipment( INVALID_ZIPCODE,
										  INVALID_ZIPCODE);

		Set<ConstraintViolation<Shipment>> constraintViolations =
				validator.validate( shipment );

		printConstraintViolation(constraintViolations);

		assertEquals( 2, constraintViolations.size() );
		assertEquals( "Is not a valid zip code", constraintViolations.iterator().next().getMessage() );
	}

	@Test
	public void when_OriginAndDestinationZipcode_AreValid_NO_constraint_violations_are_returned(){
		Shipment shipment = new Shipment( US_VALID_ZIPCODE,
										  CANADA_VALID_ZIPCODE);

		Set<ConstraintViolation<Shipment>> constraintViolations =
				validator.validate( shipment );

		printConstraintViolation(constraintViolations);

		assertEquals( 0, constraintViolations.size() );
	}


	@Test
	public void when_OriginAndDestinationZipcode_AreCanadianLowerCasedValid_NO_constraint_violations_are_returned(){
		Shipment shipment = new Shipment( CANADA_VALID_LOWERCASE_ZIPCODE,
										  CANADA_VALID_LOWERCASE_ZIPCODE);

		Set<ConstraintViolation<Shipment>> constraintViolations =
				validator.validate( shipment );

		printConstraintViolation(constraintViolations);

		assertEquals( 0, constraintViolations.size() );
	}

	private static void printConstraintViolation(Set<ConstraintViolation<Shipment>> constraintViolations){
		constraintViolations.stream().forEach( System.out::println );
	}
}
