package com.firman.validators;

import com.firman.exception.ExceptionMessagesConstants;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Created by firman on 6/22/19.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CityValidator.class)
@Documented
public @interface CityConstraint
{
    String message() default ExceptionMessagesConstants.CITY_UNDEFINED;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
