package edu.estu.estufastingrestapi.core.crosscuttingconcerns.helper;

import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class ReflectionHelper {

    public static List<Object> getArgsByAnnotation(Parameter[] params, Object[] args, Class<? extends Annotation> searchAnnotation) {
        List<Object> annotatedArgs = new ArrayList<>();
        for (int i = 0; i < args.length; i++)
            if (params[i].isAnnotationPresent(searchAnnotation))
                annotatedArgs.add(args[i]);
        return annotatedArgs;
    }

    public static <T extends Annotation> T getMethodAnnotation(Method method, Class<T> annotation) {
        return method.getAnnotation(annotation);
    }

    @SneakyThrows
    public <RT, OT> RT invokeMethod(OT object, Method method, Class<RT> returnType, Object[] paramValues) {
        return returnType.cast(method.invoke(object, paramValues));
    }

    @SneakyThrows
    public <RT, OT> RT invokeMethod(OT object, String methodName, Class<RT> returnType, Class<?>[] paramTypes, Object[] paramValues) {
        return invokeMethod(object, getMethod(object.getClass(), methodName, paramTypes), returnType, paramValues);
    }

    @SneakyThrows
    public Method getMethod(Class<?> clazz, String methodName, Class<?>[] paramTypes) {
        return clazz.getMethod(methodName, paramTypes);
    }

}
