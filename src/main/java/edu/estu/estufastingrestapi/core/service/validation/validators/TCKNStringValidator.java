package edu.estu.estufastingrestapi.core.service.validation.validators;

import edu.estu.estufastingrestapi.core.service.validation.annotations.TCKN;
import edu.estu.estufastingrestapi.core.service.validation.helper.TCKNHelper;
import edu.estu.estufastingrestapi.core.service.validation.validators.abstraction.BaseConstraintValidator;

import javax.validation.ConstraintValidatorContext;

public class TCKNStringValidator extends BaseConstraintValidator<TCKN, String> {

    @Override
    public boolean isValid(String tckn, ConstraintValidatorContext constraintValidatorContext) {
        return TCKNHelper.isValid(Long.parseLong(tckn));
    }

}
