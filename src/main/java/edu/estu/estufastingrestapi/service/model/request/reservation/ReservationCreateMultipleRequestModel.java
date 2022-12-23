package edu.estu.estufastingrestapi.service.model.request.reservation;

import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationCreateMultipleRequestModel implements RequestModel {

    @NotNull
    private List<@Valid @NotNull ReservationCreateRequestModel> models;

}
