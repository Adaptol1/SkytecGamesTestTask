package application;

import db.tables.ClanTable;
import db.tables.GoldTransactionTable;
import db.tables.TaskTable;
import db.tables.UserTable;
import dto.Clan;
import dto.Task;
import dto.User;
import service.TaskService;
import service.UserDonateService;
import service.impl.TaskServiceImpl;
import service.impl.UserDonateServiceImpl;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class SkytecApplication
{
    private ClanTable clanTable = new ClanTable();

    private GoldTransactionTable transactionTable = new GoldTransactionTable();

    private TaskTable taskTable = new TaskTable();

    private UserTable userTable = new UserTable();

    private TaskService taskService = new TaskServiceImpl();

    private UserDonateService userService = new UserDonateServiceImpl();

    public void createAndFillTables()
    {
        clanTable.create();
        transactionTable.create();
        taskTable.create();
        userTable.create();
        clanTable.add(new Clan("Only clan", new AtomicInteger(0)));

        for (int i = 0; i < 200; i++) {
            taskTable.add(new Task(50));
            userTable.add(new User(1));
        }
    }

    public void startApplication(Integer maxThreadCount)
    {
        ExecutorService threadPool = newFixedThreadPool(maxThreadCount);
        Iterator<User> userIterator = userTable.findAll().iterator();
        Iterator<Task> taskIterator = taskTable.findAll().iterator();

        for(int i = 0; i < maxThreadCount; i += 2)
        {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    while (userIterator.hasNext())
                    {
                        User user = userIterator.next();
                        userService.donateGoldToClan(user, 25);
                        System.out.println("user " + user.getId() + " donated");
                    }
                }
            });

            if (i + 1 == maxThreadCount)
                break;

            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    while(taskIterator.hasNext())
                    {
                        Task task = taskIterator.next();
                        taskService.completeTask(1, task, true);
                        System.out.println("task " + task.getId() + " is done");
                    }
                }
            });

        }

        threadPool.shutdown();
    }

    public void dropAllTables()
    {
        clanTable.drop();
        transactionTable.drop();
        taskTable.drop();
        userTable.drop();
    }

}
