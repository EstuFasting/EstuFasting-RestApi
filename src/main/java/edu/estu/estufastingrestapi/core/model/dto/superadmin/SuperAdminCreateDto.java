package edu.estu.estufastingrestapi.core.model.dto.superadmin;

import edu.estu.estufastingrestapi.core.model.constants.Validation;
import edu.estu.estufastingrestapi.core.model.dto.abstraction.Dto;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuperAdminCreateDto implements Dto {

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = Validation.User.MIN_LEN_USERNAME, max = Validation.User.MAX_LEN_USERNAME, message = Msg.SIZE)
    private String username;

    @NotBlank(message = Msg.REQUIRED)
    @Pattern(regexp = Validation.User.RGX_EMAIL, message = Msg.PATTERN)
    private String email;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = Validation.User.MIN_LEN_PW, max = Validation.User.MAX_LEN_PW, message = Msg.SIZE)
    private String password;

    @NotBlank(message = Msg.REQUIRED)
    @Pattern(regexp = Validation.User.RGX_PHONE_NUMBER, message = Msg.PATTERN)
    private String phoneNumber;

    @NotNull(message = Msg.REQUIRED)
    @Positive
    private Integer countryId;

    @NotNull(message = Msg.REQUIRED)
    @Positive
    private Integer languageId;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = Validation.User.MIN_LEN_FIRST_NAME, max = Validation.User.MAX_LEN_FIRST_NAME, message = Msg.SIZE)
    private String firstName;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = Validation.User.MIN_LEN_LAST_NAME, max = Validation.User.MAX_LEN_LAST_NAME, message = Msg.SIZE)
    private String lastName;

    @NotNull(message = Msg.REQUIRED)
    @Past(message = Msg.PAST)
    private LocalDate birthDate;

}
