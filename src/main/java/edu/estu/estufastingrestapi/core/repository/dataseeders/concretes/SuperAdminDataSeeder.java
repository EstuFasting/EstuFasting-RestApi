package edu.estu.estufastingrestapi.core.repository.dataseeders.concretes;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.Language;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.Role;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.SuperAdmin;
import edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts.BaseDataSeeder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SuperAdminDataSeeder extends BaseDataSeeder<SuperAdmin, UUID> {

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
        user.setLanguage(Identifiable.getInstance(Language::new, 59));
        user.setRoles(Set.of(Identifiable.getInstance(Role::new, 1)));
        data.add(user);
    }

}
