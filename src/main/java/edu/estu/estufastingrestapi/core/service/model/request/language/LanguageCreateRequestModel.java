package edu.estu.estufastingrestapi.core.service.model.request.language;

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
public class LanguageCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_LANGUAGE_NAME_NOT_NULL)
    @Size(min = Validation.Language.MIN_LEN_NAME, max = Validation.Language.MAX_LEN_NAME, message = MsgCode.VALIDATION_LANGUAGE_NAME_SIZE)
    private String name;

    @NotNull(message = MsgCode.VALIDATION_LANGUAGE_LOCAL_NAME_NOT_NULL)
    @Size(min = Validation.Language.MIN_LEN_LOCAL_NAME, max = Validation.Language.MAX_LEN_LOCAL_NAME, message = MsgCode.VALIDATION_LANGUAGE_LOCAL_NAME_SIZE)
    private String localName;

    @NotNull(message = MsgCode.VALIDATION_LANGUAGE_ALPHA_2_NOT_NULL)
    @Pattern(regexp = Validation.Common.RGX_ALPHA_2, message = MsgCode.VALIDATION_LANGUAGE_ALPHA_2_PATTERN)
    private String alpha2;

    @NotNull(message = MsgCode.VALIDATION_LANGUAGE_ALPHA_3_T_NOT_NULL)
    @Pattern(regexp = Validation.Common.RGX_ALPHA_3, message = MsgCode.VALIDATION_LANGUAGE_ALPHA_3_T_PATTERN)
    private String alpha3T;

    private Boolean unlisted;

    private Boolean supported;

}
