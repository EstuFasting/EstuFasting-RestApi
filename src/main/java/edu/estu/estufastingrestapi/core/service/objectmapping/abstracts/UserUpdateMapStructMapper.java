package edu.estu.estufastingrestapi.core.service.objectmapping.abstracts;

import edu.estu.estufastingrestapi.core.model.dto.abstracts.UserUpdateDto;
import edu.estu.estufastingrestapi.core.model.entities.concretes.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserUpdateMapStructMapper implements MapStructMapper<UserUpdateDto, User> {

    @Mapping(target = "language.id", source = "dto.languageId")
    public abstract User map(UserUpdateDto dto);

    @Mapping(target = "languageId", source = "entity.language.id")
    public abstract UserUpdateDto mapReverse(User entity);

}
