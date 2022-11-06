package edu.estu.estufastingrestapi.model.dto.update;

import edu.estu.estufastingrestapi.model.entities.CustomerType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUpdateDto {

    private String cardNo;

    private CustomerType type;

}