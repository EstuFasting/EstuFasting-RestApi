package edu.estu.estufastingrestapi.service.model.response.feedback;

import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;

import java.util.UUID;

public interface FeedbackQuickProjection extends IdentifiableModel<UUID> {

    String getFullName();

    String getEmail();

    String getTopic();

    String getContent();

    Boolean getReviewed();

    String getReviewer();

}
