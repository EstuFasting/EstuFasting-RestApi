package edu.estu.estufastingrestapi.core.model.entities.abstracts;

public interface Persistable<ID> extends Entity {

    ID getId();

    void setId(ID newId);

}
