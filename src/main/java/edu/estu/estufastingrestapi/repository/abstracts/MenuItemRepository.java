package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.entities.concretes.MenuItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuItemRepository extends JpaRepositoryAdapter<MenuItem, UUID> {

    @Modifying
    @Query("update MenuItem m set m.name = :name where m.id = :id")
    int updateName(UUID id, String name);

    @Modifying
    @Query("update MenuItem m set m.calories = :calories where m.id = :id")
    int updateCalories(UUID id, Integer calories);

}
