package edu.estu.estufastingrestapi.core.model.dto.concretes;

import edu.estu.estufastingrestapi.core.model.dto.abstracts.Dto;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
