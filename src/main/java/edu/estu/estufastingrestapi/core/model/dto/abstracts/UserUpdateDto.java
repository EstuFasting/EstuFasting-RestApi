package sk6.my.templateproject.core.model.dto.abstracts;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import sk6.my.templateproject.core.model.constants.validation.RegExp;
import sk6.my.templateproject.core.model.constants.validation.SizeOf;
import sk6.my.templateproject.core.model.entities.concretes.Country;
import sk6.my.templateproject.core.model.entities.concretes.Language;
import sk6.my.templateproject.core.model.entities.concretes.User;
import sk6.my.templateproject.core.model.response.helper.Msg;
import sk6.my.templateproject.core.service.validation.annotations.Exists;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserUpdateDto implements Dto {

    @ApiModelProperty(notes = "Binary UUID User ID", example = "00000000-0000-0000-0000-000000000000")
    @Exists(entity = User.class, fieldName = "id", message = Msg.NOT_EXIST)
    @Null
    @NotNull(message = Msg.REQUIRED)
    protected UUID id;

    @ApiModelProperty(notes = "Username", example = "00000000-0000-0000-0000-000000000000")
    @Exists(entity = User.class, fieldName = "username", message = Msg.IS_IN_USE, negate = true)
    @NotBlank(message = Msg.REQUIRED)
    protected String username;

    @ApiModelProperty(notes = "Username", example = "00000000-0000-0000-0000-000000000000")
    @Exists(entity = User.class, fieldName = "email", message = Msg.IS_IN_USE, negate = true)
    @NotBlank(message = Msg.REQUIRED)
    @Pattern(regexp = RegExp.EMAIL, message = Msg.PATTERN)
    protected String email;

    @ApiModelProperty(notes = "Username", example = "00000000-0000-0000-0000-000000000000")
    @Exists(entity = User.class, fieldName = "phoneNumber", message = Msg.IS_IN_USE, negate = true)
    @NotBlank(message = Msg.REQUIRED)
    @Pattern(regexp = RegExp.PHONE_NUM, message = Msg.PATTERN)
    protected String phoneNumber;

    @ApiModelProperty(notes = "Username", example = "00000000-0000-0000-0000-000000000000")
    @Exists(entity = Country.class, fieldName = "id", message = Msg.NOT_EXIST)
    @NotNull(message = Msg.REQUIRED)
    protected Integer country;

    @ApiModelProperty(notes = "Username", example = "00000000-0000-0000-0000-000000000000")
    @Exists(entity = Language.class, fieldName = "id", message = Msg.NOT_EXIST)
    @NotNull(message = Msg.REQUIRED)
    protected Integer language;

    @ApiModelProperty(notes = "Username", example = "00000000-0000-0000-0000-000000000000")
    @NotBlank(message = Msg.REQUIRED)
    @Size(min = SizeOf.Text.Min.PW, max = SizeOf.Text.Max.PW, message = Msg.SIZE)
    protected String password;

    @ApiModelProperty(notes = "Username", example = "00000000-0000-0000-0000-000000000000")
    @NotBlank(message = Msg.REQUIRED)
    @Size(min = SizeOf.Text.Min.FIRST_NAME, max = SizeOf.Text.Max.FIRST_NAME, message = Msg.SIZE)
    protected String firstName;

    @ApiModelProperty(notes = "Username", example = "00000000-0000-0000-0000-000000000000")
    @NotBlank(message = Msg.REQUIRED)
    @Size(min = SizeOf.Text.Min.LAST_NAME, max = SizeOf.Text.Max.LAST_NAME, message = Msg.SIZE)
    protected String lastName;

    @ApiModelProperty(notes = "Birth Date", example = "2001-07-29", required = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = Msg.REQUIRED)
    @Past(message = Msg.PAST)
    protected LocalDate birthDate;

}
