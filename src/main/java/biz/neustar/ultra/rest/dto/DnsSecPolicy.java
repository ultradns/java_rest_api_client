/*
 * User: nupadhyay
 * Date: Sep 6, 2014
 * Time: 12:27:05 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import biz.neustar.ultra.rest.constants.UltraRestSharedConstant.DnssecType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsSecPolicy {

    private String algorithm;
    private DnssecType securityType;
    private Long rrsigSignatureDuration;
    private Nsec3Parameters nsec3Parameters;
    private List<KeyPolicy> keyPolicy;

    public DnsSecPolicy() {
        super();
    }

    public DnsSecPolicy(String algorithm, DnssecType securityType, Long rrsigSignatureDuration,
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

    public DnssecType getSecurityType() {
        return securityType;
    }

    public void setSecurityType(DnssecType securityType) {
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
