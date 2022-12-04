package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.service.abstracts.DiningHallService;
import edu.estu.estufastingrestapi.service.model.response.dininghall.DiningHallFullyJoinedProjection;
import edu.estu.estufastingrestapi.service.model.response.dininghall.DiningHallQuickProjection;
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
@RequestMapping("/api/v1/dining_hall")
@Api(tags = "Dining Hall")
public class DiningHallController {

    private final DiningHallService diningHallService;

    @GetMapping("/get/one/fully_joined/by_id")
    public ResponseEntity<ApiResponse> getOneFullyJoined(
            @RequestParam Integer id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.getOneFullyJoinedId(id, DiningHallFullyJoinedProjection.class));
    }

    @GetMapping("/get/list/quick")
    public ResponseEntity<ApiResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.getList(pageRequestModel, DiningHallQuickProjection.class));
    }

    @GetMapping("/get/list/fully_joined")
    public ResponseEntity<ApiResponse> getListFullyJoined(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.getListFullyJoined(pageRequestModel, DiningHallFullyJoinedProjection.class));
    }

}
