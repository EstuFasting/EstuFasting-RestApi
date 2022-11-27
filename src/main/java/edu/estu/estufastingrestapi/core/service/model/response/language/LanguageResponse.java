package edu.estu.estufastingrestapi.core.service.model.response.language;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageResponse {

    private Integer id;

    private String name;

    private String localName;

    private String alpha2;

    private String alpha3T;

    private Boolean unlisted;

    private Boolean supported;

}
