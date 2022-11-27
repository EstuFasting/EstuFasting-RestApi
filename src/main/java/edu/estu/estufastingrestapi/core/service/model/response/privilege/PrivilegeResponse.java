package edu.estu.estufastingrestapi.core.service.model.response.privilege;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeResponse {

    private Integer id;

    private String name;

    private String description;

}
