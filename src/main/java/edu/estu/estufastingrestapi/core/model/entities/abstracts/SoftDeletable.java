package edu.estu.estufastingrestapi.core.model.entities.abstracts;

public interface SoftDeletable extends Deletable {

    Character getDeleted();

    void setDeleted(Character deleted);

}
