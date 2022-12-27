package edu.estu.estufastingrestapi.core.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import edu.estu.estufastingrestapi.core.repository.abstracts.UserRepository;
import edu.estu.estufastingrestapi.core.service.abstracts.UserService;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserAuthProjection;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.PageRequestMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.UserDetailsMapper;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.helper.ResponseHelper;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessDataResponse;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailsMapper userDetailsMapper;
    private final PageRequestMapper pageRequestMapper;

    @Override
    public String getPasswordByUsername(String username) {
        return userRepository.findPasswordByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userDetailsMapper.map(userRepository.findUserAuthoritiesByUsername(username, User.class)
                .orElseThrow(() -> new BadCredentialsException(MsgCode.SECURITY_RE_LOGIN_MALFORMED_JWT_USERNAME)));
    }

    @Override
    public UserAuthProjection getUserForLogin(String username) {
        return userRepository.findByUsernameForLogin(username).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public UserAuthProjection getUserAuthProjection(String username) {
        return userRepository.findUserAuthoritiesByUsername(username, UserAuthProjection.class).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(userRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceDataResponse<P> getOneByIdentifier(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(userRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getList(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(userRepository.findAllBy(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceResponse updateUsername(String username, String newUsername) {
        return ResponseHelper.getResponseBySuccess(userRepository.updateUserName(username, newUsername), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updatePhoneNumber(String username, String phoneNumber) {
        return ResponseHelper.getResponseBySuccess(userRepository.updatePhoneNumber(phoneNumber, username), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateLanguage(String username, Integer languageId) {
        return ResponseHelper.getResponseBySuccess(userRepository.updateLanguage(username, languageId), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updatePassword(String username, String password) {
        return ResponseHelper.getResponseBySuccess(userRepository.updatePassword(username, password), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateFirstName(String username, String firstname) {
        return ResponseHelper.getResponseBySuccess(userRepository.updateFirstName(username, firstname), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateLastName(String username, String lastName) {
        return ResponseHelper.getResponseBySuccess(userRepository.updateLastName(username, lastName), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateBirthDate(String username, LocalDate birthDate) {
        return ResponseHelper.getResponseBySuccess(userRepository.updateBirthDate(username, birthDate), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateEnabled(String username, Boolean enabled) {
        return ResponseHelper.getResponseBySuccess(userRepository.updateEnabled(username, enabled), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse delete(UUID id) {
        userRepository.deleteById(id);
        return new ServiceSuccessResponse(MsgCode.COMMON_SUCCESS_DELETED);
    }

    @Override
    public ServiceResponse deleteByUsername(String username) {
        return ResponseHelper.getResponseBySuccess(userRepository.deleteByUsername(username), MsgCode.COMMON_SUCCESS_DELETED);
    }
}
