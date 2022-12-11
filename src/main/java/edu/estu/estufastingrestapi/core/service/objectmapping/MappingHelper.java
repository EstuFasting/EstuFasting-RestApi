package edu.estu.estufastingrestapi.core.service.objectmapping;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.function.Supplier;

@UtilityClass
public class MappingHelper {

    public <T extends Identifiable<ID>, ID> T mapRefIgnoreNull(T old, Supplier<T> newSupp, ID id) {
        return id != null ? Identifiable.getInstance(newSupp, id) : old;
    }

    public <T extends Identifiable<ID>, ID, C extends Collection<T>> C mapFromIds(Collection<ID> ids, Supplier<T> entitySupplier, Supplier<C> collectionSupplier) {
        if (collectionSupplier == null) throw new IllegalArgumentException("Collection supplier must be given");
        if (ids == null || entitySupplier == null) return collectionSupplier.get();
        C entities = collectionSupplier.get();
        for (ID id : ids) entities.add(Identifiable.getInstance(entitySupplier, id));
        return entities;
    }

}
