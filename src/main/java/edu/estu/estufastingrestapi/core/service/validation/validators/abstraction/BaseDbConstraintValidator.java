package edu.estu.estufastingrestapi.core.service.validation.validators.abstraction;

import edu.estu.estufastingrestapi.core.repository.helper.DbValidationHelper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;

public abstract class BaseDbConstraintValidator<C extends Annotation, T> extends BaseConstraintValidator<C, T> {

    @Setter(onMethod = @__(@Autowired))
    protected DbValidationHelper dbValidationHelper;

}
