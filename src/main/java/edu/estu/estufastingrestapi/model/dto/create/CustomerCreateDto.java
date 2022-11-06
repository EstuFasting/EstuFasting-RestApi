package edu.estu.estufastingrestapi.model.dto.create;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CustomerCreateDto {

    @NotNull
    private String cardNo;

    @NotNull
    private Integer customerTypeId;

}