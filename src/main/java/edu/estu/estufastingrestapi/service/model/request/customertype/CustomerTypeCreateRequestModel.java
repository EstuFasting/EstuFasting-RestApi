package edu.estu.estufastingrestapi.service.model.request.customertype;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CustomerTypeCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_CUSTOMER_TYPE_NAME_NOT_NULL)
    @Size(min = Validation.CustomerType.MIN_LEN_NAME, max = Validation.CustomerType.MAX_LEN_NAME, message = MsgCode.VALIDATION_CUSTOMER_TYPE_NAME_SIZE)
    private String name;

    @NotNull(message = MsgCode.VALIDATION_CUSTOMER_TYPE_DESCRIPTION_NOT_NULL)
    @Size(min = Validation.CustomerType.MIN_LEN_DESC, max = Validation.CustomerType.MAX_LEN_DESC, message = MsgCode.VALIDATION_CUSTOMER_TYPE_DESCRIPTION_SIZE)
    private String description;

}