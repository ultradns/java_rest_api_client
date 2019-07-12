/*
 * User: nupadhyay
 * Date: Apr 1, 2014
 * Time: 1:22:09 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Ping Probe Details.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PingProbeDetails implements ProbeDetails {

    private static final int DEFAULT_NUMBER_OF_PACKETS = 3;
    private static final int DEFAULT_PACKET_SIZE_IN_BYTES = 56;

    private Integer packets;
    private Integer packetSize;
    private PingLimitInfo limits;

    public PingProbeDetails() {
        super();
    }

    public PingProbeDetails(Integer packets, Integer packetSize, PingLimitInfo limits) {
        super();
        this.packets = packets;
        this.packetSize = packetSize;
        this.limits = limits;
    }

    public Integer getPackets() {
        return packets;
    }

    public void setPackets(Integer packets) {
        this.packets = packets;
    }

    public Integer getPacketSize() {
        return packetSize;
    }

    public void setPacketSize(Integer packetSize) {
        this.packetSize = packetSize;
    }

    public PingLimitInfo getLimits() {
        return limits;
    }

    public void setLimits(PingLimitInfo limits) {
        this.limits = limits;
    }

    public void setDefaultValue() {
        if (packets == null) {
            packets = DEFAULT_NUMBER_OF_PACKETS;
        }

        if (packetSize == null) {
            packetSize = DEFAULT_PACKET_SIZE_IN_BYTES;
        }
    }
}
