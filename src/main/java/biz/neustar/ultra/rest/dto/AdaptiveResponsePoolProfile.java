package biz.neustar.ultra.rest.dto;

import java.util.List;
import java.util.Objects;

public class AdaptiveResponsePoolProfile {

    private static final int SIZE_86 = 86;

    private String description;

    private List<AdaptiveResponseRecord> rdataInfo;

    private List<AdaptiveResponseAllFailRecord> backupRecords;

    private ARPoolConfiguration configuration;

    public AdaptiveResponsePoolProfile() {
        super();
    }

    public AdaptiveResponsePoolProfile(String description, List<AdaptiveResponseRecord> rDataInfo) {
        this();
        this.description = description;
        this.rdataInfo = rDataInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AdaptiveResponseRecord> getRdataInfo() {
        return rdataInfo;
    }

    public void setRdataInfo(List<AdaptiveResponseRecord> rDataInfo) {
        this.rdataInfo = rDataInfo;
    }

    public ARPoolConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ARPoolConfiguration configuration) {
        this.configuration = configuration;
    }

    public List<AdaptiveResponseAllFailRecord> getBackupRecords() {
        return backupRecords;
    }

    public void setBackupRecords(List<AdaptiveResponseAllFailRecord> backupRecords) {
        this.backupRecords = backupRecords;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AdaptiveResponsePoolProfile)) {
            return false;
        }
        final AdaptiveResponsePoolProfile other = (AdaptiveResponsePoolProfile) obj;
        return Objects.equals(getDescription(), other.getDescription()) && Objects.equals(getRdataInfo(),
                other.getRdataInfo()) && Objects.equals(getBackupRecords(), other.getBackupRecords()) && Objects.equals(
                getConfiguration(), other.getConfiguration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getRdataInfo(), getBackupRecords(), getConfiguration());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(SIZE_86);
        builder.append("AdaptiveResponsePoolProfile [description=")
                .append(description)
                .append(", rdataInfo=")
                .append(rdataInfo)
                .append(", backupRecords=")
                .append(backupRecords)
                .append(", configuration=")
                .append(configuration)
                .append(']');
        return builder.toString();
    }

}
