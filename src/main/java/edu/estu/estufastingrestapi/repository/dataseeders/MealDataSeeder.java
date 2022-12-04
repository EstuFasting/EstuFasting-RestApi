package edu.estu.estufastingrestapi.repository.dataseeders;

import edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts.BaseDataSeeder;
import edu.estu.estufastingrestapi.entities.concretes.Meal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class MealDataSeeder extends BaseDataSeeder<Meal, Integer> {

    @Override
    public int getOrder() {
        return 10;
    }

    @Override
    public void setData() {
        data.add(new Meal(null, "Breakfast", LocalTime.of(7, 30), LocalTime.of(9, 0), null));
        data.add(new Meal(null, "Lunch", LocalTime.of(11, 30), LocalTime.of(2, 0), null));
        data.add(new Meal(null, "Dinner", LocalTime.of(15, 0), LocalTime.of(17, 30), null));
    }

}
