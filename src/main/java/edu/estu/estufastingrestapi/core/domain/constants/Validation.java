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
        public static final int MIN_LEN_CARD_NO = 7;

        public static final int MAX_LEN_TCKN = 11;
        public static final int MAX_LEN_CARD_NO = Pow2.L63;

        public final String RGX_TCKN = "\\d{11}";
    }

    @UtilityClass
    public class CustomerType {
        public static final int MIN_LEN_NAME = 2;
        public static final int MIN_LEN_DESC = 10;

        public static final int MAX_LEN_NAME = Pow2.L63;
        public static final int MAX_LEN_DESC = Pow2.L511;
    }

    @UtilityClass
    public class DiningHall {
        public static final int MIN_LEN_NAME = 5;
        public static final int MIN_LEN_DESC = 10;
        public static final int MIN_LEN_ADDRESS_LINE = 10;
        public static final int MIN_VAL_LATITUDE = -90;
        public static final int MIN_VAL_LONGITUDE = -180;
        public static final int MIN_VAL_CAPACITY = 1;

        public static final int MAX_LEN_NAME = Pow2.L63;
        public static final int MAX_LEN_DESC = Pow2.L127;
        public static final int MAX_LEN_ADDRESS_LINE = Pow2.L511;
        public static final int MAX_VAL_LATITUDE = 90;
        public static final int MAX_VAL_LONGITUDE = 180;
    }

    @UtilityClass
    public class Meal {
        public static final int MIN_LEN_NAME = 2;
        public static final int MAX_LEN_NAME = Pow2.L63;
    }

    @UtilityClass
    public class Menu {
    }

    @UtilityClass
    public class MenuItem {
        public static final int MIN_LEN_NAME = 1;
        public static final int MIN_VAL_CALORIES = 0;
        public static final int MAX_LEN_NAME = Pow2.L63;
    }

    @UtilityClass
    public class Reservation {
    }

    @UtilityClass
    public class Catering {
        public final int MIN_VAL_PRICE = 10;
        public final int MAX_SIZE_MENU_ITEM_COUNT = 4;
    }

    @UtilityClass
    public class Staff {
    }

    @UtilityClass
    public class Feedback {
        public final int MIN_LEN_CONTENT = 2;
        public final int MIN_LEN_TOPIC = 1;
        public static final int MIN_LEN_FULL_NAME = 2;

        public final int MAX_LEN_CONTENT = Pow2.L2047;
        public final int MAX_LEN_TOPIC = Pow2.L31;
        public static final int MAX_LEN_FULL_NAME = Pow2.L63;
        public static final int MAX_LEN_EMAIL = Common.MAX_LEN_EMAIL;
    }

    @UtilityClass
    public class Common {
        public final int UUID = 16;
        public final int MAX_LEN_EMAIL = Pow2.L255;

        public final String RGX_EMAIL = "^\\w+(\\.\\w+)*@\\p{javaLowerCase}{2,12}+(\\.\\p{javaLowerCase}{2,6})+$";
        public final String RGX_PHONE_NUMBER = "^\\+\\d{1,3}-\\d{3}-\\d{3}-\\d{2}-\\d{2}$";
        public final String RGX_UUID = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$";
        public final String RGX_WEBSITE = "^(w{3}\\.)?[^.]+(\\.\\p{javaLowerCase}{2,12})+$";
        public final String RGX_DATE = "^\\d{4}-\\d{2}-\\d{2}$";
        public final String RGX_JSON_OBJECT = "\\{.+:.+(,.+:.+)*}";
        public final String RGX_JSON_ARRAY = "\\[(\\{.+:.+(,.+:.+)*})*]";
        public final String RGX_ALPHA_2 = "[A-Z]{2}";
        public final String RGX_ALPHA_3 = "[A-Z]{3}";
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
    public class User {

        public final int MIN_LEN_FIRST_NAME = 2;
        public final int MIN_LEN_LAST_NAME = 2;
        public final int MIN_LEN_PW = 6;

        public final int MAX_LEN_EMAIL = Common.MAX_LEN_EMAIL;
        public final int MAX_LEN_PHONE_NUM = 17;
        public final int MAX_LEN_FIRST_NAME = Pow2.L31;
        public final int MAX_LEN_LAST_NAME = Pow2.L31;
        public final int MAX_LEN_BCRYPT_PW = 60;
        public final int MAX_LEN_PW = Pow2.L63;

        public final String RGX_EMAIL = Common.RGX_EMAIL;
        public final String RGX_PHONE_NUMBER = Common.RGX_PHONE_NUMBER;
    }

}
