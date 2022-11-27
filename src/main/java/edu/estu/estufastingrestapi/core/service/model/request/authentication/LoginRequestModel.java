package edu.estu.estufastingrestapi.core.service.model.request.authentication;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestModel implements RequestModel {

    @NotBlank(message = MsgCode.VALIDATION_USER_USER_NAME_NOT_BLANK)
    private String username;

    @NotBlank(message = MsgCode.VALIDATION_USER_PASSWORD_NOT_BLANK)
    private String password;

}
