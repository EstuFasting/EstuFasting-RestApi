package edu.estu.estufastingrestapi.core.model.response.helper;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

@UtilityClass
public class Msg {

    public final String HEADER_NOT_FOUND = "Authentication header is not found!";
    public final String INVALID_TOKEN = "Token is not valid!";

    public final String SUCCESS = "Successful";
    public final String SAVED = "Saved";
    public final String ERROR = "Error";
    public final String VALIDATION_ERROR = "Validation Error";
    public final String UNEXPECTED_ERROR = "Unexpected Error";

    public final String DELETED = "Deleted";
    public final String REMOVED = "Removed";
    public final String INVALID = "Invalid";
    public final String INVALID_LOGIN = "Invalid email or password.";
    public final String BAD_CREDENTIALS = "Bad credentials";
    public final String MALFORMED_JWT_SCHEME = "Malformed scheme";
    public final String MALFORMED_JWT_USERNAME = "Malformed username";
    public final String MALFORMED_JWT_EXPIRATION_DATE = "Malformed jwt expiration date";
    public final String MALFORMED_JWT_USERNAME_NOT_FOUND = "Username could be malformed, please login again.";
    public final String START_END_CONFLICT = "The end year cannot be a date before the start year";
    public final String MALFORMED_JSON_REQUEST = "Malformed JSON request";
    public final String JWT_EXPIRED = "Your session has expired, Please login again.";
    public final String PROPERTY_NAME_MISMATCH = "Property name mismatch";

    // subject required
    public final String REQUIRED = "%s required";
    public final String SIZE = "%s size must be between {min} and {max}";
    public final String MIN = "%s size must be greater than {value}";
    public final String MAX = "%s size must be smaller than {value}";
    public final String FUTURE = "%s should be in the future";
    public final String PAST = "%s should be in the past";
    public final String PATTERN = "%s is not in correct format";
    public final String IS_IN_USE = "%s is in use";
    public final String NOT_EXIST = "%s does not exist";

    public String getViolationMsg(String camelCaseProp, String rawMsg) {
        return String.format(rawMsg, camelCaseToHumanReadable(camelCaseProp));
    }

    public String camelCaseToHumanReadable(String camelCase) {
        String[] sliced = StringUtils.splitByCharacterTypeCamelCase(camelCase);
        String subPropName = StringUtils.join(sliced, " ").toLowerCase(Locale.ENGLISH);
        return String.format("%s%s", Character.toUpperCase(subPropName.charAt(0)), subPropName.substring(1));
    }

}
