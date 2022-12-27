package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.abstracts.StaffService;
import edu.estu.estufastingrestapi.service.model.request.staff.StaffCreateRequestModel;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/staff")
@Api(tags = "Staff")
public class StaffController {

    private final StaffService staffService;

    @GetMapping("/get/count")
    public ResponseEntity<ServiceResponse> getCount() {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(staffService.getCount());
    }

    @Secured({RoleConst.Name.SUPER_ADMIN})
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid StaffCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(staffService.create(model));
    }

}
