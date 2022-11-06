package edu.estu.estufastingrestapi.core.model.entities.concretes;

import edu.estu.estufastingrestapi.core.model.constants.Validation;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_role", uniqueConstraints = @UniqueConstraint(columnNames = "uq_name", name = "uk_role_name"))
@SQLDelete(sql = "UPDATE tb_role SET is_deleted = '1' WHERE id_role=?")
public class Role extends BaseEntity<Integer> {

    @Id
    @Column(name = "id_role", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uq_name", nullable = false, length = Validation.Role.MAX_LEN_NAME)
    private String name;

    @Column(name = "uq_description", nullable = false, length = Validation.Role.MAX_LEN_DESC)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_role_privilege",
            joinColumns = @JoinColumn(name = "rf_role", nullable = false), foreignKey = @ForeignKey(name = "fk_role_privilege_role"),
            inverseJoinColumns = @JoinColumn(name = "rf_privilege", nullable = false), inverseForeignKey = @ForeignKey(name = "fk_role_privilege_privilege"),
            uniqueConstraints = @UniqueConstraint(name = "uk_role_privilege_role_privilege", columnNames = {"rf_role", "rf_privilege"})
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Collection<Privilege> privileges;


}

