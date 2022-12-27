package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.abstracts.ReservationService;
import edu.estu.estufastingrestapi.service.model.request.reservation.ReservationCreateMultipleRequestModel;
import edu.estu.estufastingrestapi.service.model.request.reservation.ReservationCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.request.reservation.ReservationPaymentCompleteRequestModel;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/v1/reservation")
@Api(tags = "Reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Secured({RoleConst.Name.USER})
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid ReservationCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(reservationService.create(model));
    }

    @Secured({RoleConst.Name.USER})
    @PostMapping("/create/multiple")
    public ResponseEntity<ServiceResponse> createMultiple(@RequestBody @Valid ReservationCreateMultipleRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(reservationService.createMultiple(model.getModels()));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(@reservationRepository.findCustomerUsernameById(#id).orElseThrow())")
    @PutMapping("/update/paid")
    public ResponseEntity<ServiceResponse> updatePaid(
            @RequestParam UUID id, @RequestParam Boolean paid) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(reservationService.updatePaid(id, paid));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(@reservationRepository.findCustomerUsernameById(#model.ids.get(0)).orElseThrow())")
    @PutMapping("/update/complete_reservation_payments")
    public ResponseEntity<ServiceResponse> completePaymentMultiple(
            @RequestBody ReservationPaymentCompleteRequestModel model) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(reservationService.completePaymentMultiple(model.getIds()));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(@reservationRepository.findCustomerUsernameById(#id).orElseThrow())")
    @DeleteMapping("/delete")
    public ResponseEntity<ServiceResponse> delete(
            @RequestParam UUID id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(reservationService.delete(id));
    }

}
