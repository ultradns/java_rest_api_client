/**
 *
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Task Status List.
 *
 * @author kushalraj.bhandari
 */
@JsonInclude(Include.NON_NULL)
public class TaskStatusList extends BaseQueryList {

    /**
     * List of {@link TaskStatusInfo}.
     */
    private List<TaskStatusInfo> tasks = Lists.newArrayList();

    /**
     * Empty constructor. -
     */
    public TaskStatusList() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param taskStatusList - taskStatusList
     * @param queryInfo      - queryInfo
     * @param resultInfo     - resultInfo
     */
    public TaskStatusList(List<TaskStatusInfo> taskStatusList, QueryInfo queryInfo, ResultInfo resultInfo) {
        super(queryInfo, resultInfo);
        this.tasks = taskStatusList;
    }

    public List<TaskStatusInfo> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskStatusInfo> tasks) {
        this.tasks = tasks;
    }
}
