package edu.estu.estufastingrestapi.service.model.request.customer;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import edu.estu.estufastingrestapi.core.service.validation.annotations.TCKN;
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
public class CustomerCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_USER_FIRST_NAME_NOT_NULL)
    @Size(min = Validation.User.MIN_LEN_FIRST_NAME, max = Validation.User.MAX_LEN_FIRST_NAME, message = MsgCode.VALIDATION_USER_FIRST_NAME_SIZE)
    private String firstName;

    @NotNull(message = MsgCode.VALIDATION_USER_LAST_NAME_NOT_NULL)
    @Size(min = Validation.User.MIN_LEN_LAST_NAME, max = Validation.User.MAX_LEN_LAST_NAME, message = MsgCode.VALIDATION_USER_LAST_NAME_SIZE)
    private String lastName;

    @NotNull(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY)
    @Pattern(regexp = Validation.User.RGX_EMAIL, message = MsgCode.VALIDATION_USER_EMAIL_PATTERN)
    private String username;

    @NotNull(message = MsgCode.VALIDATION_CUSTOMER_TCKN_NOT_NULL)
    @TCKN
    private String tckn;

    @NotNull(message = MsgCode.VALIDATION_USER_PASSWORD_NOT_NULL)
    @Size(min = Validation.User.MIN_LEN_PW, max = Validation.User.MAX_LEN_PW, message = MsgCode.VALIDATION_USER_PASSWORD_SIZE)
    private String password;

    @NotNull(message = MsgCode.VALIDATION_USER_LANGUAGE_ID_NOT_NULL)
    private Integer languageId;

    public void setFirstName(String firstName) {
        System.out.println(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        System.out.println(lastName);
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        System.out.println(username);
        this.username = username;
    }

    public void setTckn(String tckn) {
        System.out.println(tckn);
        this.tckn = tckn;
    }

    public void setPassword(String password) {
        System.out.println(password);
        this.password = password;
    }

    public void setLanguageId(Integer languageId) {
        System.out.println(languageId);
        this.languageId = languageId;
    }
}