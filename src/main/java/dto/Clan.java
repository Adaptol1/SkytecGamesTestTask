package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Clan
{
    private long id;
    private String name;
    private AtomicInteger gold;
}
