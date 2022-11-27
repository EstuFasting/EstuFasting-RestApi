package edu.estu.estufastingrestapi.model.entities;

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
@Table(name = "tb_system_employee")
@PrimaryKeyJoinColumn(name = "id_user", referencedColumnName = "id_user", foreignKey = @ForeignKey(name = "fk_system_employee_user"))
@OnDelete(action = OnDeleteAction.CASCADE)
public class SystemEmployee extends User {
}
