package edu.estu.estufastingrestapi.core.service.validation.validators;

import edu.estu.estufastingrestapi.core.service.validation.annotations.MaxCollectionSize;

import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

public class MaxCollectionSizeValidator extends BaseConstraintValidator<MaxCollectionSize, Collection<?>>{

    @Override
    public boolean isValid(Collection<?> objects, ConstraintValidatorContext constraintValidatorContext) {
        return objects.size() <= constraint.value();
    }

}
