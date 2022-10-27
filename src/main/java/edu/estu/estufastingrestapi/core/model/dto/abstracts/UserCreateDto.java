package edu.estu.estufastingrestapi.core.model.dto.abstracts;

import edu.estu.estufastingrestapi.core.model.constants.validation.RegExp;
import edu.estu.estufastingrestapi.core.model.constants.validation.SizeOf;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto implements Dto {

    @NotBlank(message = Msg.REQUIRED)
    protected String username;

    @NotBlank(message = Msg.REQUIRED)
    @Pattern(regexp = RegExp.EMAIL, message = Msg.PATTERN)
    protected String email;

    @Pattern(regexp = RegExp.PHONE_NUM, message = Msg.PATTERN)
    protected String phoneNumber;

    protected Integer countryId;

    protected Integer languageId;

    @Size(min = SizeOf.Text.Min.FIRST_NAME, max = SizeOf.Text.Max.FIRST_NAME, message = Msg.SIZE)
    protected String firstName;

    @Size(min = SizeOf.Text.Min.LAST_NAME, max = SizeOf.Text.Max.LAST_NAME, message = Msg.SIZE)
    protected String lastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = Msg.REQUIRED)
    @Past(message = Msg.PAST)
    protected LocalDate birthDate;

}
