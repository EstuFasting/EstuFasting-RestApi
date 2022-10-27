package edu.estu.estufastingrestapi.core.model.constants.validation;

public class SizeOf {

    public static class Num {

        public static class Min {
            public static final int PAGE_NUMBER = 0;
            public static final int PAGE_SIZE = 1;
        }

        public static class Max {
            public static final int PAGE_SIZE = 100;
            public static final int ORDER_COUNT = 3;
        }

    }

    public static class Text {

        public static class Min {
            public static final int UUID = 16;

            public static final int FIRST_NAME = 2;
            public static final int LAST_NAME = 2;
            public static final int PW = 6;
            public static final int ADDR = 20;

            public static final int LANGUAGE_ENGLISH_NAME = 2;
            public static final int LANGUAGE_LOCAL_NAME = 2;
            public static final int LANGUAGE_ALPHA2 = 2;
            public static final int LANGUAGE_ALPHA3T = 3;
        }

        public static class Max {
            public static final int UUID = 16;

            public static final int USERNAME = 255;
            public static final int EMAIL = 255;
            public static final int PHONE_NUM = 17;
            public static final int FIRST_NAME = Pow2.L31;
            public static final int LAST_NAME = Pow2.L31;
            public static final int BCRYPT_PW = 60;
            public static final int PW = Pow2.L63;

            public static final int ROLE_NAME = Pow2.L63;
            public static final int ROLE_DESC = Pow2.L511;

            public static final int PRIVILEGE_NAME = Pow2.L63;
            public static final int PRIVILEGE_DESC = Pow2.L511;

            public static final int DIAL_CODE = 3;

            public static final int LANGUAGE_ENGLISH_NAME = Pow2.L63;
            public static final int LANGUAGE_LOCAL_NAME = Pow2.L63;
            public static final int LANGUAGE_ALPHA2 = 2;
            public static final int LANGUAGE_ALPHA3T = 3;

            public static final int CUSTOMER_CARD_NO = Pow2.L31;
            public static final int CUSTOMER_TYPE_NAME = Pow2.L31;
            public static final int CUSTOMER_TYPE_DESC = Pow2.L127;
            public static final int DINING_HALL_NAME = Pow2.L31;
            public static final int DINING_HALL_ADDRESS_LINE = Pow2.L255;
            public static final int MENU_ITEM_NAME = Pow2.L31;
        }

    }

    private static class Pow2 {
        public static final int L1 = 1;
        public static final int L3 = 3;
        public static final int L7 = 7;
        public static final int L15 = 15;
        public static final int L31 = 31;
        public static final int L63 = 63;
        public static final int L127 = 127;
        public static final int L255 = 255;
        public static final int L511 = 511;
        public static final int L1023 = 1023;
        public static final int L2047 = 2047;
    }
}
