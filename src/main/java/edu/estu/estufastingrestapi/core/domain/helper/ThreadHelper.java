package edu.estu.estufastingrestapi.core.domain.helper;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ThreadHelper {

    @SneakyThrows(InterruptedException.class)
    public void sleep(long millis) {
        Thread.sleep(millis);
    }

}
