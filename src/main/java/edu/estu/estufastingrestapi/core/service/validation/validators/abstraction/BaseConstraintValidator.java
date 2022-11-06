package edu.estu.estufastingrestapi.core.service.validation.validators.abstraction;

import javax.validation.ConstraintValidator;
import java.lang.annotation.Annotation;

public abstract class BaseConstraintValidator<C extends Annotation, T> implements ConstraintValidator<C, T> {

    protected C constraint;

    @Override
    public void initialize(C constraint) {
        this.constraint = constraint;
        ConstraintValidator.super.initialize(constraint);
    }

}
