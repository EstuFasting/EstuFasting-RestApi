package edu.estu.estufastingrestapi.service.model.response.feedback;

import edu.estu.estufastingrestapi.core.service.model.response.abstraction.AuditedResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackResponse extends AuditedResponse {

    private UUID id;

    private String fullName;

    private String email;

    private String topic;

    private String content;

    private Boolean reviewed;

    private String reviewer;

}
