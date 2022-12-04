package edu.estu.estufastingrestapi.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.ResponseHelper;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessDataResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseReadableServiceImpl;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.MenuItem;
import edu.estu.estufastingrestapi.repository.abstracts.MenuItemRepository;
import edu.estu.estufastingrestapi.service.abstracts.MenuItemService;
import edu.estu.estufastingrestapi.service.model.request.menuitem.MenuItemCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.menuitem.MenuItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuItemServiceImpl extends BaseReadableServiceImpl<MenuItem, UUID> implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final MapStructMapper<MenuItemCreateRequestModel, MenuItem> createRequestMapper;
    private final MapStructMapper<MenuItem, MenuItemResponse> menuItemResponseMapper;

    @Override
    public ApiResponse create(MenuItemCreateRequestModel model) {
        MenuItem saved = EntityServiceHelper.saveAndRefresh(menuItemRepository, createRequestMapper.map(model));
        return new ApiSuccessDataResponse<>(menuItemResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ApiResponse updateName(UUID id, String name) {
        return ResponseHelper.getResponseBySuccess(menuItemRepository.updateName(id, name), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updateCalories(UUID id, Integer calories) {
        return ResponseHelper.getResponseBySuccess(menuItemRepository.updateCalories(id, calories), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
