package com.example.shivagod.watchlist.entity.Rating;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingValidator.class)
public @interface Rating {

String message() default "Please Enter Greater than 5 and Less than 10 Only";
	
	Class<?>[]groups() default {};
	Class<? extends Payload>[] payload() default {};
}
