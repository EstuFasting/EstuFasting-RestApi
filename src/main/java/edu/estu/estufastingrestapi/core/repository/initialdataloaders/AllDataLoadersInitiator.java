package edu.estu.estufastingrestapi.core.repository.initialdataloaders;

import edu.estu.estufastingrestapi.core.repository.initialdataloaders.abstracts.InitialDataLoader;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class AllDataLoadersInitiator {

    @Getter
    private final Collection<InitialDataLoader<?, ?>> initialDataLoaders;

    @EventListener(classes = ContextRefreshedEvent.class)
    public void initiate() {
        InitialDataLoader.loadAll(initialDataLoaders);
    }

}
