package edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import org.hibernate.Session;
import org.springframework.core.Ordered;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

/**
 * Dependent to JPA Repository
 */
public interface DataSeeder<T extends Identifiable<ID>, ID> extends Ordered {

    /**
     * Order by getOrder() method and call seed() method for all seeders
     */
    static void seedAll(Collection<DataSeeder<?, ?>> dataSeeders) {
        dataSeeders.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(DataSeeder::getOrder))
                .forEach(DataSeeder::seed);
        for (DataSeeder<?, ?> seeder : dataSeeders) seeder.getData().clear();
    }

    default int getOrder() {
        return LOWEST_PRECEDENCE;
    }

    /**
     * @return JPA Repository which related to given entity type
     * @implSpec Be aware that the type T should have a proper JPA repository
     */
    JpaRepositoryAdapter<T, ID> getRepository();

    EntityManager getEntityManager();

    /**
     * @return The data to be seed
     */
    Collection<T> getData();

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
    @LogExecutionTime
    default void seed() {
        if (!seedCondition()) return;

        setData();
        Collection<T> data = getData();
        if (data == null) return;

        getRepository().saveAllAndFlush(data);
        getEntityManager().unwrap(Session.class).clear();

        setSeeded(true);
    }

}
