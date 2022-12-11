package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.entities.concretes.Reservation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepositoryAdapter<Reservation, UUID> {

    @Query(value = """
                select r.customer.username from Reservation r
                where r.id = :id
            """)
    Optional<String> findCustomerUsernameById(UUID id);

    @Modifying
    @Query("update Reservation r set r.paid = :paid where r.id = :id")
    int updatePaid(UUID id, Boolean paid);

}
