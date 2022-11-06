package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.model.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepositoryAdapter<Language, Integer> {

    Optional<Language> findFirstByName(String englishName);

    Optional<Language> findFirstByLocalName(String localName);

    Optional<Language> findFirstByAlpha2(String alpha2);

    Optional<Language> findFirstByAlpha3T(String alpha3T);

}
