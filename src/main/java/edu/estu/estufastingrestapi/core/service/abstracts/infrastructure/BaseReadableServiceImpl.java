package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.Mapper;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessDataResponse;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;

@Setter(onMethod = @__(@Autowired))
@Validated
@Transactional
public abstract class BaseReadableServiceImpl<E extends Identifiable<ID>, ID> implements ReadableService<ID> {

    protected JpaRepositoryAdapter<E, ID> repository;
    protected Mapper<PageRequestModel, PageRequest> pageRequestMapper;

    @Override
    public <P> ServiceDataResponse<P> getOneByIdentifier(ID id, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(repository.findById(id, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getList(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(repository.findAllBy(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

}
