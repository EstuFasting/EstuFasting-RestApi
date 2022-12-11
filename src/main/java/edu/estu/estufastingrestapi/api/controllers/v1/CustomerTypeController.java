package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.abstracts.CustomerTypeService;
import edu.estu.estufastingrestapi.service.model.request.customertype.CustomerTypeCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.customertype.CustomerTypeQuickProjection;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/customer_type")
@Api(tags = "Customer Type")
public class CustomerTypeController {

    private final CustomerTypeService customerTypeService;

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerTypeService.getList(pageRequestModel, CustomerTypeQuickProjection.class));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid CustomerTypeCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(customerTypeService.create(model));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/name")
    public ResponseEntity<ServiceResponse> updateName(
            @RequestParam Integer id,
            @RequestParam @Size(min = Validation.CustomerType.MIN_LEN_NAME, max = Validation.CustomerType.MAX_LEN_NAME, message = MsgCode.VALIDATION_CUSTOMER_TYPE_NAME_SIZE) String name) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerTypeService.updateName(id, name));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/description")
    public ResponseEntity<ServiceResponse> updateDescription(
            @RequestParam Integer id,
            @RequestParam @Size(min = Validation.CustomerType.MIN_LEN_DESC, max = Validation.CustomerType.MAX_LEN_DESC, message = MsgCode.VALIDATION_CUSTOMER_TYPE_DESCRIPTION_SIZE) String description) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerTypeService.updateDesc(id, description));
    }

}
