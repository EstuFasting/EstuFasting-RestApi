package edu.estu.estufastingrestapi.core.service.validation.annotations;

import edu.estu.estufastingrestapi.core.service.validation.validators.MaxCollectionSizeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = MaxCollectionSizeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxCollectionSize {

    int value() default 10;

    String message() default "The input list cannot contain more than {value} element.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
