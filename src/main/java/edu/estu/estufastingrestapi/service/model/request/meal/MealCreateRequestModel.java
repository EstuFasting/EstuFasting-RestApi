package edu.estu.estufastingrestapi.service.model.request.meal;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import edu.estu.estufastingrestapi.core.service.validation.annotations.ScheduleConflictCheck;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;

@Getter
@Setter
@ScheduleConflictCheck(message = MsgCode.VALIDATION_MEAL_SCHEDULE_CONFLICT_CHECK)
public class MealCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_MEAL_NAME_NOT_NULL)
    @Size(min = Validation.Meal.MIN_LEN_MEAL_NAME, max = Validation.Meal.MAX_LEN_MEAL_NAME, message = MsgCode.VALIDATION_MEAL_NAME_SIZE)
    private String name;

    @NotNull(message = MsgCode.VALIDATION_MEAL_START_NOT_NULL)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime start;

    @NotNull(message = MsgCode.VALIDATION_MEAL_END_NOT_NULL)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime end;

}