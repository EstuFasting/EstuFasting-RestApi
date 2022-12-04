package edu.estu.estufastingrestapi.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.ResponseHelper;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessDataResponse;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.PageRequestMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
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
    public <P> ApiResponse getOneByIdentifier(String username, Class<P> projection) {
        return new ApiSuccessDataResponse<>(customerRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ApiResponse getList(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ApiSuccessDataResponse<>(customerRepository.findAllBy(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ApiResponse getOneFullyJoinedByUsername(String username, Class<P> projection) {
        return new ApiSuccessDataResponse<>(customerRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ApiResponse create(CustomerCreateRequestModel model) {
        Customer saved = EntityServiceHelper.saveAndRefresh(customerRepository, createRequestMapper.map(model));
        return new ApiSuccessDataResponse<>(customerResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ApiResponse updateType(UUID id, Integer customerTypeId) {
        return ResponseHelper.getResponseBySuccess(customerRepository.updateType(id, customerTypeId), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse makeReservation(UUID customerId, UUID cateringId) {
        return ResponseHelper.getResponseBySuccess(customerRepository.makeReservation(customerId, cateringId), MsgCode.CUSTOMER_RESERVATION_MAKE_SUCCESS);
    }

    @Override
    public ApiResponse cancelReservation(UUID customerId, UUID cateringId) {
        return ResponseHelper.getResponseBySuccess(customerRepository.cancelReservation(customerId, cateringId), MsgCode.CUSTOMER_RESERVATION_CANCEL_SUCCESS);
    }

}
