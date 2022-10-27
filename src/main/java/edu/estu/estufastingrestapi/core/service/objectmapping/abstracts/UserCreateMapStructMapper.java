package edu.estu.estufastingrestapi.core.service.objectmapping.abstracts;

import edu.estu.estufastingrestapi.core.model.dto.abstracts.UserCreateDto;
import edu.estu.estufastingrestapi.core.model.entities.concretes.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserCreateMapStructMapper implements MapStructMapper<UserCreateDto, User> {

    @Mapping(target = "language.id", source = "languageId")
    public abstract User map(UserCreateDto dto);

    @Mapping(target = "languageId", source = "language.id")
    public abstract UserCreateDto mapReverse(User entity);

}
