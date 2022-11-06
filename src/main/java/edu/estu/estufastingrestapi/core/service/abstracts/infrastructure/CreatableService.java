package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.model.dto.abstraction.Dto;
import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiResponse;

import javax.validation.Valid;

public interface CreatableService<DtoType extends Dto> extends EntityService {

    ApiResponse create(@Valid DtoType dto);

}
