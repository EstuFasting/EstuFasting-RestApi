package edu.estu.estufastingrestapi.core.service.validation.annotations;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.validation.validators.ScheduleConflictCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Field types should be {@link Comparable}
 */
@Constraint(validatedBy = ScheduleConflictCheckValidator.class)
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface ScheduleConflictCheck {

    String message() default MsgCode.VALIDATION_DEFAULT_SCHEDULE_CONFLICT_CHECK;

    String startFieldName() default "start";

    String endFieldName() default "end";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
