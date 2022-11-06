package edu.estu.estufastingrestapi.core.repository.initialdataloaders.concretes;

import edu.estu.estufastingrestapi.core.model.entities.concretes.SuperAdmin;
import edu.estu.estufastingrestapi.core.repository.abstracts.LanguageRepository;
import edu.estu.estufastingrestapi.core.repository.abstracts.RoleRepository;
import edu.estu.estufastingrestapi.core.repository.initialdataloaders.abstracts.BaseDataSeeder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SuperAdminDataSeeder extends BaseDataSeeder<SuperAdmin, UUID> {

    private final LanguageRepository languageRepository;
    private final RoleRepository roleRepository;

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public void setData() {
        SuperAdmin user = new SuperAdmin();
        user.setUsername("smh01.2019@gmail.com");
        user.setEmail("smh01.2019@gmail.com");
        user.setPhoneNumber("+90-500-500-50-50");
        user.setBirthDate(LocalDate.now());
        user.setFirstName("Semih");
        user.setLastName("Kayan");
        user.setPassword("$2a$12$Hwa2Wxdy31TF77F8J.OQf.qX490O6z2C7B9zMpV3csvAyDrZnEory");
        user.setLanguage(languageRepository.findFirstByAlpha2("TR").orElseThrow(EntityNotFoundException::new));
        user.setRoles(List.of(roleRepository.findFirstByName("ROLE_SUPER_ADMIN").orElseThrow(EntityNotFoundException::new)));
        data.add(user);
    }

}
