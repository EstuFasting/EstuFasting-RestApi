package edu.estu.estufastingrestapi.core.service.abstracts;

import edu.estu.estufastingrestapi.core.model.entities.concretes.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUserName(String email);

}
