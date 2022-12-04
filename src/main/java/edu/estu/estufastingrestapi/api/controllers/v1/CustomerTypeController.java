package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.service.abstracts.CustomerTypeService;
import edu.estu.estufastingrestapi.service.model.response.customertype.CustomerTypeQuickProjection;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get/list/quick")
    public ResponseEntity<ApiResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerTypeService.getList(pageRequestModel, CustomerTypeQuickProjection.class));
    }

}
