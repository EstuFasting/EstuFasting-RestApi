package edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes;

import edu.estu.estufastingrestapi.core.model.dto.pagerequest.OrderDto;
import edu.estu.estufastingrestapi.core.model.dto.pagerequest.SortDto;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.abstracts.ManualMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SortMapper implements ManualMapper<SortDto, Sort> {

    private final ManualMapper<OrderDto, Sort.Order> orderMapper;

    @Override
    public Sort map(SortDto sortDto) {
        return sortDto == null || sortDto.getOrders().isEmpty() ?
                Sort.unsorted() :
                Sort.by(orderMapper.mapCollection(sortDto.getOrders()));
    }

}
