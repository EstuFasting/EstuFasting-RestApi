package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.service.abstracts.MenuItemService;
import edu.estu.estufastingrestapi.service.model.response.menuitem.MenuItemQuickProjection;
import io.swagger.annotations.Api;
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
    public ResponseEntity<ApiResponse> getOneFullyJoined(
            @RequestParam UUID id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(menuItemService.getOneByIdentifier(id, MenuItemQuickProjection.class));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick")
    public ResponseEntity<ApiResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(menuItemService.getList(pageRequestModel, MenuItemQuickProjection.class));
    }

}
