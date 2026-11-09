package org.seyovela.ids;

public enum OrgRole {
    OWNER(1),
    ADMIN(2),
    MEMBER(3);

    private final int code;

    OrgRole(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrgRole fromCode(int code) {
        for (OrgRole value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown OrgRole code: " + code);
    }
}
