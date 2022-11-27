package edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RUNTIME)
public @interface LogExecutionTime {
}
