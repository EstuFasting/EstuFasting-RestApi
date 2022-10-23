package edu.estu.estufastingrestapi.core.model.entities.abstracts;

import java.time.LocalDateTime;

public interface CreateAuditable extends Entity {

    void setCreatedAt(LocalDateTime createdAt);

    LocalDateTime getCreatedAt();

    String getCreator();

    void setCreator(String creator);

}
