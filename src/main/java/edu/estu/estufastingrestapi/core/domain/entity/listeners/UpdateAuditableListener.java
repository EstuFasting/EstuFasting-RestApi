package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.UpdateAuditable;
import edu.estu.estufastingrestapi.core.domain.helper.SecurityStaticHelper;

import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class UpdateAuditableListener {

    @PreUpdate
    public void preUpdate(UpdateAuditable target) {
        target.setModifiedAt(LocalDateTime.now());
        target.setModifier(SecurityStaticHelper.getUsername().orElse("[ANONYMOUS]"));
    }

}
