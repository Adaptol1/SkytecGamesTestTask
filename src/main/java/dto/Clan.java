package dto;

import lombok.AllArgsConstructor;
import java.util.concurrent.atomic.AtomicInteger;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized AtomicInteger getGold() {
        return gold;
    }

    public synchronized void setGold(AtomicInteger gold) {
        this.gold = gold;
    }
}
