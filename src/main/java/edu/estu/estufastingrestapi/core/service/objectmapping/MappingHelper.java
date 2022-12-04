package edu.estu.estufastingrestapi.core.service.objectmapping;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

@UtilityClass
public class MappingHelper {

    public <T extends Identifiable<ID>, ID> T mapRefIgnoreNull(T old, Supplier<T> newSupp, ID id) {
        return id != null ? Identifiable.getInstance(newSupp, id) : old;
    }

    public <T extends Identifiable<ID>, ID> List<T> mapFromIdList(Collection<ID> ids, Supplier<T> entitySupp) {
        if (ids == null || entitySupp == null) return new ArrayList<>();
        List<T> entities = new ArrayList<>(ids.size());
        for (ID id : ids) entities.add(Identifiable.getInstance(entitySupp, id));
        return entities;
    }

}
