package edu.estu.estufastingrestapi.model.dto.update;

import edu.estu.estufastingrestapi.model.entities.MenuItem;

import java.util.Collection;
import java.util.UUID;

public class MenuUpdateDto {

    private UUID id;

    private Collection<MenuItem> menuItems;

}
