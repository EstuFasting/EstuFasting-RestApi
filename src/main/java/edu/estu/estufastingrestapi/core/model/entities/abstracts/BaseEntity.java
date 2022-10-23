package edu.estu.estufastingrestapi.core.model.entities.abstracts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.estu.estufastingrestapi.core.model.constants.hibernate.FilterName;
import edu.estu.estufastingrestapi.core.model.constants.validation.SizeOf;
import edu.estu.estufastingrestapi.core.model.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@FilterDef(name = FilterName.IsDeleted, parameters = @ParamDef(name = "deleted", type = "char"))
@Filter(name = FilterName.IsDeleted, condition = "is_deleted = :deleted")
public abstract class BaseEntity<ID> implements Entity, Persistable<ID>, CreateAuditable, UpdateAuditable, SoftDeletable {

    @JsonFormat(pattern = "yyyy-MM-dd hh:dd")
    @Column(name = "dt_created", nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd hh:dd")
    @Column(name = "dt_modified", insertable = false)
    protected LocalDateTime modifiedAt;

    @JsonIgnore
    @Column(name = "tx_creator", nullable = false, updatable = false, length = SizeOf.Text.Max.USERNAME)
    protected String creator;

    @JsonIgnore
    @Column(name = "tx_modifier", insertable = false, length = SizeOf.Text.Max.USERNAME)
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
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
