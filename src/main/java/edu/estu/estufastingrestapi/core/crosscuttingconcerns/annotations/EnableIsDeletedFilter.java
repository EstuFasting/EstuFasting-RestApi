package edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations;

import edu.estu.estufastingrestapi.core.model.enumeration.CharFlag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.METHOD)
@Retention(RUNTIME)
@Inherited
public @interface EnableIsDeletedFilter {
    CharFlag value() default CharFlag.FALSE;
}
