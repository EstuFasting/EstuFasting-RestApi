package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.entities.concretes.Catering;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CateringRepository extends JpaRepositoryAdapter<Catering, UUID> {

    @Query(value = """
                select c from Catering c
                left join fetch c.menuItems
                where c.id = :id
            """)
    <P> Optional<P> findFirstFullyJoinedById(UUID id, Class<P> projection);

    @Query(value = """
                select c from Catering c
                left join c.menuItems
            """)
    <P> Page<P> findFullyJoined(Pageable pageable, Class<P> projection);

    @Query(value = """
                select c from Catering c
                left join fetch c.reservations
                where c.id = :id
            """)
    <P> Optional<P> findCateringCustomersById(UUID id, Class<P> projection);

    @Modifying
    @Query(value = "insert into tb_menu values (:cateringId, :menuItemId)", nativeQuery = true)
    int addMenuItem(UUID cateringId, UUID menuItemId);

    @Modifying
    @Query(value = "delete from tb_menu where rf_catering = :cateringId and rf_menu_item = :menuItemId", nativeQuery = true)
    int removeMenuItem(UUID cateringId, UUID menuItemId);

}
