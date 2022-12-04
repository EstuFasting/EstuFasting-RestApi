package edu.estu.estufastingrestapi.service.model.response.customertype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTypeResponse {

    private Integer id;

    private String name;

    private String description;

}
