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
public class LoginRequestModel implements RequestModel {

    @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY)
    private String username;

    @NotEmpty(message = MsgCode.VALIDATION_USER_PASSWORD_NOT_EMPTY)
    private String password;

}
