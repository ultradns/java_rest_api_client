package com.ultradns.ultra.rest.dto;

/**
 * Copyright 2000-2015 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestProbeResponse {

    private List<TestProbeResDetails> probeResults;

    public List<TestProbeResDetails> getProbeResults() {
        return probeResults;
    }

    public void setProbeResults(List<TestProbeResDetails> probeResults) {
        this.probeResults = probeResults;
    }
}
