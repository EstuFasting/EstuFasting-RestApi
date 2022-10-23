package edu.estu.estufastingrestapi.core.model.entities.abstracts;

import java.time.LocalDateTime;

public interface UpdateAuditable extends Entity {

    LocalDateTime getModifiedAt();

    String getModifier();

    void setModifiedAt(LocalDateTime modifiedAt);

    void setModifier(String modifier);

}
