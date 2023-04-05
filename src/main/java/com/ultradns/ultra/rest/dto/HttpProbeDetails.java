/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Http Probe Details.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpProbeDetails implements ProbeDetails {

    /**
     * List of http requests sent for a single probe.
     */
    private List<TransactionInfo> transactions;
    /**
     * Run time for all steps in the sequence of an HTTP transactional probe for a warning/fail/critical to be
     * generated.
     */
    private ProbeStatus totalLimits;

    public HttpProbeDetails() {
        super();
    }

    public HttpProbeDetails(List<TransactionInfo> transactions, ProbeStatus totalLimits) {
        super();
        this.transactions = transactions;
        this.totalLimits = totalLimits;
    }

    public List<TransactionInfo> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionInfo> transactions) {
        this.transactions = transactions;
    }

    public ProbeStatus getTotalLimits() {
        return totalLimits;
    }

    public void setTotalLimits(ProbeStatus totalLimits) {
        this.totalLimits = totalLimits;
    }

    public void setDefaultValue() {
        if (transactions != null && !transactions.isEmpty()) {
            for (TransactionInfo info : transactions) {
                info.setDefaultValue();
            }
        }
        if (totalLimits == null) {
            totalLimits = new ProbeStatus();
        }
    }
}
