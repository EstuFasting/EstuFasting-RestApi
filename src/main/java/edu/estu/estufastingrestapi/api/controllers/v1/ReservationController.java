package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.abstracts.ReservationService;
import edu.estu.estufastingrestapi.service.model.request.reservation.ReservationCreateRequestModel;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid ReservationCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(reservationService.create(model));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(@reservationRepository.findCustomerUsernameById(#id).orElseThrow())")
    @PutMapping("/update/paid")
    public ResponseEntity<ServiceResponse> updatePaid(
            @RequestParam UUID id, @RequestParam Boolean reviewed) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(reservationService.updatePaid(id, reviewed));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(@reservationRepository.findCustomerUsernameById(#id).orElseThrow())")
    @DeleteMapping("/delete")
    public ResponseEntity<ServiceResponse> delete(
            @RequestParam UUID id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(reservationService.delete(id));
    }

}
