package edu.estu.estufastingrestapi.core.domain.entity.abstracts;

import java.time.LocalDateTime;

public interface CreateAuditable extends Entity {

    LocalDateTime getCreatedAt();

    void setCreatedAt(LocalDateTime createdAt);

    String getCreator();

    void setCreator(String creator);

}
