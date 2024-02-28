package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GoldTransaction
{
    private long id;

    private long clanId;

    private GoldSource goldSource;

    private long sourceId;

    private int transferredGold;

    private int totalGold;

    public GoldTransaction(long clanId, GoldSource goldSource,
                           long sourceId, int transferredGold,
                           int totalGold)
    {
        this.clanId = clanId;
        this.goldSource = goldSource;
        this.sourceId = sourceId;
        this.transferredGold = transferredGold;
        this.totalGold = totalGold;
    }

}
