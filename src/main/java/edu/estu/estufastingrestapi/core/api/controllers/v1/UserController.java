package edu.estu.estufastingrestapi.core.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.abstracts.UserService;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.user.UserPasswordUpdateRequest;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserFullyJoinedProjection;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserQuickProjection;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserSemiJoinedProjection;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
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
    public ResponseEntity<ServiceResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.getList(pageRequestModel, UserQuickProjection.class));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @GetMapping("/get/list/semi_joined")
    public ResponseEntity<ServiceResponse> getListSemiJoined(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.getList(pageRequestModel, UserSemiJoinedProjection.class));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#username)")
    @GetMapping("/get/one/fully_joined/by_username")
    public ResponseEntity<ServiceResponse> getByUsername(
            @RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.getOneFullyJoinedByUsername(username, UserFullyJoinedProjection.class));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#username)")
    @PutMapping("/update/username")
    public ResponseEntity<ServiceResponse> updateUsername(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @RequestParam @Pattern(regexp = Validation.User.RGX_EMAIL, message = MsgCode.VALIDATION_USER_EMAIL_PATTERN) String newUsername) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updateUsername(username, newUsername));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#username)")
    @PutMapping("/update/phone_number")
    public ResponseEntity<ServiceResponse> updatePhoneNumber(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @RequestParam(required = false) @Pattern(regexp = Validation.User.RGX_PHONE_NUMBER, message = MsgCode.VALIDATION_USER_PHONE_NUMBER_PATTERN) String phoneNumber) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updatePhoneNumber(username, phoneNumber));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#username)")
    @PutMapping("/update/language")
    public ResponseEntity<ServiceResponse> updateLanguage(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @RequestParam(required = false) Integer languageId) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updateLanguage(username, languageId));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#model.username) || hasAnyAuthority(T(edu.estu.estufastingrestapi.core.domain.constants.RoleConst$Name).SUPER_ADMIN)")
    @PutMapping("/update/password")
    public ResponseEntity<ServiceResponse> updatePassword(
            @RequestBody UserPasswordUpdateRequest model) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updatePassword(model.getUsername(), model.getPassword()));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#username)")
    @PutMapping("/update/first_name")
    public ResponseEntity<ServiceResponse> updateFirstName(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @RequestParam(required = false) @Size(min = Validation.User.MIN_LEN_FIRST_NAME, max = Validation.User.MAX_LEN_FIRST_NAME, message = MsgCode.VALIDATION_USER_FIRST_NAME_SIZE) String firstName) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updateFirstName(username, firstName));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#username)")
    @PutMapping("/update/last_name")
    public ResponseEntity<ServiceResponse> updateLastName(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @RequestParam(required = false) @Size(min = Validation.User.MIN_LEN_LAST_NAME, max = Validation.User.MAX_LEN_LAST_NAME, message = MsgCode.VALIDATION_USER_LAST_NAME_SIZE) String lastName) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updateLastName(username, lastName));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#username)")
    @PutMapping("/update/birth_date")
    public ResponseEntity<ServiceResponse> updateBirthDate(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Past(message = MsgCode.VALIDATION_USER_BIRTH_DATE_PAST) LocalDate birthDate) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updateBirthDate(username, birthDate));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/enabled")
    public ResponseEntity<ServiceResponse> updateEnabled(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username,
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) Boolean enabled) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.updateEnabled(username, enabled));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#username)")
    @DeleteMapping("/delete")
    public ResponseEntity<ServiceResponse> delete(
            @RequestParam @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY) String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.deleteByUsername(username));
    }

}
