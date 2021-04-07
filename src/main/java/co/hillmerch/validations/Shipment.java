package co.hillmerch.validations;

import co.hillmerch.validations.validators.ZipCode;
import jakarta.validation.constraints.NotNull;

public class Shipment {

	@NotNull
	@ZipCode
	private final String originZipCode;
	@NotNull
	@ZipCode
	private final String destinationZipCode;

	public Shipment(String originZipCode, String destinationZipCode) {
		this.originZipCode = originZipCode;
		this.destinationZipCode = destinationZipCode;
	}


}
