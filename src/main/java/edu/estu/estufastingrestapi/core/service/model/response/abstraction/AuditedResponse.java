package edu.estu.estufastingrestapi.core.service.model.response.abstraction;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AuditedResponse {

    @JsonFormat(pattern = "yyyy-MM-dd HH:dd")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:dd")
    private LocalDateTime modifiedAt;

}
