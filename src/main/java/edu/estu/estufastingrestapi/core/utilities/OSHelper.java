package edu.estu.estufastingrestapi.core.utilities;

import lombok.experimental.UtilityClass;

@UtilityClass
public class OSHelper {

    public String getOSName() {
        return System.getProperty("os.name");
    }

}
