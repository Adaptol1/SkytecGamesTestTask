package service.impl;

import db.tables.TaskTable;
import dto.GoldSource;
import dto.Task;
import service.TaskService;

public class TaskServiceImpl implements TaskService
{
    private TaskTable taskTable = new TaskTable();

    @Override
    public Task get(long taskId)
    {
        return taskTable.findById(taskId);
    }
    @Override
    public void completeTask (long clanId, Task task, boolean success)
    {
        ClanServiceImpl clanService = ClanServiceImpl.getInstance();
        if (success)
        {
            clanService.changeGoldCount(clanId, GoldSource.COMPLETE_TASK, task.getId(), task.getGold());
            return;
        }
        else
            clanService.changeGoldCount(clanId, GoldSource.COMPLETE_TASK, task.getId(), (- task.getGold() / 2));
    }
}
