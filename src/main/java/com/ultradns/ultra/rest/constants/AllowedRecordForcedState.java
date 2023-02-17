package com.ultradns.ultra.rest.constants;

/**
 * An Enum that represents a Records State in Terms of Forcing its state. The entire idea of "forcing" is whether or not
 * you are overriding what the SMADS probe is discovering. If a record is going to be enabled or disabled based on
 * whether the probe works, the state is NOT_FORCED If a record is going to always be turned on, no matter what, that's
 * FORCED_ACTIVE. and if a record is going to always be turned off, no matter what, that's FORCED_INACTIVE.
 */
public enum AllowedRecordForcedState {
    NOT_FORCED,
    FORCED_ACTIVE,
    FORCED_INACTIVE;
}
