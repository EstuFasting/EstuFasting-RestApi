package edu.estu.estufastingrestapi.core.service.model.request.authentication;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginRequestModel implements RequestModel {

    @NotEmpty(message = MsgCode.VALIDATION_LOGIN_CUSTOMER_IDENTIFIER_NOT_NULL)
    private String identifier;

    @NotEmpty(message = MsgCode.VALIDATION_LOGIN_PASSWORD_NOT_NULL)
    private String password;

}
