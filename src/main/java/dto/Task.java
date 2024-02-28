package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Task
{
    private long id;
    private int gold;

    public Task(int gold)
    {
        this.gold = gold;
    }

}
