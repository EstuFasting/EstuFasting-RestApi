package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.abstracts.MenuItemService;
import edu.estu.estufastingrestapi.service.model.request.menuitem.MenuItemCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.menuitem.MenuItemQuickProjection;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/menu_item")
@Api(tags = "Menu Item")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/one/fully_joined/by_id")
    public ResponseEntity<ServiceResponse> getOneFullyJoined(
            @RequestParam UUID id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(menuItemService.getOneByIdentifier(id, MenuItemQuickProjection.class));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(menuItemService.getList(pageRequestModel, MenuItemQuickProjection.class));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid MenuItemCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(menuItemService.create(model));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/name")
    public ResponseEntity<ServiceResponse> updateName(
            @RequestParam UUID id, @RequestParam String name) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(menuItemService.updateName(id, name));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/calories")
    public ResponseEntity<ServiceResponse> updateCalories(
            @RequestParam UUID id, @RequestParam Integer calories) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(menuItemService.updateCalories(id, calories));
    }

}
