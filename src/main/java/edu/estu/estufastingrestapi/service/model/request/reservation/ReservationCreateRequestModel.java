package edu.estu.estufastingrestapi.service.model.request.reservation;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_CUSTOMER_ID_NOT_NULL)
    private UUID customerId;

    @NotNull(message = MsgCode.VALIDATION_CATERING_ID_NOT_NULL)
    private UUID cateringId;

}
