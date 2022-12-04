package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.entities.concretes.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepositoryAdapter<Customer, UUID> {

    @Query(value = """
                select u from Customer u
                left join fetch u.language l
                left join fetch u.roles r
                left join fetch r.privileges p
                left join fetch u.reservations
                where u.username = :username
            """)
    <P> Optional<P> findFullyJoinedByUsername(String username, Class<P> projection);

    @Modifying
    @Query("update Customer c set c.type.id = :customerTypeId where c.id = :id")
    int updateType(UUID id, Integer customerTypeId);

    @Modifying
    @Query(value = "insert into tb_reservation values (:customerId, :cateringId)", nativeQuery = true)
    int makeReservation(UUID customerId, UUID cateringId);

    @Modifying
    @Query(value = "delete from tb_reservation where rf_customer = :customerId and rf_catering = :cateringId", nativeQuery = true)
    int cancelReservation(UUID customerId, UUID cateringId);

}
