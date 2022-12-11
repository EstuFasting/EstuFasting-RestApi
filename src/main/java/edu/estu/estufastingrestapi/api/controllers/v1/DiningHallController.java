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
import edu.estu.estufastingrestapi.service.abstracts.DiningHallService;
import edu.estu.estufastingrestapi.service.model.request.dininghall.DiningHallCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.dininghall.DiningHallFullyJoinedProjection;
import edu.estu.estufastingrestapi.service.model.response.dininghall.DiningHallQuickProjection;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

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

    @GetMapping("/get/count")
    public ResponseEntity<ServiceResponse> getCount() {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.getCount());
    }

    @GetMapping("/get/total_capacity")
    public ResponseEntity<ServiceResponse> getTotalCapacity() {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.getTotalCapacity());
    }

    @GetMapping("/get/one/fully_joined/by_id")
    public ResponseEntity<ServiceResponse> getOneFullyJoined(
            @RequestParam Integer id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.getOneFullyJoinedId(id, DiningHallFullyJoinedProjection.class));
    }

    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.getList(pageRequestModel, DiningHallQuickProjection.class));
    }

    @GetMapping("/get/list/fully_joined")
    public ResponseEntity<ServiceResponse> getListFullyJoined(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.getListFullyJoined(pageRequestModel, DiningHallFullyJoinedProjection.class));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid DiningHallCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(diningHallService.create(model));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/name")
    public ResponseEntity<ServiceResponse> updateName(
            @RequestParam Integer id,
            @RequestParam @Size(min = Validation.DiningHall.MIN_LEN_NAME, max = Validation.DiningHall.MAX_LEN_NAME, message = MsgCode.VALIDATION_DINING_HALL_NAME_SIZE) String name) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.updateName(id, name));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/description")
    public ResponseEntity<ServiceResponse> updateDesc(
            @RequestParam Integer id,
            @RequestParam(required = false) @Size(min = Validation.DiningHall.MIN_LEN_DESC, max = Validation.DiningHall.MAX_LEN_DESC, message = MsgCode.VALIDATION_DINING_HALL_DESCRIPTION_SIZE) String description) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.updateDesc(id, description));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/address")
    public ResponseEntity<ServiceResponse> updateAddress(
            @RequestParam Integer id,
            @RequestParam @Size(min = Validation.DiningHall.MIN_LEN_ADDRESS_LINE, max = Validation.DiningHall.MAX_LEN_ADDRESS_LINE, message = MsgCode.VALIDATION_DINING_HALL_ADDRESS_SIZE) String address) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.updateAddress(id, address));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/latitude_and_longitude")
    public ResponseEntity<ServiceResponse> updateLatitudeAndLongitude(
            @RequestParam Integer id,
            @RequestParam @Min(value = Validation.DiningHall.MIN_VAL_LATITUDE, message = MsgCode.VALIDATION_DINING_HALL_LATITUDE_MIN) @Max(value = Validation.DiningHall.MAX_VAL_LATITUDE, message = MsgCode.VALIDATION_DINING_HALL_LATITUDE_MAX) Double latitude,
            @RequestParam @Min(value = Validation.DiningHall.MIN_VAL_LONGITUDE, message = MsgCode.VALIDATION_DINING_HALL_LONGITUDE_MIN) @Max(value = Validation.DiningHall.MAX_VAL_LONGITUDE, message = MsgCode.VALIDATION_DINING_HALL_LONGITUDE_MAX) Double longitude) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.updateLatitudeAndLongitude(id, latitude, longitude));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/capacity")
    public ResponseEntity<ServiceResponse> updateCapacity(
            @RequestParam Integer id,
            @RequestParam(required = false) @Size(min = Validation.DiningHall.MIN_LEN_NAME, max = Validation.DiningHall.MAX_LEN_NAME, message = MsgCode.VALIDATION_DINING_HALL_NAME_SIZE) Integer capacity) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.updateCapacity(id, capacity));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/meal/add")
    public ResponseEntity<ServiceResponse> addMeal(
            @RequestParam Integer id, @RequestParam Integer mealId) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.addMeal(id, mealId));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/meal/remove")
    public ResponseEntity<ServiceResponse> removeMeal(
            @RequestParam Integer id, @RequestParam Integer mealId) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(diningHallService.removeMeal(id, mealId));
    }

}
