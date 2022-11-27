package edu.estu.estufastingrestapi.core.domain.helper;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {

    @Getter
    private static MessageSource messageSource;

    @Autowired
    public synchronized void setMessageSource(MessageSource messageSource) {
        if (MessageHelper.messageSource == null)
            MessageHelper.messageSource = messageSource;
    }

}
