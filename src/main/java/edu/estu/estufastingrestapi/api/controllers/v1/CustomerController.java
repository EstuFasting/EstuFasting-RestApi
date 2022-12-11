package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.api.security.JwtTokenHelper;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.abstracts.CustomerService;
import edu.estu.estufastingrestapi.service.model.request.customer.CustomerCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.customer.CustomerFullyJoinedProjection;
import edu.estu.estufastingrestapi.service.model.response.customer.CustomerQuickProjection;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    private final JwtTokenHelper jwtTokenHelper;

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerService.getList(pageRequestModel, CustomerQuickProjection.class));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#username) or hasAnyAuthority(T(edu.estu.estufastingrestapi.core.domain.constants.RoleConst$Name).SUPER_ADMIN)")
    @GetMapping("/get/one/fully_joined/by_username")
    public ResponseEntity<ServiceResponse> getByUsername(
            @RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerService.getOneByIdentifier(username, CustomerFullyJoinedProjection.class));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid CustomerCreateRequestModel model) {
        ServiceDataResponse<?> serviceResponse = customerService.create(model);
        return ResponseBuilder.status(HttpStatus.CREATED)
                .header(HttpHeaders.AUTHORIZATION, jwtTokenHelper.generateToken(serviceResponse.getData()))
                .body(serviceResponse);
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @PutMapping("/update/type")
    public ResponseEntity<ServiceResponse> updateType(
            @RequestParam UUID id, @RequestParam Integer typeId) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerService.updateType(id, typeId));
    }

}
