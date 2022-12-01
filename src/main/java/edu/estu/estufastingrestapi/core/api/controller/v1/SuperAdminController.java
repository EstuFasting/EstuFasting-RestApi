package edu.estu.estufastingrestapi.core.api.controller.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.UserRole;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.SuperAdminService;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminCreateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminUpdateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.superadmin.SuperAdminFullyJoinedProjection;
import edu.estu.estufastingrestapi.core.service.model.response.superadmin.SuperAdminQuickProjection;
import edu.estu.estufastingrestapi.core.service.model.response.superadmin.SuperAdminSemiJoinedProjection;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/super_admin")
@Api(tags = "Super Admin")
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @PreAuthorize("@securityChecker.isLoggedInUser(#username)")
    @GetMapping("/get/one/fully_joined/by_username")
    public ResponseEntity<ApiResponse> getOneFullyJoinedByUsername(@RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getOneFullyJoinedByUsername(username, SuperAdminFullyJoinedProjection.class));
    }

    @PreAuthorize("@securityChecker.isLoggedInUser(#username)")
    @GetMapping("/get/one/semi_joined/by_username")
    public ResponseEntity<ApiResponse> getOneSemiJoinedByUsername(@RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getOneByProp(username, SuperAdminSemiJoinedProjection.class));
    }

    @Secured(UserRole.Name.SUPER_ADMIN)
    @GetMapping("/get/list/quick")
    public ResponseEntity<ApiResponse> getListQuick(@ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getList(pageRequestModel, SuperAdminQuickProjection.class));
    }

    @Secured(UserRole.Name.SUPER_ADMIN)
    @GetMapping("/get/list/semi_joined")
    public ResponseEntity<ApiResponse> getListSemiJoined(@ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getList(pageRequestModel, SuperAdminSemiJoinedProjection.class));
    }

    @PreAuthorize("!@securityChecker.isLoggedInUser(#model.username)")
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody @Valid SuperAdminCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.create(model));
    }

}
