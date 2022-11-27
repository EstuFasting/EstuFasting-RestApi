package edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations;

import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Trims the string fields of the parameters which is subclass of {@link RequestModel}.
 *
 * @implSpec Getter methods of the string fields should have a corresponding setter method
 * @see RequestModel
 */
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface Trimmed {
}
