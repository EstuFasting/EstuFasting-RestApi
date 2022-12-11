package edu.estu.estufastingrestapi.service.model.response.dininghall;

import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.service.model.response.meal.MealResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiningHallResponse implements Model {

    private Integer id;

    private String name;

    private String addressLine1;

    private String addressLine2;

    private Integer capacity;

    private Set<MealResponse> meals;

}
