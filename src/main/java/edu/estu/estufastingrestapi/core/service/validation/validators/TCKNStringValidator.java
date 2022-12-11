package edu.estu.estufastingrestapi.core.service.validation.validators;

import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.validation.annotations.TCKN;
import edu.estu.estufastingrestapi.core.service.validation.helper.TCKNHelper;
import edu.estu.estufastingrestapi.core.service.validation.validators.abstraction.BaseConstraintValidator;

import javax.validation.ConstraintValidatorContext;

public class TCKNStringValidator extends BaseConstraintValidator<TCKN, String> {

    @Override
    public boolean isValid(String tckn, ConstraintValidatorContext constraintValidatorContext) {
        if (tckn == null) return true;
        if (!tckn.matches(Validation.Customer.RGX_TCKN)) return false;
        return TCKNHelper.isValid(Long.parseLong(tckn));
    }

}
