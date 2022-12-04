package edu.estu.estufastingrestapi.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.ResponseHelper;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessDataResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseReadableServiceImpl;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
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
    public ApiResponse create(CustomerTypeCreateRequestModel model) {
        CustomerType saved = EntityServiceHelper.saveAndRefresh(customerTypeRepository, customerTypeCreateMapper.map(model));
        return new ApiSuccessDataResponse<>(customerTypeResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ApiResponse updateName(Integer id, String name) {
        return ResponseHelper.getResponseBySuccess(customerTypeRepository.updateName(id, name), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updateDesc(Integer id, String desc) {
        return ResponseHelper.getResponseBySuccess(customerTypeRepository.updateDesc(id, desc), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
