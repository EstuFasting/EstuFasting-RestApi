package edu.estu.estufastingrestapi.core.domain.entity.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.FK;
import edu.estu.estufastingrestapi.core.domain.entity.listeners.SuperAdminCreateListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "tb_super_admin")
@EntityListeners(SuperAdminCreateListener.class)
@PrimaryKeyJoinColumn(name = "id_user", referencedColumnName = "id_user", foreignKey = @ForeignKey(name = FK.SUPER_ADMIN_USER))
@OnDelete(action = OnDeleteAction.CASCADE)
public class SuperAdmin extends User {
}
