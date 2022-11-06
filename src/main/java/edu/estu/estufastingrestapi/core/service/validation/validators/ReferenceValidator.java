package edu.estu.estufastingrestapi.core.service.validation.validators;

import edu.estu.estufastingrestapi.core.service.validation.annotations.Reference;
import edu.estu.estufastingrestapi.core.service.validation.validators.abstraction.BaseDbConstraintValidator;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidatorContext;

@Component
public class ReferenceValidator extends BaseDbConstraintValidator<Reference, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return true;
        return dbValidationHelper.existsByField(constraint.entity(), constraint.fieldName(), value);
    }

}
