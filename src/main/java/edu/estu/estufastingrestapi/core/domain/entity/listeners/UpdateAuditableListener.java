package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.UpdateAuditable;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import edu.estu.estufastingrestapi.core.domain.helper.PrincipalHelper;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class UpdateAuditableListener {

    @PreUpdate
    public void preUpdate(UpdateAuditable target) {
        target.setModifiedAt(LocalDateTime.now());
        target.setModifier(PrincipalHelper.getCurrentUsername().orElse("[ANONYMOUS]"));
    }

}
