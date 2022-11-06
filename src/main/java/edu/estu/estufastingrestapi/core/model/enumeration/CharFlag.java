package edu.estu.estufastingrestapi.core.model.enumeration;

public enum CharFlag {
    FALSE('0'),
    TRUE('1'),
    ;

    final Character flag;

    CharFlag(char flag) {
        this.flag = flag;
    }

    public Character asChar() {
        return flag;
    }
}