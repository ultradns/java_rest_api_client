/*
 * User: nupadhyay
 * Date: Sep 6, 2014
 * Time: 12:31:55 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import biz.neustar.ultra.rest.constants.UltraRestSharedConstant.DNSSecKeyType;
import biz.neustar.ultra.rest.constants.UltraRestSharedConstant.DnsSecStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DnsSecKey {

    private DNSSecKeyType type;
    private Integer bitLength;
    private Integer keyRolloverFrequency;
    private DnsSecStatus status;
    private String created;
    private String nextRoll;
    private Integer keyId;
    private String publicKey;
    private String dnsKeyData;
    private List<String> dsRecords;

    public DnsSecKey() {
        super();
    }

    public DnsSecKey(DNSSecKeyType type, Integer bitLength, Integer keyRolloverFrequency, DnsSecStatus status,
            String created, String nextRoll, Integer keyId) {
        super();
        this.type = type;
        this.bitLength = bitLength;
        this.keyRolloverFrequency = keyRolloverFrequency;
        this.status = status;
        this.created = created;
        this.nextRoll = nextRoll;
        this.keyId = keyId;
    }

    public DNSSecKeyType getType() {
        return type;
    }

    public void setType(DNSSecKeyType type) {
        this.type = type;
    }

    public Integer getBitLength() {
        return bitLength;
    }

    public void setBitLength(Integer bitLength) {
        this.bitLength = bitLength;
    }

    public Integer getKeyRolloverFrequency() {
        return keyRolloverFrequency;
    }

    public void setKeyRolloverFrequency(Integer keyRolloverFrequency) {
        this.keyRolloverFrequency = keyRolloverFrequency;
    }

    public DnsSecStatus getStatus() {
        return status;
    }

    public void setStatus(DnsSecStatus status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getNextRoll() {
        return nextRoll;
    }

    public void setNextRoll(String nextRoll) {
        this.nextRoll = nextRoll;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getDnsKeyData() {
        return dnsKeyData;
    }

    public void setDnsKeyData(String dnsKeyData) {
        this.dnsKeyData = dnsKeyData;
    }

    public List<String> getDsRecords() {
        return dsRecords;
    }

    public void setDsRecords(List<String> dsRecords) {
        this.dsRecords = dsRecords;
    }
}
