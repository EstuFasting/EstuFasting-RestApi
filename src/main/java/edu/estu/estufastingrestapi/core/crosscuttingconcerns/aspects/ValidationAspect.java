package edu.estu.estufastingrestapi.core.crosscuttingconcerns.aspects;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.helper.AopHelper;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.helper.ReflectionHelper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Aspect
@Component
@Order(0)
@RequiredArgsConstructor
public class ValidationAspect {

    private final Validator validator;

    //@Before("execution(public * *(.., @org.springframework.validation.annotation.Validated (*), ..))")
    public void validate(final JoinPoint joinPoint) {
        List<Object> argsByAnnotation =
                ReflectionHelper.getArgsByAnnotation(AopHelper.getMethodParameters(joinPoint.getTarget().getClass(), (MethodSignature) joinPoint.getSignature()), joinPoint.getArgs(), Validated.class);

        Set<ConstraintViolation<Object>> violations = new HashSet<>();
        for (Object o : argsByAnnotation) {
            violations = validator.validate(o);
        }

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Object> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb, violations);
        }
    }
}
