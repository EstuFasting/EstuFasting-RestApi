package edu.estu.estufastingrestapi.core.domain.constants;

import lombok.experimental.UtilityClass;

/**
 * @apiNote Abbreviations <br>
 * MIN: Minimum <br>
 * MAX: Maximum <br>
 * RGX: Regular Expression <br>
 * LEN: Length <br>
 * VAL: Value <br>
 * SIZE: Collection Size <br>
 */
@UtilityClass
public class Validation {

    @UtilityClass
    public class Customer {
        public static final int CUSTOMER_CARD_NO = Pow2.L63;
    }

    @UtilityClass
    public class CustomerType {
        public static final int CUSTOMER_TYPE_NAME = Pow2.L63;
        public static final int CUSTOMER_TYPE_DESC = Pow2.L511;
    }

    @UtilityClass
    public class DiningHall {
        public static final int DINING_HALL_NAME = Pow2.L63;
        public static final int DINING_HALL_ADDRESS_LINE = Pow2.L255;
    }

    @UtilityClass
    public class Meal {
        public static final int MEAL_NAME = Pow2.L63;
    }

    @UtilityClass
    public class Menu {
    }

    @UtilityClass
    public class MenuItem {
        public static final int MENU_ITEM_NAME = Pow2.L63;
    }

    @UtilityClass
    public class Reservation {
    }

    @UtilityClass
    public class Service {
    }

    @UtilityClass
    public class SystemEmployee {
    }

    @UtilityClass
    public class Common {
        public final int UUID = 16;

        public final String RGX_UUID = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$";
        public final String RGX_WEBSITE = "^(w{3}\\.)?[^.]+(\\.\\p{javaLowerCase}{2,12})+$";
        public final String RGX_DATE = "^\\d{4}-\\d{2}-\\d{2}$";
        public final String RGX_JSON_OBJECT = "\\{.+:.+(,.+:.+)*}";
        public final String RGX_JSON_ARRAY = "\\[(\\{.+:.+(,.+:.+)*})*]";
        public final String RGX_ALPHA_2 = "\\w{2}";
        public final String RGX_ALPHA_3 = "\\w{3}";
    }

    @UtilityClass
    public class Country {
        public final int MIN_LEN_LONG_NAME = 2;
        public final int MIN_LEN_SHORT_NAME = 2;

        public final int MAX_LEN_SHORT_NAME = Pow2.L31;
        public final int MAX_LEN_LONG_NAME = Pow2.L127;
        public final int MAX_LEN_ALPHA_2 = 2;
        public final int MAX_LEN_ALPHA_3 = 3;
        public final int MAX_LEN_NUMERIC = 3;
        public final int MAX_LEN_DIAL_CODE = 9;

        public static final String RGX_DIAL_CODE = "^\\+(\\d{1,3}\\-)?(\\d{1,4})$";
        public static final String RGX_NUMERIC = "\\d{3}";
    }

    @UtilityClass
    public class Language {
        public final int MIN_LEN_NAME = 2;
        public final int MIN_LEN_LOCAL_NAME = 2;

        public final int MAX_LEN_NAME = Pow2.L63;
        public final int MAX_LEN_LOCAL_NAME = Pow2.L63;
        public final int MAX_LEN_ALPHA2 = 2;
        public final int MAX_LEN_ALPHA3T = 3;
    }

    @UtilityClass
    public class PageRequest {
        public final int MIN_VAL_PAGE_NUMBER = 0;
        public final int MIN_VAL_PAGE_SIZE = 1;

        public final int MAX_VAL_PAGE_SIZE = 100;
        public final int MAX_SIZE_ORDER_COUNT = 3;
    }

    @UtilityClass
    public class Privilege {
        public final int MAX_LEN_NAME = Pow2.L63;
        public final int MAX_LEN_DESC = Pow2.L511;
    }

    @UtilityClass
    public class Role {
        public final int MAX_LEN_NAME = Pow2.L63;
        public final int MAX_LEN_DESC = Pow2.L511;
    }

    @UtilityClass
    public class TimeZone {
        public final int MIN_LEN_NAME = 2;

        public final int MAX_LEN_NAME = Pow2.L31;
    }

    @UtilityClass
    public class User {
        public final int MIN_LEN_USERNAME = 2;
        public final int MIN_LEN_FIRST_NAME = 2;
        public final int MIN_LEN_LAST_NAME = 2;
        public final int MIN_LEN_PW = 6;

        public final int MAX_LEN_USERNAME = 255;
        public final int MAX_LEN_EMAIL = 255;
        public final int MAX_LEN_PHONE_NUM = 17;
        public final int MAX_LEN_FIRST_NAME = Pow2.L31;
        public final int MAX_LEN_LAST_NAME = Pow2.L31;
        public final int MAX_LEN_BCRYPT_PW = 60;
        public final int MAX_LEN_PW = Pow2.L63;

        public final String RGX_EMAIL = "^\\w+(\\.\\w+)*@\\p{javaLowerCase}{2,12}+(\\.\\p{javaLowerCase}{2,6})+$";
        public final String RGX_PHONE_NUMBER = "^((\\+?\\d{1,3})?0?[\\s-]?)?\\(?0?\\d{3}\\)?[\\s-]?\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}$";
    }

}
