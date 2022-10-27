package edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes;

import edu.estu.estufastingrestapi.core.model.dto.concretes.read.PageRequestDto;
import edu.estu.estufastingrestapi.core.model.dto.concretes.read.SortDto;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.abstracts.ManualMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageRequestMapper implements ManualMapper<PageRequestDto, PageRequest> {

    private final ManualMapper<SortDto, Sort> sortMapper;

    @Override
    public PageRequest map(PageRequestDto pageRequestDto) {
        return PageRequest.of(pageRequestDto.getPageNo(), pageRequestDto.getPageSize(), sortMapper.map(pageRequestDto.getSort()));
    }

}
