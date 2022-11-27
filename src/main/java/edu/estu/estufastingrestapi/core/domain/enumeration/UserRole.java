package edu.estu.estufastingrestapi.core.domain.enumeration;

public enum UserRole {

    ROLE_SUPER_ADMIN(1),
    ROLE_SYSTEM_EMPLOYEE(2),
    ROLE_USER(3),
    ;

    final int id;

    UserRole(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

}
