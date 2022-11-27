package edu.estu.estufastingrestapi.core.domain.entity.abstracts;

import java.util.function.Supplier;

public interface Identifiable<ID> extends Entity {

    static <T extends Identifiable<ID>, ID> T getInstance(Supplier<T> supplier, ID id) {
        T entity = supplier.get();
        entity.setId(id);
        return entity;
    }

    ID getId();

    void setId(ID newId);

}
