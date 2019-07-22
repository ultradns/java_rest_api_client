package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

@JsonInclude(Include.NON_NULL)
public class IP implements Comparable<IP> {

    /**
     * The starting ip address (v4) for an ip range.
     */
    private String start;
    /**
     * The ending ip address (v4) for an ip range.
     */
    private String end;
    /**
     * The CIDR format (v4) for an ip address range.
     */
    private String cidr;
    /**
     * A single IPv4 address.
     */
    private String address;

    /**
     * Used for sorting purpose.
     */
    private String lowSubnetIp6Address;

    /**
     * Empty constructor.
     */
    public IP() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param start   - {@link IP#start}
     * @param end     - {@link IP#end}
     * @param cidr    - {@link IP#cidr}
     * @param address - {@link IP#address}
     */
    public IP(String start, String end, String cidr, String address) {
        super();
        this.start = start;
        this.end = end;
        this.cidr = cidr;
        this.address = address;
    }

    /**
     * Get start.
     *
     * @return the start
     */
    public final String getStart() {
        return start;
    }

    /**
     * Set start.
     *
     * @param start the start to set
     */
    public final void setStart(String start) {
        this.start = start;
    }

    /**
     * Get end.
     *
     * @return the ip
     */
    public final String getEnd() {
        return end;
    }

    /**
     * Set end.
     *
     * @param end the ip to set
     */
    public final void setEnd(String end) {
        this.end = end;
    }

    /**
     * Get cidr.
     *
     * @return the cidr
     */
    public final String getCidr() {
        return cidr;
    }

    /**
     * Set cidr.
     *
     * @param cidr the cidr to set
     */
    public final void setCidr(String cidr) {
        this.cidr = cidr;
    }

    /**
     * Get address.
     *
     * @return the address
     */
    public final String getAddress() {
        return address;
    }

    /**
     * Set address.
     *
     * @param address the address to set
     */
    public final void setAddress(String address) {
        this.address = address;
    }

    @JsonIgnore
    public String getLowSubnetIp6Address() {
        return lowSubnetIp6Address;
    }

    @JsonIgnore
    public void setLowSubnetIp6Address(String lowSubnetIp6Address) {
        this.lowSubnetIp6Address = lowSubnetIp6Address;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("start", getStart())
                .add("end", getEnd())
                .add("address", getAddress())
                .add("cidr", getCidr())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getAddress(), getStart(), getEnd(), getCidr());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual;
        if (!(obj instanceof IP)) {
            return false;
        }
        final IP other = (IP) obj;
        isEqual = Objects.equal(getAddress(), other.getAddress()) && Objects.equal(getStart(), other.getStart())
                && Objects.equal(getEnd(), other.getEnd()) && Objects.equal(getCidr(), other.getCidr());
        return isEqual;
    }

    @Override
    public int compareTo(IP o) {
        return ComparisonChain.start()
                .compare(lowSubnetIp6Address, o.getLowSubnetIp6Address(), Ordering.natural().nullsLast())
                .compare(start, o.getStart(), Ordering.natural().nullsLast())
                .compare(end, o.getEnd(), Ordering.natural().nullsLast())
                .compare(address, o.getAddress(), Ordering.natural().nullsLast())
                .compare(cidr, o.getCidr(), Ordering.natural().nullsLast())
                .result();
    }
}
