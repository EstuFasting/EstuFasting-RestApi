package edu.estu.estufastingrestapi.core.model.dto.language;

import edu.estu.estufastingrestapi.core.model.constants.Validation;
import edu.estu.estufastingrestapi.core.model.dto.abstraction.Dto;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;
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
public class LanguageUpdateDto implements Dto {

    @NotNull(message = Msg.REQUIRED)
    private Integer id;

    @NotNull(message = Msg.REQUIRED)
    @Size(min = Validation.Language.MIN_LEN_NAME, max = Validation.Language.MAX_LEN_NAME, message = Msg.SIZE)
    private String name;

    @NotNull(message = Msg.REQUIRED)
    @Size(min = Validation.Language.MIN_LEN_LOCAL_NAME, max = Validation.Language.MAX_LEN_LOCAL_NAME, message = Msg.SIZE)
    private String localName;

    @NotNull(message = Msg.REQUIRED)
    @Pattern(regexp = Validation.Common.RGX_ALPHA_2, message = Msg.PATTERN)
    private String alpha2;

    @NotNull(message = Msg.REQUIRED)
    @Pattern(regexp = Validation.Common.RGX_ALPHA_3, message = Msg.PATTERN)
    private String alpha3T;

    private Boolean unlisted;

    private Boolean supported;

}
