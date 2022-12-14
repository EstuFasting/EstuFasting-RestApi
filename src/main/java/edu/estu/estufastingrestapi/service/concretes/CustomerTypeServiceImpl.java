package edu.estu.estufastingrestapi.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseReadableServiceImpl;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.helper.ResponseHelper;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessDataResponse;
import edu.estu.estufastingrestapi.entities.concretes.CustomerType;
import edu.estu.estufastingrestapi.repository.abstracts.CustomerTypeRepository;
import edu.estu.estufastingrestapi.service.abstracts.CustomerTypeService;
import edu.estu.estufastingrestapi.service.model.request.customertype.CustomerTypeCreateRequestModel;
import edu.estu.estufastingrestapi.service.objectmapping.mapstruct.CustomerTypeCreateMapStructMapper;
import edu.estu.estufastingrestapi.service.objectmapping.mapstruct.CustomerTypeResponseMapStructMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerTypeServiceImpl extends BaseReadableServiceImpl<CustomerType, Integer> implements CustomerTypeService {

    private final CustomerTypeRepository customerTypeRepository;
    private final CustomerTypeResponseMapStructMapper customerTypeResponseMapper;
    private final CustomerTypeCreateMapStructMapper customerTypeCreateMapper;

    @Override
    public ServiceDataResponse<Model> create(CustomerTypeCreateRequestModel model) {
        CustomerType saved = EntityServiceHelper.saveAndRefresh(customerTypeRepository, customerTypeCreateMapper.map(model));
        return new ServiceSuccessDataResponse<>(customerTypeResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateName(Integer id, String name) {
        return ResponseHelper.getResponseBySuccess(customerTypeRepository.updateName(id, name), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateDesc(Integer id, String desc) {
        return ResponseHelper.getResponseBySuccess(customerTypeRepository.updateDesc(id, desc), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
