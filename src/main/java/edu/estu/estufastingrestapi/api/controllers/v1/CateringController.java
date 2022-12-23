package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.abstracts.CateringService;
import edu.estu.estufastingrestapi.service.model.request.catering.CateringCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.catering.CateringFullyJoinedProjection;
import edu.estu.estufastingrestapi.service.model.response.catering.CateringQuickProjection;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/catering")
@Api(tags = "Catering")
public class CateringController {

    private final CateringService cateringService;

    @GetMapping("/get/one/fully_joined/by_id")
    public ResponseEntity<ServiceResponse> getOneFullyJoinedById(
            @RequestParam UUID id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(cateringService.getOneFullyJoinedById(id, CateringFullyJoinedProjection.class));
    }

    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(cateringService.getList(pageRequestModel, CateringQuickProjection.class));
    }

    @GetMapping("/get/list/fully_joined")
    public ResponseEntity<ServiceResponse> getListFullyJoined(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(cateringService.getListFullyJoined(pageRequestModel, CateringFullyJoinedProjection.class));
    }

    @GetMapping("/get/list/fully_joined/date_between")
    public ResponseEntity<ServiceResponse> getListFullyJoinedDateBetween(
            @ModelAttribute @Valid PageRequestModel pageRequestModel,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate lower,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate upper) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(cateringService.getListByDateBetween(pageRequestModel, CateringFullyJoinedProjection.class, lower, upper));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid CateringCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(cateringService.create(model));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @PutMapping("/add_menu_item")
    public ResponseEntity<ServiceResponse> addMenuItem(
            @RequestParam UUID cateringId, @RequestParam UUID menuItemId) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(cateringService.addMenuItem(cateringId, menuItemId));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @PutMapping("/remove_menu_item")
    public ResponseEntity<ServiceResponse> removeMenuItem(
            @RequestParam UUID cateringId, @RequestParam UUID menuItemId) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(cateringService.removeMenuItem(cateringId, menuItemId));
    }

}
