package sk6.my.templateproject.core.model.dto.abstracts;

import io.swagger.annotations.ApiModel;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Super type of user's create dto. Not used directly.")
public abstract class UserCreateDto implements Dto {

    @Exists(entity = User.class, fieldName = "username", message = Msg.IS_IN_USE, negate = true)
    @NotBlank(message = Msg.REQUIRED)
    protected String username;

    @Exists(entity = User.class, fieldName = "email", message = Msg.IS_IN_USE, negate = true)
    @NotBlank(message = Msg.REQUIRED)
    @Pattern(regexp = RegExp.EMAIL, message = Msg.PATTERN)
    protected String email;

    @Exists(entity = User.class, fieldName = "phoneNumber", message = Msg.IS_IN_USE, negate = true)
    @Pattern(regexp = RegExp.PHONE_NUM, message = Msg.PATTERN)
    protected String phoneNumber;

    @Exists(entity = Country.class, fieldName = "id", message = Msg.NOT_EXIST)
    protected Integer countryId;

    @Exists(entity = Language.class, fieldName = "id", message = Msg.NOT_EXIST)
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
