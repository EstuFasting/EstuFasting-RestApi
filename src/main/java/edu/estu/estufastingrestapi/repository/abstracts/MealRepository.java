package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.entities.concretes.Meal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public interface MealRepository extends JpaRepositoryAdapter<Meal, Integer> {

    @Modifying
    @Query("update Meal m set m.name = :name where m.id = :id")
    int updateName(Integer id, String name);

    @Modifying
    @Query("update Meal m set m.start = :start where m.id = :id")
    int updateStart(Integer id, LocalTime start);

    @Modifying
    @Query("update Meal m set m.end = :end where m.id = :id")
    int updateEnd(Integer id, LocalTime end);

}
