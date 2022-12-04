package edu.estu.estufastingrestapi.entities.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.FK;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "tb_staff")
@PrimaryKeyJoinColumn(name = "id_user", referencedColumnName = "id_user", foreignKey = @ForeignKey(name = FK.STAFF_USER))
@OnDelete(action = OnDeleteAction.CASCADE)
public class Staff extends User {
}
