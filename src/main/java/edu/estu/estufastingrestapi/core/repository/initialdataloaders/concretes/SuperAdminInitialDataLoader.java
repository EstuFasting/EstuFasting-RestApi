package edu.estu.estufastingrestapi.core.repository.initialdataloaders.concretes;

import edu.estu.estufastingrestapi.core.model.entities.concretes.SuperAdmin;
import edu.estu.estufastingrestapi.core.repository.abstracts.LanguageRepository;
import edu.estu.estufastingrestapi.core.repository.abstracts.RoleRepository;
import edu.estu.estufastingrestapi.core.repository.initialdataloaders.abstracts.BaseInitialDataLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SuperAdminInitialDataLoader extends BaseInitialDataLoader<SuperAdmin, UUID> {

    private final LanguageRepository languageRepository;
    private final RoleRepository roleRepository;

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public Collection<SuperAdmin> getData() {
        if (this.data != null) return this.data;
        Collection<SuperAdmin> data = new ArrayList<>();

        SuperAdmin superAdmin = new SuperAdmin();
        superAdmin.setUsername("example@gmail.com");
        superAdmin.setEmail("example@gmail.com");
        superAdmin.setPhoneNumber("+90-500-500-50-50");
        superAdmin.setBirthDate(LocalDate.now());
        superAdmin.setFirstName("First Name");
        superAdmin.setLastName("Last Name");
        superAdmin.setPassword("$2a$12$Hwa2Wxdy31TF77F8J.OQf.qX490O6z2C7B9zMpV3csvAyDrZnEory");
        superAdmin.setLanguage(languageRepository.findFirstByAlpha2("TR").orElseThrow(EntityNotFoundException::new));
        superAdmin.setRoles(List.of(roleRepository.findFirstByName("ROLE_SUPER_ADMIN").orElseThrow(EntityNotFoundException::new)));

        data.add(superAdmin);

        this.data = data;
        return this.data;
    }

}
