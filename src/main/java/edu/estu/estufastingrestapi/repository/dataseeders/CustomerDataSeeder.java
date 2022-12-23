package edu.estu.estufastingrestapi.repository.dataseeders;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.Language;
import edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts.BaseDataSeeder;
import edu.estu.estufastingrestapi.entities.concretes.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

// will be removed on prod
@Component
@RequiredArgsConstructor
public class CustomerDataSeeder extends BaseDataSeeder<Customer, UUID> {

    @Override
    public int getOrder() {
        return 20000;
    }

    @Override
    public void setData() {
        Customer user = new Customer();
        user.setUsername("smh01.2019@gmail.co");
        user.setPhoneNumber("+90-500-500-50-51");
        user.setBirthDate(LocalDate.now());
        user.setFirstName("Semih");
        user.setLastName("Kayan");
        user.setPassword("$2a$12$ed4t6xhT2/9kQ6rM1YZ5uuNCbsKP55O8PGZ94hTD0nojJbh/GYELa");
        user.setLanguage(Identifiable.getInstance(Language::new, 59));
        user.setTckn("11111111111");
        data.add(user);
    }

}
