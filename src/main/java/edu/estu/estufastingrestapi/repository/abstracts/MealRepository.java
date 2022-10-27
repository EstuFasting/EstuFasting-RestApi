package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.model.entities.Meal;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepositoryAdapter<Meal, Integer> {
}
