package edu.estu.estufastingrestapi.core.service.validation.validators;

import edu.estu.estufastingrestapi.core.service.validation.annotations.TCKN;
import edu.estu.estufastingrestapi.core.service.validation.helper.TCKNHelper;
import edu.estu.estufastingrestapi.core.service.validation.validators.abstraction.BaseConstraintValidator;

import javax.validation.ConstraintValidatorContext;

public class TCKNLongValidator extends BaseConstraintValidator<TCKN, Long> {

    @Override
    public boolean isValid(Long tckn, ConstraintValidatorContext constraintValidatorContext) {
        return TCKNHelper.isValid(tckn);
    }

}
