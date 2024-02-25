package service;

import dto.GoldSource;

public interface GoldTransactionService
{
    void registerGoldTransaction (long clanId, GoldSource goldSource, long sourceId, int gold);
}
