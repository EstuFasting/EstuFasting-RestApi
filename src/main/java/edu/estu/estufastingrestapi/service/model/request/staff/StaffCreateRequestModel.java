package edu.estu.estufastingrestapi.service.model.request.staff;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY)
    @Pattern(regexp = Validation.User.RGX_EMAIL, message = MsgCode.VALIDATION_USER_EMAIL_PATTERN)
    private String username;

    @NotNull(message = MsgCode.VALIDATION_USER_PASSWORD_NOT_NULL)
    @Size(min = Validation.User.MIN_LEN_PW, max = Validation.User.MAX_LEN_PW, message = MsgCode.VALIDATION_USER_PASSWORD_SIZE)
    private String password;

    @NotNull(message = MsgCode.VALIDATION_USER_LANGUAGE_ID_NOT_NULL)
    private Integer languageId;

}
