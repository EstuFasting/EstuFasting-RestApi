package edu.estu.estufastingrestapi.core.domain.entity.abstracts;

import java.time.LocalDateTime;

public interface UpdateAuditable extends Entity {

    LocalDateTime getModifiedAt();

    void setModifiedAt(LocalDateTime modifiedAt);

    String getModifier();

    void setModifier(String modifier);

}
