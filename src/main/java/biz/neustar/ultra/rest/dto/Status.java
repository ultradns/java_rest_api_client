package biz.neustar.ultra.rest.dto;

/*
 * User: jbodner
 * Date: 6/13/13
 * Time: 10:08 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class Status {
    private String message;

    /**
     * Default constructor.  The preferred constructor is the one with a parameter, but some deserialization
     * situations may require an empty constructor.  The message field should always be populated.
     */
    public Status() {
        //intentionally empty
    }

    public Status(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Status{" +
                "message='" + message + '\'' +
                '}';
    }
}
