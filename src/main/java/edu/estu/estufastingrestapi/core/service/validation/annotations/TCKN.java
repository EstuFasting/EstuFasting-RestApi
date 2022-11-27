package edu.estu.estufastingrestapi.core.service.validation.annotations;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.validation.validators.TCKNLongValidator;
import edu.estu.estufastingrestapi.core.service.validation.validators.TCKNStringValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Turkish republic identification number
 */
@Constraint(validatedBy = {TCKNLongValidator.class, TCKNStringValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TCKN {

    String message() default MsgCode.VALIDATION_DEFAULT_TCKN;

}
