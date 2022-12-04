package edu.estu.estufastingrestapi.service.model.request.dininghall;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class DiningHallCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_DINING_HALL_NAME_NOT_NULL)
    @Size(min = Validation.DiningHall.MIN_LEN_DINING_HALL_NAME, max = Validation.DiningHall.MAX_LEN_DINING_HALL_NAME, message = MsgCode.VALIDATION_DINING_HALL_NAME_SIZE)
    private String name;

    @Size(min = Validation.DiningHall.MIN_LEN_DINING_HALL_DESC, max = Validation.DiningHall.MAX_LEN_DINING_HALL_DESC, message = MsgCode.VALIDATION_DINING_HALL_DESCRIPTION_SIZE)
    private String description;

    @Size(min = Validation.DiningHall.MIN_LEN_DINING_HALL_ADDRESS_LINE, max = Validation.DiningHall.MAX_LEN_DINING_HALL_ADDRESS_LINE, message = MsgCode.VALIDATION_DINING_HALL_ADDRESS_SIZE)
    private String address;

    @Min(value = Validation.DiningHall.MIN_LEN_DINING_HALL_LATITUDE, message = MsgCode.VALIDATION_DINING_HALL_LATITUDE_MIN)
    @Max(value = Validation.DiningHall.MAX_LEN_DINING_HALL_LATITUDE, message = MsgCode.VALIDATION_DINING_HALL_LATITUDE_MAX)
    private Double latitude;

    @Min(value = Validation.DiningHall.MIN_LEN_DINING_HALL_LATITUDE, message = MsgCode.VALIDATION_DINING_HALL_LONGITUDE_MIN)
    @Max(value = Validation.DiningHall.MAX_LEN_DINING_HALL_LATITUDE, message = MsgCode.VALIDATION_DINING_HALL_LONGITUDE_MAX)
    private Double longitude;

    @Min(value = Validation.DiningHall.MIN_LEN_DINING_HALL_CAPACITY, message = MsgCode.VALIDATION_DINING_HALL_CAPACITY_MIN)
    private Integer capacity;

}