package edu.estu.estufastingrestapi.entities.listeners;

import edu.estu.estufastingrestapi.entities.concretes.Feedback;

import javax.persistence.PrePersist;

public class FeedbackListener {

    @PrePersist
    public void prePersist(Feedback target) {
        target.setReviewed(false);
        target.setReviewer(null);
    }

}
