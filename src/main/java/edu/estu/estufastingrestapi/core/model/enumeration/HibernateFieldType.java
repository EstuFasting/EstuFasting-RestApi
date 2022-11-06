package edu.estu.estufastingrestapi.core.model.enumeration;

import org.hibernate.type.*;

public enum HibernateFieldType {
    STRING(StringType.INSTANCE),
    UUID_BINARY(UUIDBinaryType.INSTANCE),
    UUID_CHAR(UUIDCharType.INSTANCE),
    LOCAL_DATE(LocalDateType.INSTANCE),
    LOCAL_DATE_TIME(LocalDateTimeType.INSTANCE),
    LOCAL_TIME(LocalTimeType.INSTANCE),
    INTEGER(IntegerType.INSTANCE),
    ;
    final Type type;

    HibernateFieldType(Type type) {
        this.type = type;
    }

    public Type get() {
        return type;
    }
}
