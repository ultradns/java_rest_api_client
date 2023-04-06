/**
 *
 */
package com.ultradns.ultra.rest.constants;

import com.ultradns.ultra.rest.dto.TaskStatusInfo;

/**
 * Task Status Code.
 */
public enum TaskStatusCode {
    PENDING(TaskStatusInfo.Code.PENDING),
    IN_PROCESS(TaskStatusInfo.Code.IN_PROCESS),
    COMPLETE(TaskStatusInfo.Code.COMPLETE),
    ERROR(TaskStatusInfo.Code.ERROR);

    private final TaskStatusInfo.Code code;

    TaskStatusCode(TaskStatusInfo.Code code) {
        this.code = code;
    }

    public static TaskStatusCode getCode(TaskStatusInfo.Code code) {
        for (TaskStatusCode taskStatusCode : TaskStatusCode.values()) {
            if (taskStatusCode.code == code) {
                return taskStatusCode;
            }
        }
        throw new IllegalArgumentException();
    }

    public static TaskStatusCode getCode(String code) {
        for (TaskStatusCode taskStatusCode : TaskStatusCode.values()) {
            if (taskStatusCode.code.name().equals(code)) {
                return taskStatusCode;
            }
        }
        throw new IllegalArgumentException(code);
    }

    public TaskStatusInfo.Code getCode() {
        return this.code;
    }
}
