package edu.estu.estufastingrestapi.core.crosscuttingconcerns.aspects;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.EnableIsDeletedFilter;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.helper.AopHelper;
import edu.estu.estufastingrestapi.core.model.constants.FilterName;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Aspect
@Component
@RequiredArgsConstructor
public class EnableIsDeletedFilterAspect {

    private final EntityManager entityManager;

    private Session session;

    @Pointcut("@annotation(edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.EnableIsDeletedFilter)")
    public void enableIsDeletedFilterMethod() {
        // Do nothing
    }

    @Before("enableIsDeletedFilterMethod()")
    public void enableIsDeletedFilter(final JoinPoint joinPoint) {
        session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter(FilterName.IS_DELETED);
        EnableIsDeletedFilter annotation = AopHelper.getMethodAnnotation((MethodSignature) joinPoint.getSignature(), EnableIsDeletedFilter.class);
        filter.setParameter("deleted", annotation.value().asChar());
    }

    @After("enableIsDeletedFilterMethod()")
    public void disableIsDeletedFilter(final JoinPoint joinPoint) {
        session.disableFilter(FilterName.IS_DELETED);
    }
}
