package edu.estu.estufastingrestapi.core.service.concretes;

import edu.estu.estufastingrestapi.core.model.dto.superadmin.SuperAdminCreateDto;
import edu.estu.estufastingrestapi.core.model.dto.superadmin.SuperAdminUpdateDto;
import edu.estu.estufastingrestapi.core.model.entities.concretes.SuperAdmin;
import edu.estu.estufastingrestapi.core.service.abstracts.SuperAdminService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseEntityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SuperAdminServiceImpl extends BaseEntityServiceImpl<SuperAdmin, UUID, SuperAdminCreateDto, SuperAdminUpdateDto> implements SuperAdminService {
}
