package sk6.my.templateproject.core.model.response.helper;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public class MessageHelper {
    public static String getViolationMsg(String camelCaseProp, String rawMsg) {
        return String.format(rawMsg, camelCaseToHumanReadable(camelCaseProp));
    }

    public static String camelCaseToHumanReadable(String camelCase) {
        String[] strings = StringUtils.splitByCharacterTypeCamelCase(camelCase);
        String subPropName = StringUtils.join(strings, " ").toLowerCase(Locale.getDefault());
        return String.format("%s%s", Character.toUpperCase(subPropName.charAt(0)), subPropName.substring(1));
    }
}
