package biz.neustar.ultra.rest.dto;

/*
 * User: jbodner
 * Date: 1/9/15
 * Time: 12:53 PM
 *
 * Copyright 2000-2014 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class PcapRequest {
    //date must be in yyyy-mm-dd format
    private String date;

    public PcapRequest() {
        //blank constructor
    }

    public PcapRequest(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
