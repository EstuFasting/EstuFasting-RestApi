package edu.estu.estufastingrestapi.core.model.dto.concretes.create;

import edu.estu.estufastingrestapi.core.model.constants.validation.SizeOf;
import edu.estu.estufastingrestapi.core.model.dto.abstracts.Dto;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LanguageCreateDto implements Dto {

    @NotNull(message = Msg.REQUIRED)
    @Size(max = SizeOf.Text.Max.LANGUAGE_ENGLISH_NAME, min = SizeOf.Text.Min.LANGUAGE_ENGLISH_NAME, message = Msg.SIZE)
    private String englishName;

    @NotNull(message = Msg.REQUIRED)
    @Size(max = SizeOf.Text.Max.LANGUAGE_LOCAL_NAME, min = SizeOf.Text.Min.LANGUAGE_LOCAL_NAME, message = Msg.SIZE)
    private String localName;

    @NotNull(message = Msg.REQUIRED)
    @Size(max = SizeOf.Text.Max.LANGUAGE_ALPHA2, min = SizeOf.Text.Min.LANGUAGE_ALPHA2, message = Msg.SIZE)
    private String alpha2;

    @NotNull(message = Msg.REQUIRED)
    @Size(max = SizeOf.Text.Max.LANGUAGE_ALPHA3T, min = SizeOf.Text.Min.LANGUAGE_ALPHA3T, message = Msg.SIZE)
    private String alpha3T;

    @NotNull(message = Msg.REQUIRED)
    private Boolean unlisted;

    @NotNull(message = Msg.REQUIRED)
    private Boolean supported;

}
