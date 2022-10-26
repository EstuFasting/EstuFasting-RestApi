package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.model.entities.concretes.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepositoryAdapter<User, UUID> {

    Optional<User> findFirstByUsername(String username);

    Optional<User> findFirstByEmail(String email);

    Optional<User> findFirstByPhoneNumber(String phoneNumber);

}
