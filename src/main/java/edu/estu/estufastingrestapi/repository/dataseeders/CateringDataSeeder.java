package edu.estu.estufastingrestapi.repository.dataseeders;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts.BaseDataSeeder;
import edu.estu.estufastingrestapi.entities.concretes.Catering;
import edu.estu.estufastingrestapi.entities.concretes.Meal;
import edu.estu.estufastingrestapi.entities.concretes.MenuItem;
import edu.estu.estufastingrestapi.repository.abstracts.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

// will be removed on prod
@Component
@RequiredArgsConstructor
public class CateringDataSeeder extends BaseDataSeeder<Catering, UUID> {

    private final MenuItemRepository menuItemRepository;

    @Override
    public int getOrder() {
        return 50;
    }

    @Override
    public void setData() {
        List<MenuItem> menuItems = menuItemRepository.findAll(Pageable.ofSize(4)).getContent();
        LocalDate now = LocalDate.now();
        for (int i = 0; i < 20; i++) {
            if (now.plusDays(i).getDayOfWeek() == DayOfWeek.SATURDAY || now.plusDays(i).getDayOfWeek() == DayOfWeek.SUNDAY)
                continue;
            data.add(new Catering(null, now.plusDays(i), Identifiable.getInstance(Meal::new, 2), null, Set.copyOf(menuItems), null));
            data.add(new Catering(null, now.plusDays(i), Identifiable.getInstance(Meal::new, 3), null, Set.copyOf(menuItems), null));
        }
    }

}
