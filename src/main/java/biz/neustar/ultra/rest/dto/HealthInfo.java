package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthInfo {
    /**
     * Name of the service.
     */
    private String name;
    /**
     * Version of the service.
     */
    private String version;
    /**
     * DB Status of the database service is using.
     */
    private DBStatus dbStatus;
    /**
     * DB URL of the database service is using.
     */
    private String dbUrl;
    /**
     * DB User of the database service is using.
     */
    private String dbUser;
    /**
     * Service's health check URL.
     */
    private String serviceUrl;
    /**
     * List of dependent services' health.
     */
    private List<HealthInfo> dependencies;
    /**
     * Set to true if unable to contact the remote service, false or null otherwise.
     */
    private Boolean failed;

    public HealthInfo() {
        super();
    }

    public HealthInfo(String name, String serviceUrl, String version, String dbUrl, String dbUser, DBStatus dbStatus,
            List<HealthInfo> dependencies) {
        this.name = name;
        this.serviceUrl = serviceUrl;
        this.version = version;
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbStatus = dbStatus;
        this.dependencies = dependencies;
    }

    public static HealthInfo getFailedHealthInfo(String name) {
        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setName(name);
        healthInfo.failed = Boolean.TRUE;
        return healthInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<HealthInfo> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<HealthInfo> dependencies) {
        this.dependencies = dependencies;
    }

    public DBStatus getDbStatus() {
        return dbStatus;
    }

    public void setDbStatus(DBStatus dbStatus) {
        this.dbStatus = dbStatus;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public Boolean getFailed() {
        return failed;
    }

    public void setFailed(Boolean failed) {
        this.failed = failed;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    @Override
    public String toString() {
        return "HealthInfo{" + "name='" + name + '\'' + ", version='" + version + '\'' + ", serviceUrl='" + serviceUrl
                + '\'' + ", dbStatus=" + dbStatus + ", dbUrl='" + dbUrl + '\'' + ", dbUser='" + dbUser + '\''
                + ", failed=" + failed + ", dependencies=" + dependencies + '}';
    }

    public enum DBStatus {
        OK,
        FAIL,
        UNKNOWN
    }
}
