package edu.estu.estufastingrestapi.service.model.response.customertype;

import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTypeResponse implements Model {

    private Integer id;

    private String name;

    private String description;

}
