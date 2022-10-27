package edu.estu.estufastingrestapi.core.service.validation.validators;

import edu.estu.estufastingrestapi.core.repository.helper.DbValidationHelper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;

public abstract class BaseDbConstraintValidator<Constraint extends Annotation, T> extends BaseConstraintValidator<Constraint, T> {

    @Setter(onMethod = @__(@Autowired))
    protected DbValidationHelper dbValidationHelper;

}
