package service.impl;

import db.tables.TaskTable;
import dto.GoldSource;
import dto.Task;
import service.ClanService;
import service.TaskService;

public class TaskServiceImpl implements TaskService
{
    private TaskTable taskTable;

    private ClanService clanService;
    @Override
    public Task get(long taskId)
    {
        return taskTable.findById(taskId);
    }
    @Override
    public void completeTask (long clanId, Task task, boolean success)
    {
        if (success)
        {
            clanService.changeGoldCount(clanId, GoldSource.COMPLETE_TASK, task.getId(), task.getGold());
            return;
        }
        clanService.changeGoldCount(clanId, GoldSource.COMPLETE_TASK, task.getId(), (- task.getGold() / 2));
    }
}
