package edu.estu.estufastingrestapi.core.repository.initialdataloaders.abstracts;

import edu.estu.estufastingrestapi.core.model.entities.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
public abstract class BaseDataSeeder<T extends Identifiable<ID>, ID> implements DataSeeder<T, ID> {

    protected boolean seeded;

    @Setter(AccessLevel.NONE)
    protected Collection<T> data = new ArrayList<>();

    @Getter
    @Setter(onMethod = @__(@Autowired))
    protected JpaRepositoryAdapter<T, ID> repository;

}
