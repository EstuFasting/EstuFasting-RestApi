package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Language;

import javax.persistence.PrePersist;

public class LanguageListener {

    @PrePersist
    public void prePersist(Language target) {
        target.setSupported(false);
    }

}
