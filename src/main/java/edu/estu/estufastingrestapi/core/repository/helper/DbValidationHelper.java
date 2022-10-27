package sk6.my.templateproject.core.repository.helper;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import sk6.my.templateproject.core.model.entities.abstracts.Identifiable;

@Component
@RequiredArgsConstructor
public class DbValidationHelper {

    private final Session session;

    public <T extends Identifiable<?>> boolean existsByField(Class<T> entityClass, String fieldName, Object value) {
        return session
                .createQuery("select 1 from %s where %s = :value".formatted(entityClass.getSimpleName(), fieldName), Integer.class)
                .setParameter("value", value)
                .uniqueResult() != null;
    }

}
