package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.abstracts.MealService;
import edu.estu.estufastingrestapi.service.model.request.meal.MealCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.meal.MealQuickProjection;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/meal")
@Api(tags = "Meal")
public class MealController {

    private final MealService mealService;

    @GetMapping("/get/count")
    public ResponseEntity<ServiceResponse> getCount() {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(mealService.getCount());
    }

    @GetMapping("/get/one/fully_joined/by_id")
    public ResponseEntity<ServiceResponse> getOneFullyJoined(
            @RequestParam Integer id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(mealService.getOneByIdentifier(id, MealQuickProjection.class));
    }

    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(mealService.getList(pageRequestModel, MealQuickProjection.class));
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid MealCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(mealService.create(model));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/name")
    public ResponseEntity<ServiceResponse> updateName(
            @RequestParam Integer id, @RequestParam String name) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(mealService.updateName(id, name));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/start")
    public ResponseEntity<ServiceResponse> updateStart(
            @RequestParam Integer id, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime start) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(mealService.updateStart(id, start));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/end")
    public ResponseEntity<ServiceResponse> updateEnd(
            @RequestParam Integer id, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime end) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(mealService.updateEnd(id, end));
    }

}
