/**
 *
 */
package biz.neustar.ultra.rest.constants;

import biz.neustar.ultra.rest.dto.TaskStatusInfo.Code;

/**
 * Task Status Code.
 *
 * @author kushalraj.bhandari
 */
public enum TaskStatusCode {
    PENDING(Code.PENDING),
    IN_PROCESS(Code.IN_PROCESS),
    COMPLETE(Code.COMPLETE),
    ERROR(Code.ERROR);

    private final Code code;

    TaskStatusCode(Code code) {
        this.code = code;
    }

    public static TaskStatusCode getCode(Code code) {
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

    public Code getCode() {
        return this.code;
    }
}
