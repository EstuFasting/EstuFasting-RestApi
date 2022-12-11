package edu.estu.estufastingrestapi.service.model.request.menuitem;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_MENU_ITEM_NAME_NOT_NULL)
    @Size(min = Validation.MenuItem.MIN_LEN_NAME, max = Validation.MenuItem.MAX_LEN_NAME, message = MsgCode.VALIDATION_MENU_ITEM_NAME_SIZE)
    private String name;

    @Min(value = Validation.MenuItem.MIN_VAL_CALORIES, message = MsgCode.VALIDATION_MENU_ITEM_CALORIES_MIN)
    private Integer calories;

}
