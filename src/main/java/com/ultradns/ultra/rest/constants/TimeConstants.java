package com.ultradns.ultra.rest.constants;

/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public final class TimeConstants {

    public static final int SECONDS_IN_DAY = 86_400;
    public static final int DAYS_IN_WEEK = 7;
    public static final int DAYS_IN_FORTNIGHT = 14;
    //yes, this isn't true 2/3 of the time.  But that's what we use internally
    public static final int DAYS_IN_MONTH = 30;

    private TimeConstants() {
        //don't instantiate
    }
}
