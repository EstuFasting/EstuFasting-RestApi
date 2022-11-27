package edu.estu.estufastingrestapi.core.domain.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FK {
    public final String USER_PASSWORD_USER = "fk_user_password_user";
    public final String ROLE_PRIVILEGE_ROLE = "fk_role_privilege_role";
    public final String ROLE_PRIVILEGE_PRIVILEGE = "fk_role_privilege_privilege";
    public final String SUPER_ADMIN_USER = "fk_super_admin_user";
    public final String USER_COUNTRY = "fk_user_country";
    public final String USER_LANGUAGE = "fk_user_language";
    public final String USER_ROLE_USER = "fk_user_role_user";
    public final String USER_ROLE_ROLE = "fk_user_role_role";
}
