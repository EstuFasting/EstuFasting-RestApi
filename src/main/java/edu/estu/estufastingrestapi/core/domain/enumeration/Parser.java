package edu.estu.estufastingrestapi.core.domain.enumeration;

import java.util.function.Function;

public enum Parser {
    IDENTITY(Function.identity()),
    UUID(java.util.UUID::fromString),
    ;

    final Function<String, ?> parseFunction;

    Parser(Function<String, ?> parseFunction) {
        this.parseFunction = parseFunction;
    }

    public Object parse(String source) {
        return parseFunction.apply(source);
    }

}
