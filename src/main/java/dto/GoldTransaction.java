package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
public class GoldTransaction
{
    private long id;

    private long clanId;

    private GoldSource goldSource;

    private long sourceId;

    private int transferredGold;

    private AtomicInteger totalGold;



    public GoldTransaction(long clanId, GoldSource goldSource,
                           long sourceId, int transferredGold,
                           AtomicInteger totalGold)
    {
        this.clanId = clanId;
        this.goldSource = goldSource;
        this.sourceId = sourceId;
        this.transferredGold = transferredGold;
        this.totalGold = totalGold;
    }
}
