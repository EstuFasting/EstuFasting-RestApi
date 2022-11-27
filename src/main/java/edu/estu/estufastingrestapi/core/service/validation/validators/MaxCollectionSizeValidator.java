package edu.estu.estufastingrestapi.core.service.validation.validators;

import edu.estu.estufastingrestapi.core.service.validation.annotations.MaxCollectionSize;
import edu.estu.estufastingrestapi.core.service.validation.validators.abstraction.BaseConstraintValidator;

import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

public class MaxCollectionSizeValidator extends BaseConstraintValidator<MaxCollectionSize, Collection<?>> {

    @Override
    public boolean isValid(Collection<?> values, ConstraintValidatorContext context) {
        return values.size() <= constraint.max();
    }

}