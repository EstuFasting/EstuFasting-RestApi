package edu.estu.estufastingrestapi.core.repository.dataseeders;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts.DataSeeder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Slf4j
@Component
@RequiredArgsConstructor
public class AllDataSeedersInitiator {

    private final Collection<DataSeeder<?, ?>> dataSeeders;

    @LogExecutionTime
    @EventListener(classes = ContextRefreshedEvent.class)
    @Transactional
    public void initiate() {
        DataSeeder.seedAll(dataSeeders);
    }

}
