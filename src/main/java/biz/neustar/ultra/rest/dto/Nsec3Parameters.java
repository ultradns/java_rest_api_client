/*
 * User: nupadhyay
 * Date: Sep 6, 2014
 * Time: 12:29:44 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Nsec3Parameters {

    private String hashAlgorithm;
    private Integer optOutFlag;
    private Integer iterations;
    private String salt;

    public Nsec3Parameters(String hashAlgorithm, Integer optOutFlag, Integer iterations, String salt) {
        super();
        this.hashAlgorithm = hashAlgorithm;
        this.optOutFlag = optOutFlag;
        this.iterations = iterations;
        this.salt = salt;
    }

    public Nsec3Parameters() {
        super();
    }

    public String getHashAlgorithm() {
        return hashAlgorithm;
    }

    public void setHashAlgorithm(String hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public Integer getOptOutFlag() {
        return optOutFlag;
    }

    public void setOptOutFlag(Integer optOutFlag) {
        this.optOutFlag = optOutFlag;
    }

    public Integer getIterations() {
        return iterations;
    }

    public void setIterations(Integer iterations) {
        this.iterations = iterations;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

}
