package edu.estu.estufastingrestapi.service.model.response.menuitem;

import edu.estu.estufastingrestapi.core.service.model.response.abstraction.AuditedResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemResponse extends AuditedResponse {

    private UUID id;

    private String name;

    private Integer calories;

}
