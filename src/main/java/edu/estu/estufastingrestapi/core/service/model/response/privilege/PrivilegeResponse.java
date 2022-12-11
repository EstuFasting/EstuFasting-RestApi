package edu.estu.estufastingrestapi.core.service.model.response.privilege;

import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeResponse implements Model {

    private Integer id;

    private String name;

    private String description;

}
