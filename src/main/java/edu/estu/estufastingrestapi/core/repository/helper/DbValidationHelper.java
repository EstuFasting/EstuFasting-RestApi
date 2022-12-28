package edu.estu.estufastingrestapi.core.repository.helper;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Entity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
@RequiredArgsConstructor
public class DbValidationHelper {

    private final Session session;

    public <T extends Entity> boolean existsByField(Class<T> entityClass, String fieldName, Object value) {
        return session
                       .createQuery("select 1 from %s where %s = :value".formatted(entityClass.getSimpleName(), fieldName))
                       .setParameter("value", value)
                       .uniqueResult() != null;
    }

}
