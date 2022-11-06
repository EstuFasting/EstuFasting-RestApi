package edu.estu.estufastingrestapi.core.repository.helper;

import edu.estu.estufastingrestapi.core.model.entities.abstracts.Entity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
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
