package edu.estu.estufastingrestapi.core.service.validation.validators;

import javax.validation.ConstraintValidator;
import java.lang.annotation.Annotation;

public abstract class BaseConstraintValidator<Constraint extends Annotation, T> implements ConstraintValidator<Constraint, T> {

    protected Constraint constraint;

    @Override
    public void initialize(Constraint constraint) {
        this.constraint = constraint;
        ConstraintValidator.super.initialize(constraint);
    }

}
