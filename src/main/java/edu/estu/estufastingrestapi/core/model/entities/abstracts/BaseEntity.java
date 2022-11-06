package edu.estu.estufastingrestapi.core.model.entities.abstracts;

import edu.estu.estufastingrestapi.core.model.constants.FilterName;
import edu.estu.estufastingrestapi.core.model.constants.Validation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
@FilterDef(name = FilterName.IS_DELETED, parameters = @ParamDef(name = "deleted", type = "char"))
@Filter(name = FilterName.IS_DELETED, condition = "is_deleted = :deleted")
public abstract class BaseEntity<ID> implements Entity, Identifiable<ID>, CreateAuditable, UpdateAuditable, SoftDeletable {

    @Column(name = "dt_created", nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @Column(name = "dt_modified", insertable = false)
    protected LocalDateTime modifiedAt;

    @Column(name = "tx_creator", nullable = false, updatable = false, length = Validation.User.MAX_LEN_USERNAME)
    protected String creator;

    @Column(name = "tx_modifier", insertable = false, length = Validation.User.MAX_LEN_USERNAME)
    protected String modifier;

    @ColumnDefault("'0'")
    @Column(name = "is_deleted", insertable = false, nullable = false)
    protected Character deleted;

    @PrePersist
    public void prePersist() {

        this.createdAt = LocalDateTime.now();
        this.creator = "[ANONYMOUS]";
    }

    @PreUpdate
    public void preUpdate() {

        this.modifiedAt = LocalDateTime.now();
        this.modifier = "[ANONYMOUS]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BaseEntity<?> baseEntity = (BaseEntity<?>) o;
        return getId() != null && Objects.equals(getId(), baseEntity.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
