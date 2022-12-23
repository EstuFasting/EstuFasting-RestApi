package edu.estu.estufastingrestapi.service.model.response.meal;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealResponse implements Model {

    private Integer id;

    private String name;

    @JsonFormat(pattern = "hh:mm")
    private LocalTime start;

    @JsonFormat(pattern = "hh:mm")
    private LocalTime end;

}
