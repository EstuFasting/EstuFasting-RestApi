package edu.estu.estufastingrestapi.model.dto.update;

import edu.estu.estufastingrestapi.model.entities.Meal;
import edu.estu.estufastingrestapi.model.entities.Menu;

import java.util.UUID;

public class ServiceUpdateDto {

    private UUID id;

    private Meal meal;

    private Menu menu;

}
