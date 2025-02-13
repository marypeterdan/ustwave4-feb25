package com.stackroute.passenger.validations;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<Country,String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		 
		List<String> countrylist=Arrays.asList("india","bdesh");
		return countrylist.contains(value.toLowerCase());
	}

}
