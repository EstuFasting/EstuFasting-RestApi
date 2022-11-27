package edu.estu.estufastingrestapi.core.domain.response.abstraction;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.domain.helper.MessageHelper;
import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDateTime;

@Getter
public abstract class ApiResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;
    private final String message;

    private static final String MESSAGE_SOURCE_NULL = "Message code is null, please consider to add a message to your response!";

    protected ApiResponse(String messageCode, Object[] args) {
        if (messageCode == null)
            throw new IllegalArgumentException(MESSAGE_SOURCE_NULL);
        if (messageCode.charAt(0) == '{' && messageCode.charAt(messageCode.length() - 1) == '}')
            messageCode = messageCode.substring(1, messageCode.length() - 1);
        this.message = MessageHelper.getMessageSource().getMessage(messageCode, args, LocaleContextHolder.getLocale());
        this.timestamp = LocalDateTime.now();
    }

    protected ApiResponse(String messageCode) {
        this(messageCode, null);
    }

}
