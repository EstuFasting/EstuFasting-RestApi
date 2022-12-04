package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LanguageResponseMapStructMapper.class, RoleResponseMapStructMapper.class})
public abstract class UserResponseMapStructMapper implements MapStructMapper<User, UserResponse> {
}
