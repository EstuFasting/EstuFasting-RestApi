package edu.estu.estufastingrestapi.core.model.entities.helper;

import edu.estu.estufastingrestapi.core.model.entities.abstracts.Identifiable;
import lombok.experimental.UtilityClass;

import java.util.function.Supplier;

@UtilityClass
public class IdentifiableHelper {

    public <T extends Identifiable<ID>, ID> T getInstance(Supplier<T> supplier, ID id) {
        T entity = supplier.get();
        entity.setId(id);
        return entity;
    }

}
