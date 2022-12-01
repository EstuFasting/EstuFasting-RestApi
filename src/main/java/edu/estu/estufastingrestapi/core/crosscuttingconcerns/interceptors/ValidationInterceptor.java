package edu.estu.estufastingrestapi.core.crosscuttingconcerns.interceptors;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.helper.AopHelper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Aspect
@Component
@RequiredArgsConstructor
public class ValidationInterceptor {

    private final Validator validator;

    @Pointcut("execution(public * *(.., @edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid (*), ..))")
    private void hasAtLeastOneParameterAnnotatedWithValid() {/*POINTCUT*/}

    @Around("hasAtLeastOneParameterAnnotatedWithValid()")
    public Object validate(final ProceedingJoinPoint pjp) throws Throwable {
        List<Object> argsByAnnotation = AopHelper.getAnnotatedArgs(pjp, Valid.class);
        for (Object object : argsByAnnotation) {
            Set<ConstraintViolation<Object>> violations = validator.validate(object);
            if (!violations.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (ConstraintViolation<?> violation : violations)
                    sb.append(violation.getMessage());
                throw new ConstraintViolationException("Error occurred: " + sb, violations);
            }
        }
        return pjp.proceed(pjp.getArgs());
    }

}
