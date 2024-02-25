package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
public class User
{
    private long id;
    private long clanId;

    public User(long clanId)
    {
        this.clanId = clanId;
    }
}
