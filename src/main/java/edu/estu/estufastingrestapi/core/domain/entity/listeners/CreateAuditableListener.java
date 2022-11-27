package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.CreateAuditable;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class CreateAuditableListener {

    @PrePersist
    public void prePersist(CreateAuditable target) {
        target.setCreatedAt(LocalDateTime.now());
        target.setCreator(User.getCurrentPrincipal().map(UserDetails::getUsername).orElse("[ANONYMOUS]"));
    }

}
