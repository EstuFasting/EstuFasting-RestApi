package edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.ReturnIfNull;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.SortRequestModel;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.abstracts.ManualMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageRequestMapper implements ManualMapper<PageRequestModel, PageRequest> {

    private final ManualMapper<SortRequestModel, Sort> sortMapper;

    @Override
    public PageRequest map(@ReturnIfNull PageRequestModel pageRequestModel) {
        return PageRequest.of(pageRequestModel.getPageNo(), pageRequestModel.getPageSize(), sortMapper.map(pageRequestModel.getSort()));
    }

}
