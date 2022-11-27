package edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
public abstract class BaseDataSeeder<T extends Identifiable<ID>, ID> implements DataSeeder<T, ID> {

    protected boolean seeded;

    @Setter(AccessLevel.NONE)
    protected Collection<T> data = new ArrayList<>();

    @Setter(onMethod = @__(@Autowired))
    protected JpaRepositoryAdapter<T, ID> repository;

    @Setter(onMethod = @__(@Autowired))
    protected EntityManager entityManager;

}
