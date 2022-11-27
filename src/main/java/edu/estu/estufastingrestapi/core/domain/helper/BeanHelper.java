package edu.estu.estufastingrestapi.core.domain.helper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class BeanHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public synchronized void setApplicationContext(@NonNull ApplicationContext applicationContext) {
        if (BeanHelper.applicationContext == null)
            BeanHelper.applicationContext = applicationContext;
    }

    /**
     * @param type Type of bean to be wanted.
     * @return Spring bean instance of type parameter type without need of dependency injection.
     */
    public static <T> T getBean(Class<T> type) {
        if (applicationContext == null)
            throw new IllegalStateException("ApplicationContext is not ready. Please call this method after ApplicationContextInitializedEvent.");
        return applicationContext.getBean(type);
    }

}