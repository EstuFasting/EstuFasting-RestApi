package edu.estu.estufastingrestapi.core.domain.constants;

import lombok.experimental.UtilityClass;

/**
 * Message codes to be passed as parameter to message source
 */
@UtilityClass
public class MsgCode {

    public final String COMMON_SUCCESS = "{Common.Success}";
    public final String COMMON_SUCCESS_FETCHED = "{Common.Success.Fetched}";
    public final String COMMON_SUCCESS_SAVED = "{Common.Success.Saved}";
    public final String COMMON_SUCCESS_UPDATED = "{Common.Success.Updated}";
    public final String COMMON_SUCCESS_DELETED = "{Common.Success.Deleted}";
    public final String COMMON_SUCCESS_ROLLED_BACK = "{Common.Success.RolledBack}";

    public final String COMMON_ERROR = "{Common.Error}";
    public final String COMMON_ERROR_UNSUCCESSFUL = "{Common.Error.Unsuccessful}";
    public final String COMMON_ERROR_ENTITY_NOT_FOUND = "{Common.Error.EntityNotFound}";
    public final String COMMON_ERROR_AUTHENTICATION = "{Common.Error.Authentication}";
    public final String COMMON_ERROR_INVALID = "{Common.Error.Invalid}";

    public final String CUSTOMER_RESERVATION_MAKE_SUCCESS = "{Customer.Reservation.Make.Success}";
    public final String CUSTOMER_RESERVATION_CANCEL_SUCCESS = "{Customer.Reservation.Cancel.Success}";
    public final String CATERING_MENU_ITEM_ADD_SUCCESS = "{Catering.MenuItem.Add.Success}";
    public final String CATERING_MENU_ITEM_REMOVE_SUCCESS = "{Catering.MenuItem.Remove.Success}";
    public final String DINING_HALL_MEAL_ADD_SUCCESS = "{DiningHall.Meal.Add.Success}";
    public final String DINING_HALL_MEAL_REMOVE_SUCCESS = "{DiningHall.Meal.Remove.Success}";

    public final String SECURITY_ACCESS_IS_DENIED = "{Security.AccessIsDenied}";
    public final String SECURITY_LOGIN_WRONG_USERNAME = "{Security.Login.WrongUsername}";
    public final String SECURITY_LOGIN_WRONG_PASSWORD = "{Security.Login.WrongPassword}";
    public final String SECURITY_RE_LOGIN_MALFORMED_JWT_SCHEME = "{Security.ReLogin.MalformedJwtScheme}";
    public final String SECURITY_RE_LOGIN_MALFORMED_JWT_USERNAME = "{Security.ReLogin.MalformedJwtUsername}";
    public final String SECURITY_RE_LOGIN_MALFORMED_JWT_EXPIRATION_DATE = "{Security.ReLogin.MalformedJwtExpirationDate}";
    public final String SECURITY_RE_LOGIN_MALFORMED_JWT_USERNAME_NOT_FOUND = "{Security.ReLogin.MalformedJwtUsernameNotFound}";
    public final String SECURITY_RE_LOGIN_JWT_EXPIRED = "{Security.ReLogin.JwtExpired}";

    public final String VALIDATION_DEFAULT_MAX_COLLECTION_SIZE = "{Validation.Custom.Default.MaxCollectionSize}";
    public final String VALIDATION_DEFAULT_REFERENCE = "{Validation.CustomValidation.Default.Reference}";
    public final String VALIDATION_DEFAULT_TCKN = "{Validation.CustomValidation.Default.TCKN}";
    public final String VALIDATION_DEFAULT_UNIQUE = "{Validation.CustomValidation.Default.Unique}";
    public final String VALIDATION_DEFAULT_UUID = "{Validation.CustomValidation.Default.UUID}";
    public final String VALIDATION_DEFAULT_SCHEDULE_CONFLICT_CHECK = "{Validation.CustomValidation.Default.ScheduleConflictCheck}";
    public final String VALIDATION_DEFAULT_MEAL_START_END_CONFLICT_CHECK = "{Validation.CustomValidation.Default.MealStartEndConflictCheck}";

