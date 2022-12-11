package edu.estu.estufastingrestapi.core.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.api.security.JwtTokenHelper;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.service.abstracts.SuperAdminService;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminCreateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.superadmin.SuperAdminFullyJoinedProjection;
import edu.estu.estufastingrestapi.core.service.model.response.superadmin.SuperAdminQuickProjection;
import edu.estu.estufastingrestapi.core.service.model.response.superadmin.SuperAdminSemiJoinedProjection;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
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
    private final JwtTokenHelper jwtTokenHelper;

    @PreAuthorize("@securityHelper.isLoggedInUser(#username)")
    @GetMapping("/get/one/fully_joined/by_username")
    public ResponseEntity<ServiceResponse> getOneFullyJoinedByUsername(@RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getOneFullyJoinedByUsername(username, SuperAdminFullyJoinedProjection.class));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#username)")
    @GetMapping("/get/one/semi_joined/by_username")
    public ResponseEntity<ServiceResponse> getOneSemiJoinedByUsername(@RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getOneByIdentifier(username, SuperAdminSemiJoinedProjection.class));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(@ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getList(pageRequestModel, SuperAdminQuickProjection.class));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @GetMapping("/get/list/semi_joined")
    public ResponseEntity<ServiceResponse> getListSemiJoined(@ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getList(pageRequestModel, SuperAdminSemiJoinedProjection.class));
    }

    @PreAuthorize("!@securityHelper.isLoggedInUser(#model.username)")
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid SuperAdminCreateRequestModel model) {
        ServiceDataResponse<?> serviceResponse = superAdminService.create(model);
        return ResponseBuilder.status(HttpStatus.CREATED)
                .header(HttpHeaders.AUTHORIZATION, jwtTokenHelper.generateToken(serviceResponse.getData()))
                .body(serviceResponse);
    }

}
