package biz.neustar.ultra.rest.client.testutil;

import biz.neustar.ultra.rest.client.RestApiClient;
import biz.neustar.ultra.rest.constants.TaskStatusCode;
import biz.neustar.ultra.rest.dto.TaskStatusInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/*
 * User: kbhandar
 * Date: 11/4/19
 *
 * Copyright 2019 Neustar, Inc. All rights reserved.
 * Neustar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of Neustar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public final class TaskUtil {
    private static final Logger LOG = LoggerFactory.getLogger(TaskUtil.class);

    private TaskUtil() {
        //does nothing, makes class a singleton
    }

    /**
     * Check if the task is completed with expected status.
     *
     * @param maxRetryCount     The max retry count.
     * @param intervalInSeconds The interval in seconds.
     * @param taskId            The task Id to check.
     */
    public static void checkTaskCompletedSuccessfully(final RestApiClient restApiClient, final int maxRetryCount,
            final int intervalInSeconds, String taskId) throws InterruptedException, IOException {
        LOG.info("Checking for task to finish with status as '{}' for task Id '{}'. ", TaskStatusCode.COMPLETE.name(),
                taskId);
        TaskStatusInfo taskStatusInfo = restApiClient.getTaskStatus(taskId);
        int pollCount = 0;
        while ((TaskStatusCode.PENDING == taskStatusInfo.getCode()
                || TaskStatusCode.IN_PROCESS == taskStatusInfo.getCode()) && pollCount != maxRetryCount) {
            pollCount++;
            LOG.info("Fetching task status for task Id '{}' with retry {} out of {}. ", taskId, pollCount,
                    maxRetryCount);
            Thread.sleep(TimeUnit.SECONDS.toMillis(intervalInSeconds));
            taskStatusInfo = restApiClient.getTaskStatus(taskId);
        }
        String taskStatus = taskStatusInfo.getCode().toString();
        assertTrue(String.format("For task Id '%s', expected status is '%s, but got '%s'.", taskId,
                TaskStatusCode.COMPLETE.name(), taskStatus),
                TaskStatusCode.COMPLETE.name().equalsIgnoreCase(taskStatus));
    }
}
