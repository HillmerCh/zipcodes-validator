package co.hillmerch.validations.validators;

import java.util.Locale;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

	private final static int US_ZIPCODE_LENGTH = 5;
	private final static int CANADA_ZIPCODE_LENGTH = 7;

	private final static String US_ZIPCODE_REGEX = "^[0-9]{5}(?:-[0-9]{4})?$";
	private final static String CANADA_ZIPCODE_REGEX = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";

	@Override
	public boolean isValid(String zipCode, ConstraintValidatorContext constraintContext) {
		if ( zipCode == null ) {
			return true;
		}

		boolean isValid = false;

		if(zipCode.length()==US_ZIPCODE_LENGTH){
			isValid = isZipCode( zipCode, US_ZIPCODE_REGEX );
		}else if(zipCode.length()==CANADA_ZIPCODE_LENGTH){
			isValid = isZipCode( zipCode.toUpperCase( Locale.ROOT ), CANADA_ZIPCODE_REGEX );
		}

		return isValid;
	}

	private boolean isZipCode(String zipCode, String countryRegex){
		return Pattern
				.compile( countryRegex )
				.matcher(zipCode)
				.matches();
	}



}
