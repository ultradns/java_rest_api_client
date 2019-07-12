package biz.neustar.ultra.rest.client.exception; /**
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UltraClientException extends Exception {

    private static final long serialVersionUID = -2299674268656112544L;
    private static final Logger LOGGER = LoggerFactory.getLogger(UltraClientException.class);
    private final String message;
    private Throwable throwable;

    public UltraClientException(String message, Throwable e) {
        super();
        this.message = message;
        this.throwable = e;
    }

    public UltraClientException(String message) {
        super();
        this.message = message;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return message;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        LOGGER.debug("Exception: " + throwable.getMessage());
        return "UltraClientException [message=" + message + "] \n";
    }

}
