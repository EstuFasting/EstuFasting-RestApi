package edu.estu.estufastingrestapi.core.service.validation.annotations;

import edu.estu.estufastingrestapi.core.model.entities.abstracts.Entity;
import edu.estu.estufastingrestapi.core.service.validation.validators.ExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ExistsValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Exists.List.class)
public @interface Exists {

    /**
     * Entity class which wanted to be validated.
     */
    Class<? extends Entity> entity();

    /**
     * Field name of the entity which wanted to be validated.
     */
    String fieldName();

    /**
     * Should validation condition be negated?
     */
    boolean negate() default false;

    String message();

    Class<? extends Payload>[] payload() default {};

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @interface List {
        Exists[] value();
    }

}