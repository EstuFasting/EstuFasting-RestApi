package edu.estu.estufastingrestapi.core.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.api.security.JwtTokenHelper;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.abstracts.UserService;
import edu.estu.estufastingrestapi.core.service.model.request.authentication.CustomerLoginRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.authentication.ManagementLoginRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserAuthProjection;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessDataResponse;
import edu.estu.estufastingrestapi.service.abstracts.CustomerService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Api(tags = "Authentication")
public class AuthController {

    private final JwtTokenHelper jwtTokenHelper;
    private final UserService userService;
    private final CustomerService customerService;
    private final BCryptPasswordEncoder passwordEncoder;

    @PreAuthorize("@staffRepository.existsByUsername(#model.identifier) or @superAdminRepository.existsByUsername(#model.identifier)")
    @PostMapping("/login/management")
    @SneakyThrows(BadCredentialsException.class)
    public ResponseEntity<ServiceResponse> loginManagement(@RequestBody @Valid ManagementLoginRequestModel model) {
        String password = userService.getPasswordByUsername(model.getIdentifier());
        checkPassword(password, model.getPassword());

        UserAuthProjection user = userService.getUserForLogin(model.getIdentifier());
        return ResponseBuilder.status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, jwtTokenHelper.generateToken(user))
                .body(new ServiceSuccessDataResponse<>(user, MsgCode.COMMON_SUCCESS));
    }

    @PostMapping("/login/customer")
    @SneakyThrows(BadCredentialsException.class)
    public ResponseEntity<ServiceResponse> loginCustomer(@RequestBody @Valid CustomerLoginRequestModel model) {
        boolean isTckn = model.getIdentifier().matches(Validation.Customer.RGX_TCKN);
        String password = isTckn ?
                customerService.getPasswordByTckn(model.getIdentifier()) :
                userService.getPasswordByUsername(model.getIdentifier());
        checkPassword(password, model.getPassword());

        UserAuthProjection user = isTckn ?
                customerService.getCustomerForLoginByTckn(model.getIdentifier()) :
                userService.getUserForLogin(model.getIdentifier());
        return ResponseBuilder.status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, jwtTokenHelper.generateToken(user))
                .body(new ServiceSuccessDataResponse<>(user, MsgCode.COMMON_SUCCESS));
    }

    private void checkPassword(String real, String given) {
        if (real == null)
            throw new UsernameNotFoundException(MsgCode.SECURITY_LOGIN_WRONG_USERNAME);
        if (!passwordEncoder.matches(given, real))
            throw new BadCredentialsException(MsgCode.SECURITY_LOGIN_WRONG_PASSWORD);
    }
}
