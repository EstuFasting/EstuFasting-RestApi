package edu.estu.estufastingrestapi.core.crosscuttingconcerns.interceptors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LogExecutionTimeInterceptor {

    @Pointcut("within(@edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime *)")
    private void insideAClassAnnotatedWithLogExecutionTime() {/*POINTCUT*/}

    @Pointcut("@annotation(edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime)")
    private void annotatedWithLogExecutionTime() {/*POINTCUT*/}

    @Around("insideAClassAnnotatedWithLogExecutionTime() || annotatedWithLogExecutionTime()")
    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object ret = pjp.proceed();
        long end = (System.nanoTime() - start) / 1000000;
        String logMessage = "Method executed in " + end + " milliseconds: " + pjp.toShortString();
        if (end < 250) log.info(logMessage);
        else if (end > 250 && end < 1000) log.warn(logMessage);
        else log.error(logMessage);
        return ret;
    }

}
