package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.LanguageResponseMapStructMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.RoleResponseMapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.Staff;
import edu.estu.estufastingrestapi.service.model.response.staff.StaffResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LanguageResponseMapStructMapper.class, RoleResponseMapStructMapper.class})
public abstract class StaffResponseMapStructMapper implements MapStructMapper<Staff, StaffResponse> {
}
