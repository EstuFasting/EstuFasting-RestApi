package edu.estu.estufastingrestapi.core.model.dto.pagerequest;

import edu.estu.estufastingrestapi.core.model.constants.Validation;
import edu.estu.estufastingrestapi.core.service.validation.annotations.MaxCollectionSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SortDto {

    @MaxCollectionSize(Validation.PageRequest.MAX_SIZE_ORDER_COUNT)
    private List<@Valid OrderDto> orders;

}
