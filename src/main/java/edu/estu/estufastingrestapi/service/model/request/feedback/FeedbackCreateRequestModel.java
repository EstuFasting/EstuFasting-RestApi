package edu.estu.estufastingrestapi.service.model.request.feedback;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackCreateRequestModel implements RequestModel {

    @Size(min = Validation.Feedback.MIN_LEN_FULL_NAME, max = Validation.Feedback.MAX_LEN_FULL_NAME, message = MsgCode.VALIDATION_FEEDBACK_FULL_NAME_SIZE)
    private String fullName;

    @Pattern(regexp = Validation.User.RGX_EMAIL, message = MsgCode.VALIDATION_USER_EMAIL_PATTERN)
    private String email;

    @NotNull(message = MsgCode.VALIDATION_FEEDBACK_TOPIC_NOT_NULL)
    @Size(min = Validation.Feedback.MIN_LEN_TOPIC, max = Validation.Feedback.MAX_LEN_TOPIC, message = MsgCode.VALIDATION_FEEDBACK_TOPIC_SIZE)
    private String topic;

    @NotNull(message = MsgCode.VALIDATION_FEEDBACK_CONTENT_NOT_NULL)
    @Size(min = Validation.Feedback.MIN_LEN_CONTENT, max = Validation.Feedback.MAX_LEN_CONTENT, message = MsgCode.VALIDATION_FEEDBACK_CONTENT_SIZE)
    private String content;

}
