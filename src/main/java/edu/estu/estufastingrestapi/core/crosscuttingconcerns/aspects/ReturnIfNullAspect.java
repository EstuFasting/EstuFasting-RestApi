package edu.estu.estufastingrestapi.core.crosscuttingconcerns.aspects;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.ReturnIfNull;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.helper.AopHelper;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.helper.ReflectionHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(0)
public class ReturnIfNullAspect {

    @Around("execution(public * *(.., @edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.ReturnIfNull (*), ..))")
    public Object returnIfNull(final ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        List<Object> argsByAnnotation =
                ReflectionHelper.getArgsByAnnotation(AopHelper.getMethodParameters(pjp.getTarget().getClass(), (MethodSignature) pjp.getSignature()), pjp.getArgs(), ReturnIfNull.class);
        if (argsByAnnotation.contains(null)) return null;
        return pjp.proceed(args);
    }

}
