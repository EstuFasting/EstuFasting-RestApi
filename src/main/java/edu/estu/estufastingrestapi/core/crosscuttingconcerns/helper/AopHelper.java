package edu.estu.estufastingrestapi.core.crosscuttingconcerns.helper;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

@UtilityClass
public class AopHelper {

    public List<Object> getAnnotatedArgs(final ProceedingJoinPoint pjp, Class<? extends Annotation> annotation) {
        Parameter[] parameters = getMethodParameters(pjp.getTarget().getClass(), (MethodSignature) pjp.getSignature());
        return ReflectionHelper.getArgsByAnnotation(parameters, pjp.getArgs(), annotation);
    }

    @SneakyThrows
    public Parameter[] getMethodParameters(Class<?> theClass, MethodSignature signature) {
        return theClass.getMethod(signature.getMethod().getName(), signature.getMethod().getParameterTypes()).getParameters();
    }

    @SneakyThrows
    public Method getMethod(MethodSignature methodSignature) {
        return methodSignature.getMethod();
    }

    public <T extends Annotation> T getMethodAnnotation(MethodSignature methodSignature, Class<T> annotation) {
        return methodSignature.getMethod().getAnnotation(annotation);
    }


}
