package edu.estu.estufastingrestapi.core.repository.initialdataloaders;

import edu.estu.estufastingrestapi.core.repository.initialdataloaders.abstracts.DataSeeder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class AllDataSeedersInitiator {

    private final Collection<DataSeeder<?, ?>> dataSeeders;

    @EventListener(classes = ContextRefreshedEvent.class)
    public void initiate() {
        DataSeeder.seedAll(dataSeeders);
    }

}
