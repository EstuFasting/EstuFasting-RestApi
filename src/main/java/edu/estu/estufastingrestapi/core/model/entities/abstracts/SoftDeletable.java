package edu.estu.estufastingrestapi.core.model.entities.abstracts;

public interface SoftDeletable extends Entity {

    Character getDeleted();

    void setDeleted(Character deleted);

}
