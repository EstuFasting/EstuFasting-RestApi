package sk6.my.templateproject.core.service.validation.validators;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import sk6.my.templateproject.core.repository.helper.DbValidationHelper;

import java.lang.annotation.Annotation;

public abstract class BaseDbConstraintValidator<Constraint extends Annotation, T> extends BaseConstraintValidator<Constraint, T> {

    @Setter(onMethod = @__(@Autowired))
    protected DbValidationHelper dbValidationHelper;

}
