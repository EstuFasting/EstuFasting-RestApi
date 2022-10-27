package edu.estu.estufastingrestapi.core.repository.initialdataloaders.abstracts;

import edu.estu.estufastingrestapi.core.model.entities.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@Getter
@Setter
public abstract class BaseInitialDataLoader<T extends Identifiable<ID>, ID> implements InitialDataLoader<T, ID> {

    protected boolean loaded;

    protected Collection<T> data;

    @Setter(onMethod = @__(@Autowired))
    protected JpaRepositoryAdapter<T, ID> repository;

}
