package edu.estu.estufastingrestapi.core.service.validation.validators;

import edu.estu.estufastingrestapi.core.domain.helper.ReflectionHelper;
import edu.estu.estufastingrestapi.core.service.validation.annotations.ScheduleConflictCheck;
import edu.estu.estufastingrestapi.core.service.validation.validators.abstraction.BaseConstraintValidator;

import javax.validation.ConstraintValidatorContext;

public class ScheduleConflictCheckValidator extends BaseConstraintValidator<ScheduleConflictCheck, Object> {

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        String startGetterName = ReflectionHelper.getGetterNameOfFieldName(constraint.startFieldName());
        String endGetterName = ReflectionHelper.getGetterNameOfFieldName(constraint.endFieldName());
        Comparable start = ReflectionHelper.getFieldValueByGetter(object, startGetterName, Comparable.class).orElse(null);
        Comparable<?> end = ReflectionHelper.getFieldValueByGetter(object, endGetterName, Comparable.class).orElse(null);
        if (start == null || end == null) return true;
        else return start.compareTo(end) < 0;
    }

}
