package org.seyovela.ids;

public enum MembershipStatus {
    ACTIVE(1),
    INVITED(2),
    DISABLED(3);

    private final int code;

    MembershipStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static MembershipStatus fromCode(int code) {
        for (MembershipStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown MembershipStatus code: " + code);
    }
}
