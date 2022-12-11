package edu.estu.estufastingrestapi.service.model.response.meal;

import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.service.model.response.dininghall.DiningHallResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealResponse implements Model {

    private Integer id;

    private String name;

    private LocalTime start;

    private LocalTime end;

    private Set<DiningHallResponse> diningHalls;

}
