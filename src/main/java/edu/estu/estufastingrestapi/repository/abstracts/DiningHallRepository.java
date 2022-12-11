package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.entities.concretes.DiningHall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiningHallRepository extends JpaRepositoryAdapter<DiningHall, Integer> {

    @Query("select sum(d.capacity) from DiningHall d")
    int getTotalCapacity();

    @Query(value = """
                select d from DiningHall d
                left join fetch d.meals
                where d.id = :id
            """)
    <P> Optional<P> findFirstFullyJoinedById(Integer id, Class<P> projection);

    @Query(value = """
                select d from DiningHall d
                left join d.meals
            """)
    <P> Page<P> findFullyJoined(Pageable pageable, Class<P> projection);

    @Modifying
    @Query("update DiningHall d set d.name = :name where d.id = :id")
    int updateName(Integer id, String name);

    @Modifying
    @Query("update DiningHall d set d.description = :description where d.id = :id")
    int updateDesc(Integer id, String description);

    @Modifying
    @Query("update DiningHall d set d.address = :address where d.id = :id")
    int updateAddress(Integer id, String address);

    @Modifying
    @Query("update DiningHall d set d.latitude = :latitude, d.longitude = :longitude where d.id = :id")
    int updateLatitudeAndLongitude(Integer id, Double latitude, Double longitude);

    @Modifying
    @Query("update DiningHall d set d.capacity = :capacity where d.id = :id")
    int updateCapacity(Integer id, Integer capacity);

    @Modifying
    @Query(value = "insert into tb_dining_hall_meal values (:diningHallId, :mealId)", nativeQuery = true)
    int addMeal(Integer diningHallId, Integer mealId);

    @Modifying
    @Query(value = "delete from tb_dining_hall_meal where rf_dining_hall = :diningHallId and rf_meal = :mealId", nativeQuery = true)
    int removeMeal(Integer diningHallId, Integer mealId);

}
