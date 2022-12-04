package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.service.abstracts.CustomerService;
import edu.estu.estufastingrestapi.service.model.request.customer.CustomerCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.customer.CustomerFullyJoinedProjection;
import edu.estu.estufastingrestapi.service.model.response.customer.CustomerQuickProjection;
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
@RequestMapping("/api/v1/customer")
@Api(tags = "Customer")
public class CustomerController {

    private final CustomerService customerService;

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @GetMapping("/get/list/quick")
    public ResponseEntity<ApiResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerService.getList(pageRequestModel, CustomerQuickProjection.class));
    }

    @PreAuthorize("@securityChecker.isLoggedInUser(#username) or hasAnyAuthority(T(edu.estu.estufastingrestapi.core.domain.constants.RoleConst$Name).SUPER_ADMIN)")
    @GetMapping("/get/fully_joined/by_username")
    public ResponseEntity<ApiResponse> getByUsername(
            @RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerService.getOneFullyJoinedByUsername(username, CustomerFullyJoinedProjection.class));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody @Valid CustomerCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerService.create(model));
    }

}
