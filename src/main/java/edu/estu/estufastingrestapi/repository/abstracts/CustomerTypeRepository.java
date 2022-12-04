package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.entities.concretes.CustomerType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends JpaRepositoryAdapter<CustomerType, Integer> {

    @Modifying
    @Query("update CustomerType ct set ct.name = :name where ct.id = :id")
    int updateName(Integer id, String name);

    @Modifying
    @Query("update CustomerType ct set ct.description = :desc where ct.id = :id")
    int updateDesc(Integer id, String desc);

}
