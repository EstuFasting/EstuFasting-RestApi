package edu.estu.estufastingrestapi.service.model.request.catering;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import edu.estu.estufastingrestapi.core.service.validation.annotations.MaxCollectionSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CateringCreateRequestModel implements RequestModel {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = MsgCode.VALIDATION_CATERING_DATE_NOT_NULL)
    @Future(message = MsgCode.VALIDATION_CATERING_DATE_FUTURE)
    private LocalDate date;

    @Min(value = Validation.Catering.MAX_SIZE_MENU_ITEM_COUNT, message = MsgCode.VALIDATION_CATERING_PRICE_MIN)
    private Double price;

    @NotNull(message = MsgCode.VALIDATION_CATERING_MEAL_ID_NOT_NULL)
    private Integer mealId;

    @MaxCollectionSize(max = Validation.Catering.MAX_SIZE_MENU_ITEM_COUNT, message = MsgCode.VALIDATION_CATERING_MENU_ITEM_IDS_MAX_COLLECTION_SIZE)
    @NotNull(message = MsgCode.VALIDATION_CATERING_MENU_ITEM_IDS_NOT_NULL)
    private List<@NotNull(message = MsgCode.VALIDATION_CATERING_MENU_ITEM_IDS_ELEMENT_NOT_NULL) UUID> menuItemIds;

}
