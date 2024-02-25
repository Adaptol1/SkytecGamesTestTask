package service;

import dto.Task;

public interface TaskService
{
    Task get (long taskId);
    void completeTask (long clanId, Task task, boolean success);
}
