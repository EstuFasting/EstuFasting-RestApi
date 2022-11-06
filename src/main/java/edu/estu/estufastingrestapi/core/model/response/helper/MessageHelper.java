package edu.estu.estufastingrestapi.core.model.response.helper;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

@UtilityClass
public class MessageHelper {

    public String getViolationMsg(String camelCaseProp, String rawMsg) {
        return String.format(rawMsg, camelCaseToHumanReadable(camelCaseProp));
    }

    public String camelCaseToHumanReadable(String camelCase) {
        String[] strings = StringUtils.splitByCharacterTypeCamelCase(camelCase);
        String subPropName = StringUtils.join(strings, " ").toLowerCase(Locale.getDefault());
        return String.format("%s%s", Character.toUpperCase(subPropName.charAt(0)), subPropName.substring(1));
    }
}
