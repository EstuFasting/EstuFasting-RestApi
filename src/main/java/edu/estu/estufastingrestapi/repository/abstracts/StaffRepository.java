package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.entities.concretes.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StaffRepository extends JpaRepositoryAdapter<Staff, UUID> {

    @Query(value = """
                select u from Staff u
                left join fetch u.language l
                left join fetch u.roles r
                left join fetch r.privileges p
                where u.username = :username
            """)
    <P> Optional<P> findFullyJoinedByUsername(String username, Class<P> projection);

}
