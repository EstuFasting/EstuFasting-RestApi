package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.model.entities.DiningHall;
import org.springframework.stereotype.Repository;

@Repository
public interface DiningHallRepository extends JpaRepositoryAdapter<DiningHall, Integer> {
}
