package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
