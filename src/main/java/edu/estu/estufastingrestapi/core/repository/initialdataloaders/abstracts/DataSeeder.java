package edu.estu.estufastingrestapi.core.repository.initialdataloaders.abstracts;

import edu.estu.estufastingrestapi.core.model.entities.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

/**
 * Dependent to JPA Repository
 */
public interface DataSeeder<T extends Identifiable<ID>, ID> {

    /**
     * Order by getOrder() method and call seed() method for all seeders
     */
    static void seedAll(Collection<DataSeeder<?, ?>> dataSeeders) {
        dataSeeders.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(DataSeeder::getOrder))
                .forEach(DataSeeder::seed);
    }

    default int getOrder() {
        return Integer.MAX_VALUE;
    }

    /**
     * @return JPA Repository which related to given entity type
     * @implSpec Be aware that the type T should have a proper JPA repository
     */
    JpaRepositoryAdapter<T, ID> getRepository();

    /**
     * @return The data to be seed
     */
    Collection<T> getData();

    /**
     * Sets data to be seed
     */
    void setData();

    default boolean seedCondition() {
        return !isSeeded() && getRepository().count() == 0L;
    }

    /**
     * @return If is seed() method called
     */
    boolean isSeeded();

    void setSeeded(boolean loaded);

    /**
     * Used to save the data from getData() method via the JPA repository returned from getRepository() method
     */
    @Transactional
    default void seed() {
        if (!seedCondition()) return;

        setData();
        Collection<T> data = getData();
        if (data == null) return;

        getRepository().saveAllAndFlush(data);

        setSeeded(true);
        data.clear();
    }

}
