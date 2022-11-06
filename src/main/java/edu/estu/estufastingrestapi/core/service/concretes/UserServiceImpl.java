package edu.estu.estufastingrestapi.core.service.concretes;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.EnableIsDeletedFilter;
import edu.estu.estufastingrestapi.core.model.entities.concretes.User;
import edu.estu.estufastingrestapi.core.repository.abstracts.UserRepository;
import edu.estu.estufastingrestapi.core.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @EnableIsDeletedFilter
    public Optional<User> findByUserName(String email) {
        return userRepository.findFirstByEmail(email);
    }


}
