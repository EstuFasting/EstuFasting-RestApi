package edu.estu.estufastingrestapi.core.service.model.response.abstraction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseResponse<ID> extends AuditedResponse {

    private ID id;

}
