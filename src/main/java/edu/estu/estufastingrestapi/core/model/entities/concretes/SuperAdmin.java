package edu.estu.estufastingrestapi.core.model.entities.concretes;

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
@Table(name = "tb_super_admin")
@PrimaryKeyJoinColumn(name = "id_user", referencedColumnName = "id_user", foreignKey = @ForeignKey(name = "fk_super_admin_user"))
@OnDelete(action = OnDeleteAction.CASCADE)
public class SuperAdmin extends User {
}