    public final String VALIDATION_LANGUAGE_ID_NOT_NULL = "{Validation.Language.Id.NotNull}";
    public final String VALIDATION_LANGUAGE_NAME_NOT_NULL = "{Validation.Language.Name.NotNull}";
    public final String VALIDATION_LANGUAGE_NAME_SIZE = "{Validation.Language.Name.Size}";
    public final String VALIDATION_LANGUAGE_LOCAL_NAME_NOT_NULL = "{Validation.Language.LocalName.NotNull}";
    public final String VALIDATION_LANGUAGE_LOCAL_NAME_SIZE = "{Validation.Language.LocalName.Size}";
    public final String VALIDATION_LANGUAGE_ALPHA_2_NOT_NULL = "{Validation.Language.Alpha2.NotNull}";
    public final String VALIDATION_LANGUAGE_ALPHA_2_PATTERN = "{Validation.Language.Alpha2.Pattern}";
    public final String VALIDATION_LANGUAGE_ALPHA_3_T_NOT_NULL = "{Validation.Language.Alpha3T.NotNull}";
    public final String VALIDATION_LANGUAGE_ALPHA_3_T_PATTERN = "{Validation.Language.Alpha3T.Pattern}";

    public final String VALIDATION_PAGE_REQUEST_PAGE_NO_MIN = "{Validation.PageRequest.PageNo.Min}";
    public final String VALIDATION_PAGE_REQUEST_PAGE_SIZE_MIN = "{Validation.PageRequest.PageSize.Min}";
    public final String VALIDATION_PAGE_REQUEST_PAGE_SIZE_MAX = "{Validation.PageRequest.PageSize.Max}";
    public final String VALIDATION_SORT_ORDERS_MAX_COLLECTION_SIZE = "{Validation.Sort.Orders.MaxCollectionSize}";
    public final String VALIDATION_ORDER_PROPERTY_NOT_BLANK = "{Validation.Order.Property.NotEmpty}";

    public final String VALIDATION_USER_ID_NOT_NULL = "{Validation.User.Id.NotNull}";
    public final String VALIDATION_USER_EMAIL_NOT_EMPTY = "{Validation.User.Email.NotNull}";
    public final String VALIDATION_USER_EMAIL_PATTERN = "{Validation.User.Email.Pattern}";
    public final String VALIDATION_USER_PASSWORD_NOT_NULL = "{Validation.User.Password.NotNull}";
    public final String VALIDATION_USER_PASSWORD_NOT_EMPTY = "{Validation.User.Password.NotEmpty}";
    public final String VALIDATION_USER_PASSWORD_SIZE = "{Validation.User.Password.Size}";
    public final String VALIDATION_USER_PHONE_NUMBER_NOT_NULL = "{Validation.User.PhoneNumber.NotNull}";
    public final String VALIDATION_USER_PHONE_NUMBER_PATTERN = "{Validation.User.PhoneNumber.Pattern}";
    public final String VALIDATION_USER_LANGUAGE_ID_NOT_NULL = "{Validation.User.LanguageId.NotNull}";
    public final String VALIDATION_USER_FIRST_NAME_NOT_NULL = "{Validation.User.FirstName.NotNull}";
    public final String VALIDATION_USER_FIRST_NAME_SIZE = "{Validation.User.FirstName.Size}";
    public final String VALIDATION_USER_LAST_NAME_NOT_NULL = "{Validation.User.LastName.NotNull}";
    public final String VALIDATION_USER_LAST_NAME_SIZE = "{Validation.User.LastName.Size}";
    public final String VALIDATION_USER_BIRTH_DATE_NOT_NULL = "{Validation.User.BirthDate.NotNull}";
    public final String VALIDATION_USER_BIRTH_DATE_PAST = "{Validation.User.BirthDate.Past}";

