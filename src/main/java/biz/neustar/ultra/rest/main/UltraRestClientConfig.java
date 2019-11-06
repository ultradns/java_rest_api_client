package biz.neustar.ultra.rest.main;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import org.apache.http.HttpStatus;

import java.util.Set;

/*
 * User: kbhandar
 * Date: 10/25/19
 *
 * Copyright 2019 Neustar, Inc. All rights reserved.
 * Neustar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of Neustar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class UltraRestClientConfig {

    private final RetryOptions retryOptions;

    public UltraRestClientConfig(RetryOptions retryOptions) {
        this.retryOptions = retryOptions;
    }

    public RetryOptions getRetryOptions() {
        return retryOptions;
    }

    public static class RetryOptions {
        private static final int SC_TOO_MANY_REQUESTS = 429;
        private static final int MAX_RETRY_ATTEMPTS_ALLOWED = 3;

        private static final int MAX_RETRY_ATTEMPTS_DEFAULT = 3;
        private static final int RETRY_SLEEP_INTERVAL_MILLIS = 2000;

        private static final Set<Integer> SUPPORTED_RETRY_STATUS_CODES = Sets.newHashSet(
                HttpStatus.SC_INTERNAL_SERVER_ERROR, HttpStatus.SC_SERVICE_UNAVAILABLE, HttpStatus.SC_GATEWAY_TIMEOUT,
                SC_TOO_MANY_REQUESTS);

        private final int maxRetryAttempts;
        private final Set<Integer> retryOnStatusCodes;
        private final int retrySleepIntervalInMillis;

        public RetryOptions() {
            this(MAX_RETRY_ATTEMPTS_DEFAULT, Sets.newHashSet(HttpStatus.SC_INTERNAL_SERVER_ERROR),
                    RETRY_SLEEP_INTERVAL_MILLIS);
        }

        public RetryOptions(int maxRetryAttempts, Set<Integer> retryOnStatusCodes, int retrySleepIntervalInMillis) {
            Preconditions.checkArgument(maxRetryAttempts <= MAX_RETRY_ATTEMPTS_ALLOWED,
                    "The maximum retry attempts cannot exceed " + MAX_RETRY_ATTEMPTS_ALLOWED);
            Preconditions.checkArgument(
                    retryOnStatusCodes != null && !retryOnStatusCodes.isEmpty() && Sets.difference(retryOnStatusCodes,
                            SUPPORTED_RETRY_STATUS_CODES).isEmpty(),
                    "Please provide valid status codes. The following status codes are currently supported: "
                            + SUPPORTED_RETRY_STATUS_CODES);
            this.maxRetryAttempts = maxRetryAttempts;
            this.retryOnStatusCodes = retryOnStatusCodes;
            this.retrySleepIntervalInMillis = retrySleepIntervalInMillis;
        }

        public int getMaxRetryAttempts() {
            return maxRetryAttempts;
        }

        public Set<Integer> getRetryOnStatusCodes() {
            return retryOnStatusCodes;
        }

        public int getRetrySleepIntervalInMillis() {
            return retrySleepIntervalInMillis;
        }
    }
}
