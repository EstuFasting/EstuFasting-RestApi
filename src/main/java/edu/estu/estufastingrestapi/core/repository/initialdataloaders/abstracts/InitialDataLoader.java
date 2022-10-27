package edu.estu.estufastingrestapi.core.repository.initialdataloaders.abstracts;

import edu.estu.estufastingrestapi.core.model.entities.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public interface InitialDataLoader<T extends Identifiable<ID>, ID> {

    default int getOrder() {
        return Integer.MAX_VALUE;
    }

    /**
     * @return JPA Repository which related to given entity type
     * @implSpec Be aware that the type T should have a proper JPA repository
     */
    JpaRepositoryAdapter<T, ID> getRepository();

    /**
     * @return The data to be load
     */
    Collection<T> getData();

    /**
     * @return Is load(Collection<T> data) method called
     */
    boolean isLoaded();

    void setLoaded(boolean loaded);

    default boolean loadCondition() {
        return !isLoaded() && getRepository().count() == 0L;
    }

    /**
     * Used to save the data from getData() method via the JPA repository returned from getRepository() method
     */
    @Transactional
    default void load() {
        if (!loadCondition()) return;

        Collection<T> data = getData();
        if (data == null) return;
        getRepository().saveAll(data);
        setLoaded(true);
        data.clear();

    }

    /**
     * Order by getOrder() method and call load method for all loaders
     */
    static void loadAll(Collection<InitialDataLoader<?, ?>> initialDataLoaders) {
        initialDataLoaders.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(InitialDataLoader::getOrder))
                .forEach(InitialDataLoader::load);
    }

}
