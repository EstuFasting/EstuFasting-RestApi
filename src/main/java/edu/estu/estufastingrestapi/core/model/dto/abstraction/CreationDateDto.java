package edu.estu.estufastingrestapi.core.model.dto.abstraction;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public interface CreationDateDto extends Dto {

    @JsonFormat(pattern = "yyyy-MM-dd HH:dd")
    LocalDateTime getCreatedAt();

}
