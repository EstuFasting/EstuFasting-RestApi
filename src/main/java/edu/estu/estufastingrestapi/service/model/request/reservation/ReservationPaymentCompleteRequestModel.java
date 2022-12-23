package edu.estu.estufastingrestapi.service.model.request.reservation;

import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationPaymentCompleteRequestModel implements RequestModel {

    @NotNull
    private List<@NotNull UUID> ids;

}
