package edu.estu.estufastingrestapi.core.api.controller.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.api.security.JwtTokenHelper;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessDataResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.UserService;
import edu.estu.estufastingrestapi.core.service.model.request.authentication.LoginRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserAuthProjection;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    @SneakyThrows(BadCredentialsException.class)
    public ResponseEntity<ApiResponse> login(@RequestBody @Valid LoginRequestModel loginRequestModel) {
        String password = userService.getPasswordByUsername(loginRequestModel.getUsername());
        if (password == null)
            throw new UsernameNotFoundException(MsgCode.SECURITY_LOGIN_WRONG_USERNAME);
        if (!passwordEncoder.matches(loginRequestModel.getPassword(), password))
            throw new BadCredentialsException(MsgCode.SECURITY_LOGIN_WRONG_PASSWORD);

        UserAuthProjection user = userService.getUserForLogin(loginRequestModel.getUsername());
        return ResponseBuilder.status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, jwtTokenHelper.generateToken(user))
                .body(new ApiSuccessDataResponse<>(user, MsgCode.COMMON_SUCCESS));
    }

}
