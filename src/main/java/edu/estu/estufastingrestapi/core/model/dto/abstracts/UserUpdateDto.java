package edu.estu.estufastingrestapi.core.model.dto.abstracts;

import edu.estu.estufastingrestapi.core.model.constants.validation.RegExp;
import edu.estu.estufastingrestapi.core.model.constants.validation.SizeOf;
import edu.estu.estufastingrestapi.core.model.entities.concretes.User;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;
import edu.estu.estufastingrestapi.core.service.validation.annotations.Exists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserUpdateDto implements Dto {

    @NotNull(message = Msg.REQUIRED)
    protected UUID id;

    @Exists(entity = User.class, fieldName = "username", message = Msg.NOT_EXIST)
    @NotBlank(message = Msg.REQUIRED)
    protected String username;

    @NotBlank(message = Msg.REQUIRED)
    @Pattern(regexp = RegExp.EMAIL, message = Msg.PATTERN)
    protected String email;

    @NotBlank(message = Msg.REQUIRED)
    @Pattern(regexp = RegExp.PHONE_NUM, message = Msg.PATTERN)
    protected String phoneNumber;

    @NotNull(message = Msg.REQUIRED)
    protected Integer country;

    @NotNull(message = Msg.REQUIRED)
    protected Integer language;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = SizeOf.Text.Min.PW, max = SizeOf.Text.Max.PW, message = Msg.SIZE)
    protected String password;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = SizeOf.Text.Min.FIRST_NAME, max = SizeOf.Text.Max.FIRST_NAME, message = Msg.SIZE)
    protected String firstName;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = SizeOf.Text.Min.LAST_NAME, max = SizeOf.Text.Max.LAST_NAME, message = Msg.SIZE)
    protected String lastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = Msg.REQUIRED)
    @Past(message = Msg.PAST)
    protected LocalDate birthDate;

}
