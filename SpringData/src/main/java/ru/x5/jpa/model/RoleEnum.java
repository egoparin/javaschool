package ru.x5.jpa.model;

/**
 * @author egor.oparin@x5.ru
 */
public enum RoleEnum {
    ADMIN("ADMIN"),
    OWNER("OWNER"),
    SIMPLE("SIMPLE");

    private RoleEnum(String code) {
        this.code = code;
    }

    private final String code;

    public String getCode() {
        return code;
    }
}

