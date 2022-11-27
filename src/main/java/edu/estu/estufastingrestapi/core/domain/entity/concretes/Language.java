package edu.estu.estufastingrestapi.core.domain.entity.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.UK;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "tb_language",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "uq_name", name = UK.LANGUAGE_NAME),
                @UniqueConstraint(columnNames = "uq_local_name", name = UK.LANGUAGE_LOCAL_NAME),
                @UniqueConstraint(columnNames = "uq_alpha_2", name = UK.LANGUAGE_ALPHA_2),
                @UniqueConstraint(columnNames = "uq_alpha_3T", name = UK.LANGUAGE_ALPHA_3T)
        }
)
public class Language extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_language", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "uq_name", nullable = false, length = Validation.Language.MAX_LEN_NAME)
    private String name;

    @Column(name = "uq_local_name", nullable = false, length = Validation.Language.MAX_LEN_LOCAL_NAME)
    private String localName;

    /**
     * ISO 639_1
     **/
    @Column(name = "uq_alpha_2", nullable = false, length = Validation.Language.MAX_LEN_ALPHA2)
    private String alpha2;

    /**
     * ISO 639_2/T | "B": Bibliographic & "T": Terminology
     **/
    @Column(name = "uq_alpha_3T", nullable = false, length = Validation.Language.MAX_LEN_ALPHA3T)
    private String alpha3T;

    @Column(name = "is_unlisted", nullable = false)
    private boolean unlisted;

    @Column(name = "is_supported", nullable = false)
    private boolean supported;

}
