package edu.estu.estufastingrestapi.core.service.helper;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.domain.helper.BeanHelper;
import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import lombok.experimental.UtilityClass;

import javax.persistence.EntityManager;

@UtilityClass
public class EntityServiceHelper {

    private final EntityManager entityManager = BeanHelper.getBean(EntityManager.class);

    public <T extends Identifiable<ID>, ID> T saveAndRefresh(JpaRepositoryAdapter<T, ID> repository, T entity) {
        T saved = repository.saveAndFlush(entity);
        entityManager.refresh(saved);
        return saved;
    }

}
