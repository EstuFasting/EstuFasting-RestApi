package edu.estu.estufastingrestapi.model.dto.update;

import edu.estu.estufastingrestapi.core.model.dto.abstracts.UserUpdateDto;
import edu.estu.estufastingrestapi.model.entities.CustomerType;

public class CustomerUpdateDto extends UserUpdateDto {

    private String cardNo;

    private CustomerType type;

}