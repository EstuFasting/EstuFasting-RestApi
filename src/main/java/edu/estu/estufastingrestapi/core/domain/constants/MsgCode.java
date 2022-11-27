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
    public final String COMMON_ERROR_INVALID = "{Common.Error.Invalid}";

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
    public final String VALIDATION_ORDER_PROPERTY_NOT_BLANK = "{Validation.Order.Property.NotBlank}";

    public final String VALIDATION_USER_ID_NOT_NULL = "{Validation.User.Id.NotNull}";
    public final String VALIDATION_USER_USER_NAME_NOT_NULL = "{Validation.User.UserName.NotNull}";
    public final String VALIDATION_USER_USER_NAME_NOT_BLANK = "{Validation.User.UserName.NotBlank}";
    public final String VALIDATION_USER_USER_NAME_SIZE = "{Validation.User.UserName.Size}";
    public final String VALIDATION_USER_EMAIL_NOT_NULL = "{Validation.User.Email.NotNull}";
    public final String VALIDATION_USER_EMAIL_PATTERN = "{Validation.User.Email.Pattern}";
    public final String VALIDATION_USER_PASSWORD_NOT_NULL = "{Validation.User.Password.NotNull}";
    public final String VALIDATION_USER_PASSWORD_NOT_BLANK = "{Validation.User.Password.NotBlank}";
    public final String VALIDATION_USER_PASSWORD_SIZE = "{Validation.User.Password.Size}";
    public final String VALIDATION_USER_PHONE_NUMBER_NOT_NULL = "{Validation.User.PhoneNumber.NotNull}";
    public final String VALIDATION_USER_PHONE_NUMBER_PATTERN = "{Validation.User.PhoneNumber.Pattern}";
    public final String VALIDATION_USER_COUNTRY_ID_NOT_NULL = "{Validation.User.CountryId.NotNull}";
    public final String VALIDATION_USER_LANGUAGE_ID_NOT_NULL = "{Validation.User.LanguageId.NotNull}";
    public final String VALIDATION_USER_FIRST_NAME_NOT_NULL = "{Validation.User.FirstName.NotNull}";
    public final String VALIDATION_USER_FIRST_NAME_SIZE = "{Validation.User.FirstName.Size}";
    public final String VALIDATION_USER_LAST_NAME_NOT_NULL = "{Validation.User.LastName.NotNull}";
    public final String VALIDATION_USER_LAST_NAME_SIZE = "{Validation.User.LastName.Size}";
    public final String VALIDATION_USER_BIRTH_DATE_NOT_NULL = "{Validation.User.BirthDate.NotNull}";
    public final String VALIDATION_USER_BIRTH_DATE_PAST = "{Validation.User.BirthDate.Past}";

}