package sk6.my.templateproject.core.model.dto.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk6.my.templateproject.core.model.dto.abstracts.Dto;
import sk6.my.templateproject.core.model.response.helper.Msg;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto implements Dto {

    @NotBlank(message = Msg.REQUIRED)
    private String username;

    @NotBlank(message = Msg.REQUIRED)
    private String password;

}
