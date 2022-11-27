package edu.estu.estufastingrestapi.core.api.controller.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
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
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/super_admin")
@Api(tags = "Super Admin")
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @GetMapping("/get/one/fully_joined/by_username")
    public ResponseEntity<ApiResponse> getOneFullyJoinedByUsername(@RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getFullyJoinedByUsername(username, SuperAdminFullyJoinedProjection.class));
    }

    @GetMapping("/get/one/semi_joined/by_id")
    public ResponseEntity<ApiResponse> getOneSemiJoinedById(@RequestParam UUID id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getById(id, SuperAdminSemiJoinedProjection.class));
    }

    @GetMapping("/get/list/quick")
    public ResponseEntity<ApiResponse> getListQuick(@ModelAttribute PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.get(pageRequestModel, SuperAdminQuickProjection.class));
    }

    @GetMapping("/get/list/semi_joined")
    public ResponseEntity<ApiResponse> getListSemiJoined(@ModelAttribute PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.get(pageRequestModel, SuperAdminSemiJoinedProjection.class));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody SuperAdminCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.create(model));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update(@RequestBody SuperAdminUpdateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.update(model));
    }

}
