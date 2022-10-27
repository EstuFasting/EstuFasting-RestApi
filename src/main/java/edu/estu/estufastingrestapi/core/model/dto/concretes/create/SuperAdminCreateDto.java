package sk6.my.templateproject.core.model.dto.concretes.create;

import io.swagger.annotations.ApiModel;
import sk6.my.templateproject.core.model.dto.abstracts.UserCreateDto;

@ApiModel(description = "Super type of user's create dto. Not used directly.")
public class SuperAdminCreateDto extends UserCreateDto {
}
