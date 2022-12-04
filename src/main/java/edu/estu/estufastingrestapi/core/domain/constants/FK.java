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

    public final String CATERING_MEAL = "fk_catering_meal";
    public final String MENU_MENU_ITEM = "fk_menu_menu_item";
    public final String MENU_CATERING = "fk_menu_catering";
    public final String CUSTOMER_USER = "fk_customer_user";
    public final String CUSTOMER_CUSTOMER_TYPE = "fk_customer_customer_type";
    public final String RESERVATION_SERVICE = "fk_reservation_service";
    public final String RESERVATION_CUSTOMER = "fk_reservation_customer";
    public final String DINING_HALL_MEAL_MEAL = "fk_dining_hall_meal_meal";
    public final String DINING_HALL_MEAL_DINING_HALL = "fk_dining_hall_meal_dining_hall";
    public final String STAFF_USER = "fk_staff_user";
}
