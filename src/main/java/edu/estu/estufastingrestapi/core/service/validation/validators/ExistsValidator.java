package edu.estu.estufastingrestapi.core.service.validation.validators;

import edu.estu.estufastingrestapi.core.service.validation.annotations.Exists;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidatorContext;

@Component
public class ExistsValidator extends BaseDbConstraintValidator<Exists, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return true;
        boolean exists = dbValidationHelper.existsByField(constraint.entity(), constraint.fieldName(), value);
        return constraint.negate() ? BooleanUtils.negate(exists) : exists;
    }

}
