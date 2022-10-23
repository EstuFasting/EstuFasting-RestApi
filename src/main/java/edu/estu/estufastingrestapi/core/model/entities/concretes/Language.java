package edu.estu.estufastingrestapi.core.model.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.estu.estufastingrestapi.core.model.constants.validation.SizeOf;
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
                @UniqueConstraint(columnNames = "uq_english_name", name = "uk_english_name"),
                @UniqueConstraint(columnNames = "uq_local_name", name = "uk_local_name"),
                @UniqueConstraint(columnNames = "uq_alpha_2", name = "uk_alpha_2"),
                @UniqueConstraint(columnNames = "uq_alpha_3", name = "uk_alpha_3")
        }
)
@SQLDelete(sql = "UPDATE tb_language SET is_deleted = '1' WHERE id_language=?")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Language extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_language", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "uq_english_name", nullable = false, length = SizeOf.Text.Max.LANGUAGE_ENGLISH_NAME)
    private String englishName;

    @Column(name = "uq_local_name", nullable = false, length = SizeOf.Text.Max.LANGUAGE_LOCAL_NAME)
    private String localName;

    @Column(name = "uq_alpha_2", nullable = false, length = SizeOf.Text.Max.LANGUAGE_ALPHA2)
    private String alpha2; // iso639_1

    @Column(name = "uq_alpha_3", nullable = false, length = SizeOf.Text.Max.LANGUAGE_ALPHA3T)
    private String alpha3T; // iso639_2/T

    @Column(name = "is_unlisted", nullable = false)
    protected Boolean unlisted;

    @Column(name = "is_supported", nullable = false)
    protected Boolean supported;

}
