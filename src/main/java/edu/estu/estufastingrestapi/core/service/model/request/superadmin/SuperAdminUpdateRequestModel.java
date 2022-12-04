package edu.estu.estufastingrestapi.core.service.model.request.superadmin;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuperAdminUpdateRequestModel implements RequestModel {

    @NotEmpty(message = MsgCode.VALIDATION_USER_ID_NOT_NULL)
    private UUID id;

    @Pattern(regexp = Validation.User.RGX_EMAIL, message = MsgCode.VALIDATION_USER_EMAIL_PATTERN)
    private String username;

    @Pattern(regexp = Validation.User.RGX_PHONE_NUMBER, message = MsgCode.VALIDATION_USER_PHONE_NUMBER_PATTERN)
    private String phoneNumber;

    private Integer languageId;

    @Size(min = Validation.User.MIN_LEN_FIRST_NAME, max = Validation.User.MAX_LEN_FIRST_NAME, message = MsgCode.VALIDATION_USER_FIRST_NAME_SIZE)
    private String firstName;

    @Size(min = Validation.User.MIN_LEN_LAST_NAME, max = Validation.User.MAX_LEN_LAST_NAME, message = MsgCode.VALIDATION_USER_LAST_NAME_SIZE)
    private String lastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = MsgCode.VALIDATION_USER_BIRTH_DATE_PAST)
    private LocalDate birthDate;

}
