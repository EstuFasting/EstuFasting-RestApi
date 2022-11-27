package edu.estu.estufastingrestapi.core.crosscuttingconcerns.interceptors;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.ReturnIfNull;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.helper.AopHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(0)
public class ReturnIfNullInterceptor {

    @Pointcut("execution(public * *(.., @edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.ReturnIfNull (*), ..))")
    private void hasAtLeastOneParameterAnnotatedWithReturnIfNull() {/*POINTCUT*/}

    @Around("hasAtLeastOneParameterAnnotatedWithReturnIfNull()")
    public Object returnIfNull(final ProceedingJoinPoint pjp) throws Throwable {
        List<Object> argsByAnnotation = AopHelper.getAnnotatedArgs(pjp, ReturnIfNull.class);
        for (Object o : argsByAnnotation) if (o == null) return null;
        return pjp.proceed(pjp.getArgs());
    }

}
