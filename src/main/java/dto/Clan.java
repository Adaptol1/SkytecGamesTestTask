package dto;

import lombok.*;

import java.io.Serial;
import java.util.concurrent.atomic.AtomicInteger;


@Getter
@Setter
@AllArgsConstructor
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
