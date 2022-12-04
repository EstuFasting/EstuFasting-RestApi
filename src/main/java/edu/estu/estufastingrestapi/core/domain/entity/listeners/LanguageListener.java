package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Language;

import javax.persistence.PrePersist;

public class LanguageListener {

    @PrePersist
    public void prePersist(Language target) {
        target.setAlpha2(target.getAlpha2().toUpperCase());
        target.setAlpha3T(target.getAlpha3T().toUpperCase());
        target.setSupported(false);
    }

}
