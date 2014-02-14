package biz.neustar.ultra.rest.constants;

/**
 * Sort options for listing zones.
 *
 */
public enum ZoneListSortType {
    NAME(1), ACCOUNT_NAME(3), RECORD_COUNT(4), ZONE_TYPE(2);
    private int value;

    ZoneListSortType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
