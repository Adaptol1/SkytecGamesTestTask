package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
public class Task
{
    private long id;
    private int gold;

    public Task(int gold)
    {
        this.gold = gold;
    }
}
