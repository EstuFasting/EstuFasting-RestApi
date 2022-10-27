package edu.estu.estufastingrestapi.core.model.dto.concretes.read;

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

    @MaxCollectionSize(3)
    private List<@Valid OrderDto> orders;

}
