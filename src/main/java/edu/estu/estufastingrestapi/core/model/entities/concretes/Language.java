package edu.estu.estufastingrestapi.core.model.entities.concretes;

import edu.estu.estufastingrestapi.core.model.constants.Validation;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "tb_language",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "uq_name", name = "uk_language_name"),
                @UniqueConstraint(columnNames = "uq_local_name", name = "uk_language_local_name"),
                @UniqueConstraint(columnNames = "uq_alpha_2", name = "uk_language_alpha_2"),
                @UniqueConstraint(columnNames = "uq_alpha_3", name = "uk_language_alpha_3")
        }
)
@SQLDelete(sql = "UPDATE tb_language SET is_deleted = '1' WHERE id_language=?")
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
    @Column(name = "uq_alpha_3", nullable = false, length = Validation.Language.MAX_LEN_ALPHA3T)
    private String alpha3T;

    @Column(name = "is_unlisted", nullable = false)
    private Boolean unlisted;

    @Column(name = "is_supported", nullable = false)
    private Boolean supported;

}
