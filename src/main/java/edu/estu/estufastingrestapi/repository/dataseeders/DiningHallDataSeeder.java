package edu.estu.estufastingrestapi.repository.dataseeders;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts.BaseDataSeeder;
import edu.estu.estufastingrestapi.entities.concretes.DiningHall;
import edu.estu.estufastingrestapi.entities.concretes.Meal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DiningHallDataSeeder extends BaseDataSeeder<DiningHall, Integer> {

    @Override
    public int getOrder() {
        return 20;
    }

    @Override
    public void setData() {
        Set<Meal> meals1 = Set.of(
                Identifiable.getInstance(Meal::new, 2),
                Identifiable.getInstance(Meal::new, 3)
        );

        Set<Meal> meals2 = Set.of(
                Identifiable.getInstance(Meal::new, 2),
                Identifiable.getInstance(Meal::new, 3)
        );

        Set<Meal> meals3 = Set.of(
                Identifiable.getInstance(Meal::new, 2)
        );

        data.add(new DiningHall(null, "PORSUK", "Porsuk Dining Hall", "Osmangazi, Basın Şehitleri Cd. No:152, 26140 Odunpazarı/Eskişehir", 39.773052669320144, 30.49021565614657, null, meals1));
        data.add(new DiningHall(null, "2_EYLUL_STUDENT", "2 Eylül Student Dining Hall", "Gazipaşa, 26555 Tepebaşı/Eskişehir", 39.81411612778955, 30.5322032374967, null, meals2));
        data.add(new DiningHall(null, "2_EYLUL_PERSONNEL", "2 Eylül Personnel Dining Hall", "Gazipaşa, 26555 Tepebaşı/Eskişehir", 39.81411612778955, 30.5322032374967, null, meals3));
    }

}
