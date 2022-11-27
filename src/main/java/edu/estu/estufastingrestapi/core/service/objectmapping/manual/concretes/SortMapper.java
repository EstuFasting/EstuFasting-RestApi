package edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes;

import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.OrderRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.SortRequestModel;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.abstracts.ManualMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SortMapper implements ManualMapper<SortRequestModel, Sort> {

    private final ManualMapper<OrderRequestModel, Sort.Order> orderMapper;

    @Override
    public Sort map(SortRequestModel sortModel) {
        return sortModel == null || sortModel.getOrders().isEmpty() ?
                Sort.unsorted() :
                Sort.by(orderMapper.mapCollection(sortModel.getOrders()));
    }

}
