package edu.estu.estufastingrestapi.core.model.dto.pagerequest;

import edu.estu.estufastingrestapi.core.model.dto.abstraction.Dto;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Dto {

    @NotBlank(message = Msg.REQUIRED)
    private String property;

    private Sort.Direction direction = Sort.Direction.ASC;

    private Sort.NullHandling nullHandling = Sort.NullHandling.NULLS_LAST;

    private boolean ignoreCase = false;

}
