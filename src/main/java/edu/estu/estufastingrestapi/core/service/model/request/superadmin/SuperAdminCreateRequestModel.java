package edu.estu.estufastingrestapi.core.service.model.request.superadmin;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuperAdminCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_USER_USER_NAME_NOT_NULL)
    @Size(min = Validation.User.MIN_LEN_USERNAME, max = Validation.User.MAX_LEN_USERNAME, message = MsgCode.VALIDATION_USER_USER_NAME_SIZE)
    private String username;

    @NotNull(message = MsgCode.VALIDATION_USER_EMAIL_NOT_NULL)
    @Pattern(regexp = Validation.User.RGX_EMAIL, message = MsgCode.VALIDATION_USER_EMAIL_PATTERN)
    private String email;

    @NotNull(message = MsgCode.VALIDATION_USER_PASSWORD_NOT_NULL)
    @Size(min = Validation.User.MIN_LEN_PW, max = Validation.User.MAX_LEN_PW, message = MsgCode.VALIDATION_USER_PASSWORD_SIZE)
    private String password;

    @NotNull(message = MsgCode.VALIDATION_USER_PHONE_NUMBER_NOT_NULL)
    @Pattern(regexp = Validation.User.RGX_PHONE_NUMBER, message = MsgCode.VALIDATION_USER_PHONE_NUMBER_PATTERN)
    private String phoneNumber;

    @NotNull(message = MsgCode.VALIDATION_USER_COUNTRY_ID_NOT_NULL)
    private Integer countryId;

    @NotNull(message = MsgCode.VALIDATION_USER_LANGUAGE_ID_NOT_NULL)
    private Integer languageId;

    @NotNull(message = MsgCode.VALIDATION_USER_FIRST_NAME_NOT_NULL)
    @Size(min = Validation.User.MIN_LEN_FIRST_NAME, max = Validation.User.MAX_LEN_FIRST_NAME, message = MsgCode.VALIDATION_USER_FIRST_NAME_SIZE)
    private String firstName;

    @NotNull(message = MsgCode.VALIDATION_USER_LAST_NAME_NOT_NULL)
    @Size(min = Validation.User.MIN_LEN_LAST_NAME, max = Validation.User.MAX_LEN_LAST_NAME, message = MsgCode.VALIDATION_USER_LAST_NAME_SIZE)
    private String lastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = MsgCode.VALIDATION_USER_BIRTH_DATE_NOT_NULL)
    @Past(message = MsgCode.VALIDATION_USER_BIRTH_DATE_PAST)
    private LocalDate birthDate;

}
