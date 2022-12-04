package edu.estu.estufastingrestapi.core.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.UserService;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.user.UserPasswordUpdateRequest;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserFullyJoinedProjection;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserQuickProjection;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserSemiJoinedProjection;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/user")
@Api(tags = "User")
public class UserController {

    private final UserService userService;

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @GetMapping("/get/list/quick")
    public ResponseEntity<ApiResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.getList(pageRequestModel, UserQuickProjection.class));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @GetMapping("/get/list/semi_joined")
    public ResponseEntity<ApiResponse> getListSemiJoined(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.getList(pageRequestModel, UserSemiJoinedProjection.class));
    }

    @PreAuthorize("@securityChecker.isLoggedInUser(#username)")
    @GetMapping("/get/fully_joined/by_username")
    public ResponseEntity<ApiResponse> getByUsername(
            @RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.getOneFullyJoinedByUsername(username, UserFullyJoinedProjection.class));
    }

    @PreAuthorize("@securityChecker.isLoggedInUser(#username)")
    @PutMapping("/update/username")
    public ResponseEntity<ApiResponse> updateUsername(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @RequestParam @Pattern(regexp = Validation.User.RGX_EMAIL, message = MsgCode.VALIDATION_USER_EMAIL_PATTERN) String newUsername) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updateUsername(username, newUsername));
    }

    @PreAuthorize("@securityChecker.isLoggedInUser(#username)")
    @PutMapping("/update/phone_number")
    public ResponseEntity<ApiResponse> updatePhoneNumber(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @Pattern(regexp = Validation.User.RGX_PHONE_NUMBER, message = MsgCode.VALIDATION_USER_PHONE_NUMBER_PATTERN) @RequestParam String phoneNumber) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updatePhoneNumber(username, phoneNumber));
    }

    @PreAuthorize("@securityChecker.isLoggedInUser(#username)")
    @PutMapping("/update/language")
    public ResponseEntity<ApiResponse> updateLanguage(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @RequestParam(required = false) Integer languageId) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updateLanguage(username, languageId));
    }

    @PreAuthorize("@securityChecker.isLoggedInUser(#model.username) || hasAnyAuthority(T(edu.estu.estufastingrestapi.core.domain.constants.RoleConst$Name).SUPER_ADMIN)")
    @PutMapping("/update/password")
    public ResponseEntity<ApiResponse> updatePassword(
            @RequestBody UserPasswordUpdateRequest model) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updatePassword(model.getUsername(), model.getPassword()));
    }

    @PreAuthorize("@securityChecker.isLoggedInUser(#username)")
    @PutMapping("/update/first_name")
    public ResponseEntity<ApiResponse> updateFirstName(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @Size(min = Validation.User.MIN_LEN_FIRST_NAME, max = Validation.User.MAX_LEN_FIRST_NAME, message = MsgCode.VALIDATION_USER_FIRST_NAME_SIZE) @RequestParam String firstName) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updateFirstName(username, firstName));
    }

    @PreAuthorize("@securityChecker.isLoggedInUser(#username)")
    @PutMapping("/update/last_name")
    public ResponseEntity<ApiResponse> updateLastName(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @Size(min = Validation.User.MIN_LEN_LAST_NAME, max = Validation.User.MAX_LEN_LAST_NAME, message = MsgCode.VALIDATION_USER_LAST_NAME_SIZE) @RequestParam String lastName) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updateLastName(username, lastName));
    }

    @PreAuthorize("@securityChecker.isLoggedInUser(#username)")
    @PutMapping("/update/birth_date")
    public ResponseEntity<ApiResponse> updateBirthDate(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Past(message = MsgCode.VALIDATION_USER_BIRTH_DATE_PAST) @RequestParam LocalDate birthDate) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updateBirthDate(username, birthDate));
    }

    @PreAuthorize("@securityChecker.isLoggedInUser(#username) || hasAnyAuthority(T(edu.estu.estufastingrestapi.core.domain.constants.RoleConst$Name).SUPER_ADMIN)")
    @PutMapping("/update/enabled")
    public ResponseEntity<ApiResponse> updateEnabled(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) Boolean enabled) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updateEnabled(username, enabled));
    }

    @PreAuthorize("@securityChecker.isLoggedInUser(#username)")
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> delete(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.deleteByUsername(username));
    }

}
