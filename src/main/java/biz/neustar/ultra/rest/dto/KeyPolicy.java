/*
 * User: nupadhyay
 * Date: Sep 6, 2014
 * Time: 12:49:50 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import biz.neustar.ultra.rest.constants.UltraRestSharedConstant.DNSSecKeyType;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeyPolicy {

    private DNSSecKeyType type;
    private Integer bitLength;
    private Integer keyRolloverFrequency;

    public KeyPolicy() {
        super();
    }

    public KeyPolicy(DNSSecKeyType type, Integer bitLength, Integer keyRolloverFrequency) {
        super();
        this.type = type;
        this.bitLength = bitLength;
        this.keyRolloverFrequency = keyRolloverFrequency;
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
}
