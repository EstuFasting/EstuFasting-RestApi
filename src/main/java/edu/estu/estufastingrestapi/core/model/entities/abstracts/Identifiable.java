package edu.estu.estufastingrestapi.core.model.entities.abstracts;

public interface Identifiable<ID> extends Entity {

    ID getId();

    void setId(ID newId);

}
