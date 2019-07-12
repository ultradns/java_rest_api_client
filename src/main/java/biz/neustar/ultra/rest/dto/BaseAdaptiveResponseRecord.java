package biz.neustar.ultra.rest.dto;

public abstract class BaseAdaptiveResponseRecord {

    private RecordType type;
    private String configurationName;
    private String description;
    private ForcedState forcedState;
    private RecordState state;
    private Boolean probesEnabled;
    private String status;
    private Integer weight;

    public BaseAdaptiveResponseRecord() {
        super();
    }

    public RecordType getType() {
        return type;
    }

    public void setType(RecordType recordType) {
        this.type = recordType;
    }

    public String getConfigurationName() {
        return configurationName;
    }

    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ForcedState getForcedState() {
        return forcedState;
    }

    public void setForcedState(ForcedState forcedState) {
        this.forcedState = forcedState;
    }

    public RecordState getState() {
        return state;
    }

    public Boolean getProbesEnabled() {
        return probesEnabled;
    }

    public void setProbesEnabled(Boolean probesEnabled) {
        this.probesEnabled = probesEnabled;
    }

    public String getStatus() {
        return status;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setRecordState(RecordState recordState) {
        this.state = recordState;
    }

    public void setRecordStatus(String recordStatus) {
        this.status = recordStatus;
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    public enum RecordType {
        A,
        CNAME,
        SUBPOOL;
    }

    public enum RecordState {
        ACTIVE,
        INACTIVE,
        INACTIVE_DUE_TO_CNAME;
    }

    public enum ForcedState {
        NOT_FORCED,
        FORCED_ACTIVE,
        FORCED_INACTIVE;

        public static ForcedState fromValue(int v) {
            for (ForcedState c : ForcedState.values()) {
                if (c.ordinal() == v) {
                    return c;
                }
            }
            throw new IllegalArgumentException("Unknown forced state value: " + v);
        }
    }

}
