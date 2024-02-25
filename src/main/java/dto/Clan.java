package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;



@AllArgsConstructor
@Getter
@Setter
public class Clan
{
    private long id;
    private String name;
    private AtomicInteger gold;

    public Clan(String name, AtomicInteger gold)
    {
        this.name = name;
        this.gold = gold;
    }
}
