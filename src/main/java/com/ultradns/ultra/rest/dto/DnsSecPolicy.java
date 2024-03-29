/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ultradns.ultra.rest.constants.UltraRestSharedConstant;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsSecPolicy {

    private String algorithm;
    private UltraRestSharedConstant.DnssecType securityType;
    private Long rrsigSignatureDuration;
    private Nsec3Parameters nsec3Parameters;
    private List<KeyPolicy> keyPolicy;

    public DnsSecPolicy() {
        super();
    }

    public DnsSecPolicy(String algorithm, UltraRestSharedConstant.DnssecType securityType, Long rrsigSignatureDuration,
                        Nsec3Parameters nsec3Parameters, List<KeyPolicy> keyPolicy) {
        super();
        this.algorithm = algorithm;
        this.securityType = securityType;
        this.rrsigSignatureDuration = rrsigSignatureDuration;
        this.nsec3Parameters = nsec3Parameters;
        this.keyPolicy = keyPolicy;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public UltraRestSharedConstant.DnssecType getSecurityType() {
        return securityType;
    }

    public void setSecurityType(UltraRestSharedConstant.DnssecType securityType) {
        this.securityType = securityType;
    }

    public Long getRrsigSignatureDuration() {
        return rrsigSignatureDuration;
    }

    public void setRrsigSignatureDuration(Long rrsigSignatureDuration) {
        this.rrsigSignatureDuration = rrsigSignatureDuration;
    }

    public Nsec3Parameters getNsec3Parameters() {
        return nsec3Parameters;
    }

    public void setNsec3Parameters(Nsec3Parameters nsec3Parameters) {
        this.nsec3Parameters = nsec3Parameters;
    }

    public List<KeyPolicy> getKeyPolicy() {
        return keyPolicy;
    }

    public void setKeyPolicy(List<KeyPolicy> keyPolicy) {
        this.keyPolicy = keyPolicy;
    }
}
