package edu.estu.estufastingrestapi.core.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessDataResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessResponse;
import edu.estu.estufastingrestapi.core.repository.abstracts.UserRepository;
import edu.estu.estufastingrestapi.core.service.abstracts.UserService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseReadableServiceImpl;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.UserDetailsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl extends BaseReadableServiceImpl<User, UUID> implements UserService {

    private final UserRepository userRepository;
    private final UserDetailsMapper userDetailsMapper;

    @Override
    public String getPasswordByUsername(String username) {
        return userRepository.findPasswordByUsername(username);
    }

    @Override
    public User getUserForLogin(String username) {
        return userRepository.findFullyJoinedByUsername(username, User.class).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public <P> ApiResponse getFullyJoinedById(UUID id, Class<P> projection) {
        return new ApiSuccessDataResponse<>(userRepository.findFullyJoinedById(id, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ApiResponse getFullyJoinedByUsername(String username, Class<P> projection) {
        return new ApiSuccessDataResponse<>(userRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userDetailsMapper.map(userRepository.findByUsernameForSecurity(username, User.class)
                .orElseThrow(() -> new BadCredentialsException(MsgCode.SECURITY_RE_LOGIN_MALFORMED_JWT_USERNAME)));
    }

    @Override
    public ApiResponse delete(UUID id) {
        repository.deleteById(id);
        return new ApiSuccessResponse(MsgCode.COMMON_SUCCESS_DELETED);
    }

}
