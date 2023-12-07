package com.example.shivagod.watchlist.entity.Rating;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class RatingValidator implements ConstraintValidator<Rating, Float> {



	@Override
	public boolean isValid(Float value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value > 5 && value <= 10;
	}

}
