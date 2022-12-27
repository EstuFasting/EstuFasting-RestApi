package edu.estu.estufastingrestapi.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserAuthProjection;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.PageRequestMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.helper.ResponseHelper;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessDataResponse;
import edu.estu.estufastingrestapi.entities.concretes.Customer;
import edu.estu.estufastingrestapi.repository.abstracts.CustomerRepository;
import edu.estu.estufastingrestapi.service.abstracts.CustomerService;
import edu.estu.estufastingrestapi.service.model.request.customer.CustomerCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.customer.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final PageRequestMapper pageRequestMapper;
    private final MapStructMapper<CustomerCreateRequestModel, Customer> createRequestMapper;
    private final MapStructMapper<Customer, CustomerResponse> customerResponseMapper;

    @Override
    public String getPasswordByTckn(String tckn) {
        return customerRepository.findPasswordByTckn(tckn);
    }

    @Override
    public <P> ServiceDataResponse<P> getOneByIdentifier(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(customerRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public UserAuthProjection getCustomerForLoginByTckn(String tckn) {
        return customerRepository.findByUsernameForLogin(tckn).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public <P> ServiceResponse getList(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(customerRepository.findAllBy(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(customerRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(CustomerCreateRequestModel model) {
        Customer saved = EntityServiceHelper.saveAndRefresh(customerRepository, createRequestMapper.map(model));
        return new ServiceSuccessDataResponse<>(customerResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateType(UUID id, Integer customerTypeId) {
        return ResponseHelper.getResponseBySuccess(customerRepository.updateType(id, customerTypeId), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
