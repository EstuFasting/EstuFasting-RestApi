package edu.estu.estufastingrestapi.core.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import edu.estu.estufastingrestapi.core.domain.response.ResponseHelper;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessDataResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessResponse;
import edu.estu.estufastingrestapi.core.repository.abstracts.UserRepository;
import edu.estu.estufastingrestapi.core.service.abstracts.UserService;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserAuthProjection;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.PageRequestMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.UserDetailsMapper;
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
    public UserAuthProjection getUserAuthoritiesByUsername(String username) {
        return userRepository.findUserAuthoritiesByUsername(username, UserAuthProjection.class).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public <P> ApiResponse getOneFullyJoinedByUsername(String username, Class<P> projection) {
        return new ApiSuccessDataResponse<>(userRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ApiResponse getOneByIdentifier(String username, Class<P> projection) {
        return new ApiSuccessDataResponse<>(userRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ApiResponse getList(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ApiSuccessDataResponse<>(userRepository.findAllBy(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ApiResponse updateUsername(String username, String newUsername) {
        return ResponseHelper.getResponseBySuccess(userRepository.updateUserName(username, newUsername), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updatePhoneNumber(String username, String phoneNumber) {
        return ResponseHelper.getResponseBySuccess(userRepository.updatePhoneNumber(phoneNumber, username), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updateLanguage(String username, Integer languageId) {
        return ResponseHelper.getResponseBySuccess(userRepository.updateLanguage(username, languageId), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updatePassword(String username, String password) {
        return ResponseHelper.getResponseBySuccess(userRepository.updatePassword(username, password), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updateFirstName(String username, String firstname) {
        return ResponseHelper.getResponseBySuccess(userRepository.updateFirstName(username, firstname), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updateLastName(String username, String lastName) {
        return ResponseHelper.getResponseBySuccess(userRepository.updateLastName(username, lastName), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updateBirthDate(String username, LocalDate birthDate) {
        return ResponseHelper.getResponseBySuccess(userRepository.updateBirthDate(username, birthDate), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updateEnabled(String username, Boolean enabled) {
        return ResponseHelper.getResponseBySuccess(userRepository.updateEnabled(username, enabled), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse delete(UUID id) {
        userRepository.deleteById(id);
        return new ApiSuccessResponse(MsgCode.COMMON_SUCCESS_DELETED);
    }

    @Override
    public ApiResponse deleteByUsername(String username) {
        return ResponseHelper.getResponseBySuccess(userRepository.deleteByUsername(username), MsgCode.COMMON_SUCCESS_DELETED);
    }
}
