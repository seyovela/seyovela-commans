package org.seyovela.ids;

/**
 * Common lifecycle status for organizations, products, tenants, and mappings.
 */
public enum RecordStatus {
    ACTIVE(1),
    SUSPENDED(2);

    private final int code;

    RecordStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static RecordStatus fromCode(int code) {
        for (RecordStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown RecordStatus code: " + code);
    }
}
