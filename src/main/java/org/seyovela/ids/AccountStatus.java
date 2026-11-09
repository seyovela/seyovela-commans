package org.seyovela.ids;

public enum AccountStatus {
    ACTIVE(1),
    LOCKED(2),
    DISABLED(3);

    private final int code;

    AccountStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AccountStatus fromCode(int code) {
        for (AccountStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown AccountStatus code: " + code);
    }
}
