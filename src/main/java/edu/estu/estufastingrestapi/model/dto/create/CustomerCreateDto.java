package edu.estu.estufastingrestapi.model.dto.create;

import edu.estu.estufastingrestapi.core.model.dto.abstracts.UserCreateDto;
import edu.estu.estufastingrestapi.model.dto.update.CustomerTypeUpdateDto;
import edu.estu.estufastingrestapi.model.entities.CustomerType;

import javax.validation.constraints.NotNull;

public class CustomerCreateDto extends UserCreateDto {

    @NotNull
    private String cardNo;

    @NotNull
    private Integer customerTypeId;

}