package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.Feedback;
import edu.estu.estufastingrestapi.service.model.response.feedback.FeedbackResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class FeedbackResponseMapStructMapper implements MapStructMapper<Feedback, FeedbackResponse> {
}
