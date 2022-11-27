package edu.estu.estufastingrestapi.core.domain.entity.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.FK;
import edu.estu.estufastingrestapi.core.domain.constants.UK;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_role", uniqueConstraints = @UniqueConstraint(columnNames = "uq_name", name = UK.ROLE_NAME))
public class Role extends BaseEntity<Integer> {

    @Id
    @Column(name = "id_role", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uq_name", nullable = false, length = Validation.Role.MAX_LEN_NAME)
    private String name;

    @Column(name = "uq_description", nullable = false, length = Validation.Role.MAX_LEN_DESC)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_role_privilege",
            joinColumns = @JoinColumn(name = "rf_role", nullable = false), foreignKey = @ForeignKey(name = FK.ROLE_PRIVILEGE_ROLE),
            inverseJoinColumns = @JoinColumn(name = "rf_privilege", nullable = false), inverseForeignKey = @ForeignKey(name = FK.ROLE_PRIVILEGE_PRIVILEGE),
            uniqueConstraints = @UniqueConstraint(name = UK.ROLE_PRIVILEGE_ROLE_PRIVILEGE, columnNames = {"rf_role", "rf_privilege"})
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Collection<Privilege> privileges;


}

