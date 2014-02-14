package biz.neustar.ultra.rest.constants;

/**
 * Sort constant for RR list.
 *
 */
public enum RRListSortType {
    OWNER("lname"), TTL("ttl"), TYPE("type"), VALUE("info1");
    /**
     * Value.
     */
    private final String value;

    RRListSortType(String value) {
        this.value = value;
    }

    /**
     * Get value.
     *
     * @return - int
     */
    public String getValue() {
        return this.value;
    }
}
