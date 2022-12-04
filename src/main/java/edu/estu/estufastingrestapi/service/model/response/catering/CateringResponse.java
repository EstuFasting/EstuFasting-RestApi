package edu.estu.estufastingrestapi.service.model.response.catering;

import edu.estu.estufastingrestapi.core.service.model.response.abstraction.AuditedResponse;
import edu.estu.estufastingrestapi.service.model.response.meal.MealResponse;
import edu.estu.estufastingrestapi.service.model.response.menuitem.MenuItemResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CateringResponse extends AuditedResponse {

    private UUID id;

    private LocalDate date;

    private MealResponse meal;

    private List<MenuItemResponse> menuItems;

}