    public final String VALIDATION_CATERING_DATE_NOT_NULL = "{Validation.Catering.Date.NotNull}";
    public final String VALIDATION_CATERING_DATE_FUTURE = "{Validation.Catering.Date.Future}";
    public final String VALIDATION_CATERING_PRICE_MIN = "{Validation.Catering.Price.Min}";
    public final String VALIDATION_CATERING_MEAL_ID_NOT_NULL = "{Validation.Catering.MealId.NotNull}";
    public final String VALIDATION_CATERING_MENU_ITEM_IDS_MAX_COLLECTION_SIZE = "{Validation.Catering.MenuItemIds.MaxCollectionSize}";
    public final String VALIDATION_CATERING_MENU_ITEM_IDS_NOT_NULL = "{Validation.Catering.MenuItemIds.NotNull}";
    public final String VALIDATION_CATERING_MENU_ITEM_IDS_ELEMENT_NOT_NULL = "{Validation.Catering.MenuItemIdsElement.NotNull}";

    public final String VALIDATION_CUSTOMER_TYPE_NAME_NOT_NULL = "{Validation.CustomerType.Name.NotNull}";
    public final String VALIDATION_CUSTOMER_TYPE_NAME_SIZE = "{Validation.CustomerType.Name.Size}";
    public final String VALIDATION_CUSTOMER_TYPE_DESCRIPTION_NOT_NULL = "{Validation.CustomerType.Description.NotNull}";
    public final String VALIDATION_CUSTOMER_TYPE_DESCRIPTION_SIZE = "{Validation.CustomerType.Description.Size}";

    public final String VALIDATION_DINING_HALL_NAME_NOT_NULL = "{Validation.DiningHall.Name.NotNull}";
    public final String VALIDATION_DINING_HALL_NAME_SIZE = "{Validation.DiningHall.Name.Size}";
    public final String VALIDATION_DINING_HALL_DESCRIPTION_SIZE = "{Validation.DiningHall.Description.Size}";
    public final String VALIDATION_DINING_HALL_ADDRESS_SIZE = "{Validation.DiningHall.Address.Size}";
    public final String VALIDATION_DINING_HALL_LATITUDE_MIN = "{Validation.DiningHall.Latitude.Min}";
    public final String VALIDATION_DINING_HALL_LATITUDE_MAX = "{Validation.DiningHall.Latitude.Max}";
    public final String VALIDATION_DINING_HALL_LONGITUDE_MIN = "{Validation.DiningHall.Longitude.Min}";
    public final String VALIDATION_DINING_HALL_LONGITUDE_MAX = "{Validation.DiningHall.Longitude.Max}";
    public final String VALIDATION_DINING_HALL_CAPACITY_MIN = "{Validation.DiningHall.Capacity.Min}";

    public final String VALIDATION_MEAL_SCHEDULE_CONFLICT_CHECK = "{Validation.Meal.ScheduleConflictCheck}";
    public final String VALIDATION_MEAL_NAME_NOT_NULL = "{Validation.Meal.Name.NotNull}";
    public final String VALIDATION_MEAL_NAME_SIZE = "{Validation.Meal.Name.Size}";
    public final String VALIDATION_MEAL_START_NOT_NULL = "{Validation.Meal.Start.NotNull}";
    public final String VALIDATION_MEAL_END_NOT_NULL = "{Validation.Meal.End.NotNull}";

    public final String VALIDATION_MENU_ITEM_NAME_NOT_NULL = "{Validation.MenuItem.Name.NotNull}";
    public final String VALIDATION_MENU_ITEM_NAME_SIZE = "{Validation.MenuItem.Name.Size}";
    public final String VALIDATION_MENU_ITEM_CALORIES_MIN = "{Validation.MenuItem.Calories.Min}";


}