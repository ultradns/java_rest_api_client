/**
 * Copyright 2000-2018 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Objects;

@JsonInclude(Include.NON_NULL)
public class TransferStatusDetails {

    /**
     * Time when the zone transfer was last attempted.
     */
    private String lastRefresh;

    /**
     * Time when the zone transfer will be attempted next.
     */
    private String nextRefresh;

    /**
     * Last refresh status.
     */
    private TransferStatus lastRefreshStatus;

    /**
     * Refresh status message.
     */
    private String lastRefreshStatusMessage;

    /**
     * Default constructor.
     */
    public TransferStatusDetails() {
        super();
    }

    /**
     * Parameterised constructor.
     * @param lastRefresh - last attempt of zone transfer.
     * @param nextRefresh - next attempt of zone transfer.
     * @param lastRefreshStatus - last transfer status.
     * @param lastRefreshStatusMessage - last transfer status message.
     */
    public TransferStatusDetails(String lastRefresh, String nextRefresh,
            TransferStatus lastRefreshStatus, String lastRefreshStatusMessage) {
        this.lastRefresh = lastRefresh;
        this.nextRefresh = nextRefresh;
        this.lastRefreshStatus = lastRefreshStatus;
        this.lastRefreshStatusMessage = lastRefreshStatusMessage;
    }

    /**
     * Get lastRefresh value.
     * @return the lastRefresh
     */
    public String getLastRefresh() {
        return lastRefresh;
    }

    /**
     * Setter for setting lastRefresh.
     * @param lastRefresh the lastRefresh to set
     */
    public void setLastRefresh(String lastRefresh) {
        this.lastRefresh = lastRefresh;
    }

    /**
     * Get nextRefresh value.
     * @return the nextRefresh
     */
    public String getNextRefresh() {
        return nextRefresh;
    }

    /**
     * Setter for setting nextRefresh.
     * @param nextRefresh the nextRefresh to set
     */
    public void setNextRefresh(String nextRefresh) {
        this.nextRefresh = nextRefresh;
    }

    /**
     * Get lastRefreshStatus.
     * @return the lastRefreshStatus
     */
    public TransferStatus getLastRefreshStatus() {
        return lastRefreshStatus;
    }

    /**
     * Setter for setting lastRefreshStatus.
     * @param lastRefreshStatus the lastTransferStatus to set
     */
    public void setLastRefreshStatus(TransferStatus lastRefreshStatus) {
        this.lastRefreshStatus = lastRefreshStatus;
    }

    /**
     * Get lastRefreshStatusMessage.
     * @return the lastRefreshStatusMessage
     */
    public String getLastRefreshStatusMessage() {
        return lastRefreshStatusMessage;
    }

    /**
     * Setter for setting lastRefreshStatusMessage.
     * @param lastRefreshStatusMessage the lastRefreshStatusMessage to set
     */
    public void setLastRefreshStatusMessage(String lastRefreshStatusMessage) {
        this.lastRefreshStatusMessage = lastRefreshStatusMessage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLastRefresh(), getNextRefresh(), getLastRefreshStatus(),
                getLastRefreshStatusMessage());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TransferStatusDetails)) {
            return false;
        }
        final TransferStatusDetails other = (TransferStatusDetails) obj;
        return Objects.equals(getLastRefresh(), other.getLastRefresh())
                && Objects.equals(getNextRefresh(), other.getNextRefresh())
                && Objects.equals(getLastRefreshStatus(), other.getLastRefreshStatus())
                && Objects.equals(getLastRefreshStatusMessage(), other.getLastRefreshStatusMessage());
    }

    public enum TransferStatus {

        /**
         * Transfer request is queued.
         */
        QUEUED,

        /**
         * Transfer request is in progress.
         */
        IN_PROGRESS,

        /**
         * Transfer request is completed successfully.
         */
        SUCCESSFUL,

        /**
         * Transfer is failed.
         */
        FAILED,

        /**
         * Zone transfer has not been requested yet.
         */
        NOT_REQUESTED,

        /**
         * Zone is suspended.
         */
        PENDING
    }
}
