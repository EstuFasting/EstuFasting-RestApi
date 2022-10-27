package edu.estu.estufastingrestapi.core.model.dto.concretes.update;

import edu.estu.estufastingrestapi.core.model.dto.abstracts.Dto;

public class LanguageUpdateDto implements Dto {

    private Integer id;

    private String englishName;

    private String localName;

    private String alpha2;

    private String alpha3T;

    private Boolean unlisted;

    private Boolean supported;

}
