package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.EnableIsDeletedFilter;
import edu.estu.estufastingrestapi.core.model.dto.abstraction.Dto;
import edu.estu.estufastingrestapi.core.model.dto.pagerequest.PageRequestDto;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.Entity;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.SoftDeletable;
import edu.estu.estufastingrestapi.core.model.enumeration.CharFlag;
import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiResponse;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;
import edu.estu.estufastingrestapi.core.model.response.success.ApiSuccessDataResponse;
import edu.estu.estufastingrestapi.core.model.response.success.ApiSuccessResponse;
import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.Mapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Setter(onMethod = @__(@Autowired))

@Validated
@Transactional
public abstract class BaseEntityServiceImpl<E extends Identifiable<ID> & SoftDeletable & Entity, ID, C extends Dto, U extends Dto>
        implements CreatableService<C>, ReadableService, UpdatableService<U>, SoftDeletableService, DeletableService<ID>, EntityService {

    protected JpaRepositoryAdapter<E, ID> repository;
    protected Mapper<PageRequestDto, PageRequest> pageRequestMapper;
    protected Mapper<C, E> createDtoMapper;
    protected Mapper<U, E> updateDtoMapper;

    @Override
    @EnableIsDeletedFilter(CharFlag.FALSE)
    public <P> ApiResponse get(PageRequestDto pageRequestDto, Class<P> projection) {
        return new ApiSuccessDataResponse<>(repository.findAllBy(pageRequestMapper.map(pageRequestDto), projection));
    }

    @Override
    @EnableIsDeletedFilter(CharFlag.TRUE)
    public <P> ApiResponse getByDeletedTrue(PageRequestDto pageRequestDto, Class<P> projection) {
        return new ApiSuccessDataResponse<>(repository.findAllBy(pageRequestMapper.map(pageRequestDto), projection));
    }

    @Override
    public ApiResponse create(C dto) {
        return new ApiSuccessDataResponse<>(repository.save(createDtoMapper.map(dto)));
    }

    @Override
    public ApiResponse update(U dto) {
        return new ApiSuccessDataResponse<>(repository.save(updateDtoMapper.map(dto)));
    }

    @Override
    public ApiResponse delete(ID id) {
        repository.deleteById(id);
        return new ApiSuccessResponse(Msg.DELETED);
    }

}
