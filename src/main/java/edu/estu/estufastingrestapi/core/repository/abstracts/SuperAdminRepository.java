package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.SuperAdmin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SuperAdminRepository extends JpaRepositoryAdapter<SuperAdmin, UUID> {

    @Query(value = """
                select s from SuperAdmin s
                left join fetch s.language l
                left join fetch s.roles r
                left join fetch r.privileges p
                where s.username = :username
            """)
    <P> Optional<P> findFullyJoinedByUsername(String username, Class<P> projection);

}
